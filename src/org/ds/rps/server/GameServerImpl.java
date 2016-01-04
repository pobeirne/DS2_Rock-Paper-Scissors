/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ds.rps.server;

import java.io.*;
import org.ds.rps.interfaces.*;
import java.text.SimpleDateFormat;
import java.util.*;
import org.omg.CORBA.Any;
import org.omg.CORBA.AnyHolder;
import org.omg.CORBA.ORB;

/**
 * @author Paul O’Beirne - x10203800
 * @author Agnieszka Szczepankiewicz - x11103221
 * @version 1.0
 */
public class GameServerImpl implements GameInterfaceOperations {

    private final ORB orb;

    private Player player;
    private Player[] player_arr;
    private final Map<String, Player> players;

    private Game game;
    private final Map<String, Game> games;

    //private final ScoreBoard score_board;
    private Date curDate;
    private final SimpleDateFormat format;

    private boolean exCreateAlready;
    private boolean exCalculationAlready;
    private boolean exEndAlready = false;
    
    private boolean hasAPlayerLeft;

    /**
     *
     * @param orb
     */
    public GameServerImpl(ORB orb) {
        this.hasAPlayerLeft = false;
        this.exCreateAlready = false;
        this.exCalculationAlready = false;

        this.format = new SimpleDateFormat();
        this.curDate = new Date();
        this.orb = orb;
        this.players = new LinkedHashMap<>();
        this.games = new LinkedHashMap<>();
        //this.score_board = new ScoreBoard();

        this.player_arr = new Player[2];

    }

    /**
     * Adds player to player hash map 
     * @param player_name
     * @param callback
     * @return
     * @throws create_fail
     */
        @Override
    public String subscribe(String player_name, CallBack callback) throws create_fail {
        if (hasOpenSlot()) {
            player = new Player();
            player.id = UUID.randomUUID().toString();
            player.name = player_name;
            player.score = 0;
            player.isReady = true;
            player.choice = RPS.unselected;
            player.callback = callback;
            players.put(player.id, player);
            
            hasAPlayerLeft = false; 
            return player.id;
        } else {
            throw new create_fail();
        }
    }

    /**
     * Removes player from player hash map 
     * @param player_id
     * @return
     * @throws unknown_player
     */
    @Override
    public boolean unsubscribe(String player_id) throws unknown_player {
        if (isValidPlayer(player_id)){
            players.remove(player_id);
            hasAPlayerLeft = true;            
            return true;
        } else {
            throw new unknown_player();
        }
    }
    
    /**
     * Checks to see if a player has left the game
     * @return
     */
    @Override
    public boolean hasAPlayerLeft() {
        if (hasAPlayerLeft) { 
            players.clear();
        }
        return hasAPlayerLeft;
    }

    /**
     * Gets a players name by player id
     * @param player_id
     * @return
     * @throws unknown_player
     */
    @Override
    public String getPlayerNameById(String player_id) throws unknown_player {
        if (isValidPlayer(player_id)) {
            return players.get(player_id).name;
        } else {
            throw new unknown_player();
        }
    }

    /**
     * Checks players hash map for free space 
     * @return
     */
    @Override
    public boolean hasOpenSlot() {
        return players.size() < 2;
    }

    /**
     * Checks if player id is valid
     * @param player_id
     * @return
     * @throws unknown_player
     */
    @Override
    public boolean isValidPlayer(String player_id) throws unknown_player {
        return players.containsKey(player_id);
    }

    /**
     * Sets a player to ready
     * @param player_id
     * @param ready
     * @return
     * @throws unknown_player
     */
    @Override
    public boolean setPlayerIsReady(String player_id, boolean ready) throws unknown_player {
        if (isValidPlayer(player_id)) {
            if (players.containsKey(player_id)) {
                Player p = players.get(player_id);
                p.isReady = ready;
                players.put(p.id, p);
                return true;
            }
        } else {
            throw new unknown_player();
        }
        return false;
    }

    /**
     * Checks if both players are ready to start
     * @return
     */
    @Override
    public boolean checkIfPlayersAreReadyToStart() {
        if (!hasOpenSlot()) {
            if (getPlayerArray()[0].isReady == true && getPlayerArray()[1].isReady == true) {
                return startGame();
            }
        }
        return false;
    }

    /**
     * Sets a players selected choice
     * @param player_id
     * @param choice
     * @return
     * @throws unknown_player
     */
    @Override
    public boolean setPlayerSelection(String player_id, int choice) throws unknown_player {
        if (isValidPlayer(player_id)) {
            if (game.isActive) {
                if (players.containsKey(player_id)) {
                    Player p = players.get(player_id);
                    p.choice = getRPSChoice(choice);
                    players.put(p.id, p);
                    return true;
                }
            }
        } else {
            throw new unknown_player();
        }
        return false;
    }

    /**
     * Checks to see if both players have select 
     * @return
     */
    @Override
    public boolean checkIfPlayersHaveSelected() {
        if (game.isActive) {
            if (getPlayerArray()[0].choice.value() != 0 && getPlayerArray()[1].choice.value() != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compares players choices and assigns a winner
     * @return
     */
    @Override
    public boolean calculateResults() {
        if (!exCalculationAlready) {
            Player player1 = getPlayerArray()[0];
            Player player2 = getPlayerArray()[1];

            if (player1.choice.equals(player2.choice)) {
                game.winner_id = "";
                game.message = "draw";
            } else if (player1.choice == RPS.rock) {
                if (player2.choice == RPS.paper) {
                    game.winner_id = player2.id;
                    game.message = "rock is covered by paper";
                } else if (player2.choice == RPS.scissor) {
                    game.winner_id = player1.id;
                    game.message = "rock smashes scissors";
                }
            } else if (player1.choice == RPS.paper) {
                if (player2.choice == RPS.scissor) {
                    game.winner_id = player2.id;
                    game.message = "paper is cut by scissors";
                } else if (player2.choice == RPS.rock) {
                    //paper covers rock                       
                    game.winner_id = player1.id;
                    game.message = "paper covers rock";
                }
            } else if (player1.choice == RPS.scissor) {
                if (player2.choice == RPS.rock) {
                    game.winner_id = player2.id;
                    game.message = "scissors are smashed by rock ";
                } else if (player2.choice == RPS.paper) {
                    game.winner_id = player1.id;
                    game.message = "scissors cut paper ";
                }
            }
            exCalculationAlready = true;
        }
        return exCalculationAlready;
    }

    /**
    * Ends current game, reset variables and allocates score
    * @return 
    */
    @Override
    public boolean endCurrentGame() {
        if (!exEndAlready) {
            if (game.isActive) {
                if (players.containsKey(game.winner_id)) {
                    Player p = players.get(game.winner_id);
                    game.winner_name = p.name;
                    p.score = p.score + 1;
                    players.put(p.id, p);
                }
                game.isActive = false;
                games.put(game.id, game);
                resetClientState();
                exCreateAlready = false;
                exCalculationAlready = false;                
            }
            exEndAlready = true;
        }
        return exEndAlready;
    }

    /**
    * Callback method implementation 
     * @param player_id
     * @param message
     * @param callback
     * @throws org.ds.rps.interfaces.unknown_player
    */
    @Override
    public void event_listener(String player_id, String message, CallBack callback) throws unknown_player {
        if (isValidPlayer(player_id)) {
            Iterator<String> keySetIterator = players.keySet().iterator();
            while (keySetIterator.hasNext()) {
                String key = keySetIterator.next();
                callback = (CallBack) players.get(key).callback;
                if (callback != null) {
                    callback.message(message);
                }
            }
        } else {
            throw new unknown_player();
        }
    }
    
    /**
    * File transfer method implementation
     * @param file_name
     * @return 
     * @throws org.ds.rps.interfaces.unknown_path
    */
    @Override
    public byte[] getHowTooPlayFile(String file_name) throws unknown_path {
        File file = new File(file_name);
        byte buffer[] = new byte[(int) file.length()];
        try {
            try (BufferedInputStream input
                    = new BufferedInputStream(new FileInputStream(file_name))) {
                input.read(buffer, 0, buffer.length);
            }
        } catch (Exception e) {
            System.out.println("FileServant Error: " + e.getMessage());
        }
        return (buffer);
    }
    
    /**
    * Any method implementation for game details
     * @param player_id
     * @param anyGame
    */
    @Override
    public void currGameDetails(String player_id, AnyHolder anyGame) {
        try {
            if (isValidPlayer(player_id)) {
                Any anyDetails = orb.create_any();
                GameHelper.insert(anyDetails, game);
                anyGame.value = anyDetails;
            }
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace(System.out);
        }
    }

    /**
    * converts hashmap to array
    */
    private Player[] getPlayerArray() {
        player_arr = players.values().toArray(new Player[players.size()]);
        return player_arr;
    }

    /**
    * creates a new game and adds players
     * @return 
    */
    public boolean startGame() {
        if (!exCreateAlready) {

            curDate = new Date();
            game = new Game();

            game.id = UUID.randomUUID().toString();
            game.date = format.format(curDate.getTime());
            game.isActive = true;
            game.players = getPlayerArray();
            game.winner_id = "";
            game.winner_name = "";
            game.message = "";

            exCreateAlready = true;
            exEndAlready = false;  
            hasAPlayerLeft = false;
        }
        return exCreateAlready;
    }

    /**
    * Resets each player values
    */
    private void resetClientState() {
        Iterator<String> keySetIterator = players.keySet().iterator();
        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            Player p = players.get(key);
            p.choice = RPS.unselected;
            p.isReady = false;
            players.put(p.id, p);
        }
    }    
  
    /**
    * returns enum
    */
    private RPS getRPSChoice(int choice) {
        if (choice == 1) {
            return RPS.rock;
        } else if (choice == 2) {
            return RPS.paper;
        } else if (choice == 3) {
            return RPS.scissor;
        } else {
            return RPS.unselected;
        }
    }
    
    /**
    * Method: not used 
    * reset every players score 
    */
    private void resetClientScore() {
        Iterator<String> keySetIterator = players.keySet().iterator();
        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            Player p = players.get(key);
            p.score = 0;            
            players.put(p.id, p);
        }
    }

    /**
    * Test Method not required
    */
    public void print_clients() {
        Iterator<String> keySetIterator = players.keySet().iterator();
        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            System.out.println("\n key: " + key
                    + "\n Name: " + players.get(key).name
                    + "\n isReady: " + players.get(key).isReady
                    + "\n choice: " + players.get(key).choice
            );
        }
    }

    /**
    * Test Method not required
    */
    public void print_game() {
        System.out.println("\n gameId:" + game.id
                + "\n :" + game.date
                + "\n isActive:" + game.isActive
                + "\n players:" + game.players.length
                + "\n winner:" + game.winner_id
                + "\n message:" + game.message
        );
    }
}
