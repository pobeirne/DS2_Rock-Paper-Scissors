/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ds.rps.ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import org.ds.rps.interfaces.*;
import org.ds.rps.client.GameClient;
import org.omg.CORBA.Any;
import org.omg.CORBA.Request;
import org.omg.CORBA.TypeCode;

/**
 * @author Paul O’Beirne - x10203800 
 * @author Agnieszka Szczepankiewicz - x11103221
 * @version 1.0 
 */

public class GameClientUI extends JFrame {

    private final GameClient client;
    private final CallBack callback;

    private final CardLayout cardLayout;
    private final Stack cardStack;

    private final int timerTimeInMilliSeconds = 1000;

    private String player_id;
    private String player_name;
    private boolean ready;
    private boolean selected;

    private Any anyGameDetails;
    private Any arg;
    private Request request;
    private Game tempGameDetails;
    
    
    private final ImageIcon win_icon;
    private final ImageIcon lose_icon;
    private final ImageIcon draw_icon;

    /**
     * GUI Constructor
     */
    public GameClientUI() {

        initComponents();

        //Corba Client
        client = new GameClient(null);
        callback = new CallBack_Tie(new GameClientUI.CallBackImpl());

        //Card Layout
        cardStack = new Stack();
        cardLayout = (CardLayout) panelSection1.getLayout();
        cardLayout.show(panelSection1, "cardHome");
        addToPanelStack("cardHome");

        player_id = "";
        ready = false;
        selected = false;

        //Default Settings
        txtAreaScoreBoard.setWrapStyleWord(true);
        txtAreaScoreBoard.setLineWrap(true);
        txtAreaEventDisplay.setWrapStyleWord(true);
        txtAreaEventDisplay.setLineWrap(true);
        txtAreaHelp.setWrapStyleWord(true);
        txtAreaHelp.setLineWrap(true);

        
        win_icon = new ImageIcon(".//src//org//ds//rps//assets//winner.jpg");
        lose_icon = new ImageIcon(".//src//org//ds//rps//assets//loser.jpg");
        draw_icon = new ImageIcon(".//src//org//ds//rps//assets//draw.jpg");
        
        setDefaultCloseOperation(GameClientUI.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMainFooter = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        panelMainHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelMainContent = new javax.swing.JPanel();
        panelSection1 = new javax.swing.JPanel();
        cardHome = new javax.swing.JPanel();
        lblHomeTitle = new javax.swing.JLabel();
        btnHowToPlay = new javax.swing.JButton();
        btnPlayGame = new javax.swing.JButton();
        lblHomeWelcomeMsg = new javax.swing.JLabel();
        cardJoin = new javax.swing.JPanel();
        lblJoinTitle = new javax.swing.JLabel();
        btnJoinGoBack = new javax.swing.JButton();
        btnJoinGame = new javax.swing.JButton();
        txtJoinEnterName = new javax.swing.JTextField();
        lblJoinEnterName = new javax.swing.JLabel();
        cardGame = new javax.swing.JPanel();
        btnGameLeave = new javax.swing.JButton();
        btnGameReady = new javax.swing.JButton();
        lblGameTitle = new javax.swing.JLabel();
        lblGameSelection = new javax.swing.JLabel();
        rbtnRock = new javax.swing.JRadioButton();
        rbtnPaper = new javax.swing.JRadioButton();
        rbtnScissiors = new javax.swing.JRadioButton();
        btnGameHowToPlay = new javax.swing.JButton();
        cardResult = new javax.swing.JPanel();
        lblResultTitle = new javax.swing.JLabel();
        btnResultLeave = new javax.swing.JButton();
        btnResultPlayAgain = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cardlHelp = new javax.swing.JPanel();
        scrollPaneHelp = new javax.swing.JScrollPane();
        txtAreaHelp = new javax.swing.JTextArea();
        lblHelpTitle = new javax.swing.JLabel();
        btnHelpGoBack = new javax.swing.JButton();
        cardWaiting = new javax.swing.JPanel();
        lblWaitMessage = new javax.swing.JLabel();
        panelSection2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaEventDisplay = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaScoreBoard = new javax.swing.JTextArea();
        lblPlayerName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paper, Rock & Scissors");
        setMinimumSize(new java.awt.Dimension(812, 600));
        setResizable(false);

        panelMainFooter.setBackground(new java.awt.Color(0, 0, 0));

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panelMainFooterLayout = new org.jdesktop.layout.GroupLayout(panelMainFooter);
        panelMainFooter.setLayout(panelMainFooterLayout);
        panelMainFooterLayout.setHorizontalGroup(
            panelMainFooterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelMainFooterLayout.createSequentialGroup()
                .addContainerGap(693, Short.MAX_VALUE)
                .add(btnExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 109, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelMainFooterLayout.setVerticalGroup(
            panelMainFooterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelMainFooterLayout.createSequentialGroup()
                .add(8, 8, 8)
                .add(btnExit, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(8, 8, 8))
        );

        panelMainHeader.setBackground(new java.awt.Color(0, 153, 204));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Rock Paper Scissiors");

        org.jdesktop.layout.GroupLayout panelMainHeaderLayout = new org.jdesktop.layout.GroupLayout(panelMainHeader);
        panelMainHeader.setLayout(panelMainHeaderLayout);
        panelMainHeaderLayout.setHorizontalGroup(
            panelMainHeaderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMainHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMainHeaderLayout.setVerticalGroup(
            panelMainHeaderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMainHeaderLayout.createSequentialGroup()
                .add(10, 10, 10)
                .add(jLabel3)
                .add(10, 10, 10))
        );

        panelMainContent.setBackground(new java.awt.Color(255, 255, 255));

        panelSection1.setLayout(new java.awt.CardLayout());

        cardHome.setBackground(new java.awt.Color(204, 0, 102));
        cardHome.setPreferredSize(new java.awt.Dimension(392, 476));

        lblHomeTitle.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblHomeTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblHomeTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHomeTitle.setText("Home Panel");

        btnHowToPlay.setText("How To Play");
        btnHowToPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHowToPlayActionPerformed(evt);
            }
        });

        btnPlayGame.setText("Play Game");
        btnPlayGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayGameActionPerformed(evt);
            }
        });

        lblHomeWelcomeMsg.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblHomeWelcomeMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblHomeWelcomeMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHomeWelcomeMsg.setText("Welcome Guest !!!");

        org.jdesktop.layout.GroupLayout cardHomeLayout = new org.jdesktop.layout.GroupLayout(cardHome);
        cardHome.setLayout(cardHomeLayout);
        cardHomeLayout.setHorizontalGroup(
            cardHomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cardHomeLayout.createSequentialGroup()
                .addContainerGap()
                .add(cardHomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblHomeTitle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(lblHomeWelcomeMsg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 372, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cardHomeLayout.createSequentialGroup()
                        .add(btnHowToPlay)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btnPlayGame)))
                .addContainerGap())
        );

        cardHomeLayout.linkSize(new java.awt.Component[] {btnHowToPlay, btnPlayGame}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        cardHomeLayout.setVerticalGroup(
            cardHomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cardHomeLayout.createSequentialGroup()
                .addContainerGap()
                .add(lblHomeTitle)
                .add(139, 139, 139)
                .add(lblHomeWelcomeMsg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 257, Short.MAX_VALUE)
                .add(cardHomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnHowToPlay)
                    .add(btnPlayGame))
                .addContainerGap())
        );

        cardHomeLayout.linkSize(new java.awt.Component[] {btnHowToPlay, btnPlayGame}, org.jdesktop.layout.GroupLayout.VERTICAL);

        panelSection1.add(cardHome, "cardHome");

        cardJoin.setBackground(new java.awt.Color(51, 51, 255));

        lblJoinTitle.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblJoinTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblJoinTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJoinTitle.setText("Join Game Panel");

        btnJoinGoBack.setText("Go Back");
        btnJoinGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinGoBackActionPerformed(evt);
            }
        });

        btnJoinGame.setText("Play Game");
        btnJoinGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinGameActionPerformed(evt);
            }
        });

        txtJoinEnterName.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        txtJoinEnterName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblJoinEnterName.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblJoinEnterName.setForeground(new java.awt.Color(255, 255, 255));
        lblJoinEnterName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJoinEnterName.setText("Enter name Here !!!");

        org.jdesktop.layout.GroupLayout cardJoinLayout = new org.jdesktop.layout.GroupLayout(cardJoin);
        cardJoin.setLayout(cardJoinLayout);
        cardJoinLayout.setHorizontalGroup(
            cardJoinLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cardJoinLayout.createSequentialGroup()
                .add(55, 55, 55)
                .add(txtJoinEnterName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 282, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, cardJoinLayout.createSequentialGroup()
                .addContainerGap()
                .add(cardJoinLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, cardJoinLayout.createSequentialGroup()
                        .add(btnJoinGoBack)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btnJoinGame))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, cardJoinLayout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(lblJoinEnterName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 372, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(cardJoinLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(cardJoinLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(lblJoinTitle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        cardJoinLayout.linkSize(new java.awt.Component[] {btnJoinGame, btnJoinGoBack}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        cardJoinLayout.setVerticalGroup(
            cardJoinLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, cardJoinLayout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .add(lblJoinEnterName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(txtJoinEnterName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(215, 215, 215)
                .add(cardJoinLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnJoinGoBack)
                    .add(btnJoinGame))
                .addContainerGap())
            .add(cardJoinLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(cardJoinLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(lblJoinTitle)
                    .addContainerGap(478, Short.MAX_VALUE)))
        );

        cardJoinLayout.linkSize(new java.awt.Component[] {btnJoinGame, btnJoinGoBack}, org.jdesktop.layout.GroupLayout.VERTICAL);

        panelSection1.add(cardJoin, "cardJoin");

        cardGame.setBackground(new java.awt.Color(0, 102, 0));

        btnGameLeave.setText("Leave Game");
        btnGameLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameLeaveActionPerformed(evt);
            }
        });

        btnGameReady.setText("Ready");
        btnGameReady.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameReadyActionPerformed(evt);
            }
        });

        lblGameTitle.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblGameTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblGameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGameTitle.setText("Game Panel");

        lblGameSelection.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblGameSelection.setForeground(new java.awt.Color(255, 255, 255));
        lblGameSelection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGameSelection.setText("Select Option");

        rbtnRock.setBackground(new java.awt.Color(255, 255, 255));
        rbtnRock.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rbtnRock.setText("   Rock");

        rbtnPaper.setBackground(new java.awt.Color(255, 255, 255));
        rbtnPaper.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rbtnPaper.setText("   Paper");

        rbtnScissiors.setBackground(new java.awt.Color(255, 255, 255));
        rbtnScissiors.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rbtnScissiors.setText("   Scissiors");

        btnGameHowToPlay.setText("How To Play");
        btnGameHowToPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameHowToPlayActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout cardGameLayout = new org.jdesktop.layout.GroupLayout(cardGame);
        cardGame.setLayout(cardGameLayout);
        cardGameLayout.setHorizontalGroup(
            cardGameLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cardGameLayout.createSequentialGroup()
                .addContainerGap()
                .add(cardGameLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblGameTitle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(cardGameLayout.createSequentialGroup()
                        .add(btnGameLeave)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btnGameReady))
                    .add(cardGameLayout.createSequentialGroup()
                        .add(lblGameSelection, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 372, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, cardGameLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(cardGameLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(btnGameHowToPlay)
                    .add(cardGameLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(rbtnScissiors)
                        .add(rbtnPaper)
                        .add(rbtnRock)))
                .add(147, 147, 147))
        );

        cardGameLayout.linkSize(new java.awt.Component[] {btnGameLeave, btnGameReady}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        cardGameLayout.linkSize(new java.awt.Component[] {rbtnPaper, rbtnRock, rbtnScissiors}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        cardGameLayout.setVerticalGroup(
            cardGameLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cardGameLayout.createSequentialGroup()
                .addContainerGap()
                .add(lblGameTitle)
                .add(139, 139, 139)
                .add(lblGameSelection, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(39, 39, 39)
                .add(rbtnRock)
                .add(18, 18, 18)
                .add(rbtnPaper)
                .add(18, 18, 18)
                .add(rbtnScissiors)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 113, Short.MAX_VALUE)
                .add(cardGameLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnGameLeave)
                    .add(btnGameReady)
                    .add(btnGameHowToPlay))
                .addContainerGap())
        );

        cardGameLayout.linkSize(new java.awt.Component[] {btnGameLeave, btnGameReady}, org.jdesktop.layout.GroupLayout.VERTICAL);

        cardGameLayout.linkSize(new java.awt.Component[] {rbtnPaper, rbtnRock, rbtnScissiors}, org.jdesktop.layout.GroupLayout.VERTICAL);

        panelSection1.add(cardGame, "cardGame");

        cardResult.setBackground(new java.awt.Color(0, 51, 51));

        lblResultTitle.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblResultTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblResultTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultTitle.setText("Result Panel");

        btnResultLeave.setText("Leave Game");
        btnResultLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultLeaveActionPerformed(evt);
            }
        });

        btnResultPlayAgain.setText("Play Again");
        btnResultPlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultPlayAgainActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        org.jdesktop.layout.GroupLayout cardResultLayout = new org.jdesktop.layout.GroupLayout(cardResult);
        cardResult.setLayout(cardResultLayout);
        cardResultLayout.setHorizontalGroup(
            cardResultLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cardResultLayout.createSequentialGroup()
                .addContainerGap()
                .add(cardResultLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 372, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblResultTitle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(cardResultLayout.createSequentialGroup()
                        .add(btnResultLeave)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btnResultPlayAgain)))
                .addContainerGap())
        );
        cardResultLayout.setVerticalGroup(
            cardResultLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cardResultLayout.createSequentialGroup()
                .addContainerGap()
                .add(lblResultTitle)
                .add(84, 84, 84)
                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 279, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 81, Short.MAX_VALUE)
                .add(cardResultLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnResultLeave)
                    .add(btnResultPlayAgain))
                .addContainerGap())
        );

        panelSection1.add(cardResult, "cardResult");

        cardlHelp.setBackground(new java.awt.Color(204, 204, 255));

        txtAreaHelp.setEditable(false);
        txtAreaHelp.setColumns(20);
        txtAreaHelp.setRows(5);
        txtAreaHelp.setWrapStyleWord(true);
        scrollPaneHelp.setViewportView(txtAreaHelp);

        lblHelpTitle.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblHelpTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblHelpTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelpTitle.setText("Help Panel");

        btnHelpGoBack.setText("Go Back");
        btnHelpGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpGoBackActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout cardlHelpLayout = new org.jdesktop.layout.GroupLayout(cardlHelp);
        cardlHelp.setLayout(cardlHelpLayout);
        cardlHelpLayout.setHorizontalGroup(
            cardlHelpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cardlHelpLayout.createSequentialGroup()
                .addContainerGap()
                .add(cardlHelpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblHelpTitle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .add(scrollPaneHelp)
                    .add(cardlHelpLayout.createSequentialGroup()
                        .add(btnHelpGoBack)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        cardlHelpLayout.setVerticalGroup(
            cardlHelpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cardlHelpLayout.createSequentialGroup()
                .addContainerGap()
                .add(lblHelpTitle)
                .add(24, 24, 24)
                .add(scrollPaneHelp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(btnHelpGoBack)
                .addContainerGap())
        );

        panelSection1.add(cardlHelp, "cardHelp");

        cardWaiting.setBackground(new java.awt.Color(102, 102, 0));

        lblWaitMessage.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblWaitMessage.setForeground(new java.awt.Color(255, 255, 255));
        lblWaitMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWaitMessage.setText("Waiting for other player !!");

        org.jdesktop.layout.GroupLayout cardWaitingLayout = new org.jdesktop.layout.GroupLayout(cardWaiting);
        cardWaiting.setLayout(cardWaitingLayout);
        cardWaitingLayout.setHorizontalGroup(
            cardWaitingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cardWaitingLayout.createSequentialGroup()
                .addContainerGap()
                .add(lblWaitMessage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 372, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardWaitingLayout.setVerticalGroup(
            cardWaitingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cardWaitingLayout.createSequentialGroup()
                .add(171, 171, 171)
                .add(lblWaitMessage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
        );

        panelSection1.add(cardWaiting, "cardWaiting");

        panelSection2.setBackground(new java.awt.Color(0, 0, 102));

        txtAreaEventDisplay.setEditable(false);
        txtAreaEventDisplay.setColumns(20);
        txtAreaEventDisplay.setRows(5);
        jScrollPane1.setViewportView(txtAreaEventDisplay);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Score Board");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Game Events");

        txtAreaScoreBoard.setEditable(false);
        txtAreaScoreBoard.setColumns(20);
        txtAreaScoreBoard.setRows(5);
        jScrollPane2.setViewportView(txtAreaScoreBoard);

        lblPlayerName.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblPlayerName.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerName.setText("Player Name: ");

        org.jdesktop.layout.GroupLayout panelSection2Layout = new org.jdesktop.layout.GroupLayout(panelSection2);
        panelSection2.setLayout(panelSection2Layout);
        panelSection2Layout.setHorizontalGroup(
            panelSection2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelSection2Layout.createSequentialGroup()
                .addContainerGap()
                .add(panelSection2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(lblPlayerName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSection2Layout.setVerticalGroup(
            panelSection2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelSection2Layout.createSequentialGroup()
                .addContainerGap()
                .add(lblPlayerName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(jLabel1)
                .add(18, 18, 18)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel2)
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout panelMainContentLayout = new org.jdesktop.layout.GroupLayout(panelMainContent);
        panelMainContent.setLayout(panelMainContentLayout);
        panelMainContentLayout.setHorizontalGroup(
            panelMainContentLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMainContentLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelSection1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelSection2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMainContentLayout.setVerticalGroup(
            panelMainContentLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMainContentLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelMainContentLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelSection1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelSection2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMainFooter, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(panelMainHeader, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(panelMainContent, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(panelMainHeader, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(panelMainContent, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(0, 0, 0)
                .add(panelMainFooter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHowToPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHowToPlayActionPerformed
        try {
            if (txtAreaHelp.getText().trim().equals("")) {
                populateHowToPlay();
            } else {
                cardLayout.show(panelSection1, "cardHelp");
                addToPanelStack("cardHelp");
            }
        } catch (IOException ex) {
            Logger.getLogger(GameClientUI.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHowToPlayActionPerformed

    private void btnHelpGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpGoBackActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelSection1, previousPanel());
    }//GEN-LAST:event_btnHelpGoBackActionPerformed

    private void btnPlayGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayGameActionPerformed
        // TODO add your handling code here:        
        cardLayout.show(panelSection1, "cardJoin");
        addToPanelStack("cardJoin");
    }//GEN-LAST:event_btnPlayGameActionPerformed

    private void btnJoinGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinGoBackActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelSection1, previousPanel());
    }//GEN-LAST:event_btnJoinGoBackActionPerformed

    private void btnJoinGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinGameActionPerformed
        // TODO add your handling code here:        
        try {
            if (!txtJoinEnterName.getText().equals("")) {
                player_name = txtJoinEnterName.getText();
                if (client.getServant().hasOpenSlot()) {
                    player_id = client.getServant().subscribe(player_name, callback);  
                    checkGameIsValid.start();
                    if (client.getServant().isValidPlayer(player_id)) {
                        lblPlayerName.setText("Player Name: "+player_name);
                        client.getServant().event_listener(player_id, player_name + ": has joined..", callback);
                        boolean isSet = client.getServant().setPlayerIsReady(player_id, true);                        
                        if (isSet) {                            
                            resetRadioValue();
                            client.getServant().event_listener(player_id, player_name + ": is ready....", callback);
                            ready = client.getServant().checkIfPlayersAreReadyToStart();
                            if (ready) {
                                cardStack.clear();
                                cardLayout.show(panelSection1, "cardGame");
                                addToPanelStack("cardGame");                                
                                if (!updateScoreBoard.isRunning()) {
                                    updateScoreBoard.start();                                                                    }
                            } else {
                                cardStack.clear();
                                cardLayout.show(panelSection1, "cardWaiting");
                                addToPanelStack("cardWaiting");
                                waitForPlayerToJoin.start();
                            }
                        }
                    } else {
                         txtAreaEventDisplay.append("\nPlayer_id is not valid!!");
                    }
                } else {
                    txtAreaEventDisplay.append("\nNo open slots!!");
                }
            } else {
                txtAreaEventDisplay.append("\nPlayer name cannot be empty!!");
            }
        } catch (unknown_player | create_fail ex) {
            Logger.getLogger(GameClientUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnJoinGameActionPerformed

    private void btnGameLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGameLeaveActionPerformed
        // TODO add your handling code here:                   
        try {
            client.getServant().event_listener(player_id, player_name + ": is leaving....", callback);
            client.getServant().unsubscribe(player_id);
            cardStack.clear();
            cardLayout.show(panelSection1, "cardJoin");
            addToPanelStack("cardJoin");
        } catch (destroy_fail | unknown_player ex) {
            Logger.getLogger(GameClientUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_btnGameLeaveActionPerformed

    private void btnGameReadyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGameReadyActionPerformed
        try {            
            if (getRadioValue() != 0) {
                if (client.getServant().isValidPlayer(player_id)) {
                    selected = client.getServant().setPlayerSelection(player_id, getRadioValue());
                    if (selected) {
                        client.getServant().event_listener(player_id, player_name + ": has selected..", callback);
                        boolean isSet = client.getServant().checkIfPlayersHaveSelected();
                        if (isSet) {
                            cardStack.clear();
                            cardLayout.show(panelSection1, "cardResult");
                            addToPanelStack("cardResult");
                        } else {
                            cardStack.clear();
                            cardLayout.show(panelSection1, "cardWaiting");
                            addToPanelStack("cardWaiting");
                            waitForPlayerToSelect.start();
                        }
                    } 
                } else {
                    txtAreaEventDisplay.append("\nPlayer_id is not valid!!");
                }
            } else {
                txtAreaEventDisplay.append("\nPlease select an option before continuing!!");
            }
        } catch (unknown_player ex) {
            Logger.getLogger(GameClientUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGameReadyActionPerformed

    private void btnResultLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultLeaveActionPerformed
        try {
            client.getServant().event_listener(player_id, player_name + ": is leaving....", callback);
            client.getServant().unsubscribe(player_id);   
            cardStack.clear();
            cardLayout.show(panelSection1, "cardJoin");
            addToPanelStack("cardJoin");
        } catch (destroy_fail | unknown_player ex) {
            Logger.getLogger(GameClientUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResultLeaveActionPerformed

    private void btnResultPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultPlayAgainActionPerformed
        try {
            if (client.getServant().isValidPlayer(player_id)) {
                boolean isSet = client.getServant().setPlayerIsReady(player_id, true);
                if (isSet) {
                    resetRadioValue();
                    jLabel4.setIcon(null);
                    client.getServant().event_listener(player_id, player_name + ": wants to play again..", callback);
                    ready = client.getServant().checkIfPlayersAreReadyToStart();
                    if (ready) {
                        cardStack.clear();
                        cardLayout.show(panelSection1, "cardGame");
                        addToPanelStack("cardGame");
                        if (!updateScoreBoard.isRunning()) {
                            updateScoreBoard.start();
                        }
                    } else {
                        cardStack.clear();
                        cardLayout.show(panelSection1, "cardWaiting");
                        addToPanelStack("cardWaiting");
                        waitForPlayerToJoin.start();
                    }
                }
            } else {
                 txtAreaEventDisplay.append("\nPlayer_id is not valid!!");
            }
        } catch (unknown_player ex) {
            Logger.getLogger(GameClientUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResultPlayAgainActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
          try {
              if (client.getServant().isValidPlayer(player_id)) {    
                  client.getServant().event_listener(player_id, player_name + ": is leaving....", callback);
                  client.getServant().unsubscribe(player_id);                 
              }
              System.exit(0);
        } catch (destroy_fail | unknown_player ex) {
            Logger.getLogger(GameClientUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnGameHowToPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGameHowToPlayActionPerformed
        try {
            if (txtAreaHelp.getText().trim().equals("")) {
                populateHowToPlay();
            } else {
                cardLayout.show(panelSection1, "cardHelp");
                addToPanelStack("cardHelp");
            }
        } catch (IOException ex) {
            Logger.getLogger(GameClientUI.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGameHowToPlayActionPerformed

    /**
     * @param args the command line arguments
     */    
     public static void main(String args[]) {
        /* Set the Nimbus look and feel */
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameClientUI().setVisible(true);
            }
        });
    }

    //<editor-fold defaultstate="collapsed" desc=" Variables declaration - do not modify  ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGameHowToPlay;
    private javax.swing.JButton btnGameLeave;
    private javax.swing.JButton btnGameReady;
    private javax.swing.JButton btnHelpGoBack;
    private javax.swing.JButton btnHowToPlay;
    private javax.swing.JButton btnJoinGame;
    private javax.swing.JButton btnJoinGoBack;
    private javax.swing.JButton btnPlayGame;
    private javax.swing.JButton btnResultLeave;
    private javax.swing.JButton btnResultPlayAgain;
    private javax.swing.JPanel cardGame;
    private javax.swing.JPanel cardHome;
    private javax.swing.JPanel cardJoin;
    private javax.swing.JPanel cardResult;
    private javax.swing.JPanel cardWaiting;
    private javax.swing.JPanel cardlHelp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGameSelection;
    private javax.swing.JLabel lblGameTitle;
    private javax.swing.JLabel lblHelpTitle;
    private javax.swing.JLabel lblHomeTitle;
    private javax.swing.JLabel lblHomeWelcomeMsg;
    private javax.swing.JLabel lblJoinEnterName;
    private javax.swing.JLabel lblJoinTitle;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblResultTitle;
    private javax.swing.JLabel lblWaitMessage;
    private javax.swing.JPanel panelMainContent;
    private javax.swing.JPanel panelMainFooter;
    private javax.swing.JPanel panelMainHeader;
    private javax.swing.JPanel panelSection1;
    private javax.swing.JPanel panelSection2;
    private javax.swing.JRadioButton rbtnPaper;
    private javax.swing.JRadioButton rbtnRock;
    private javax.swing.JRadioButton rbtnScissiors;
    private javax.swing.JScrollPane scrollPaneHelp;
    private javax.swing.JTextArea txtAreaEventDisplay;
    private javax.swing.JTextArea txtAreaHelp;
    private javax.swing.JTextArea txtAreaScoreBoard;
    private javax.swing.JTextField txtJoinEnterName;
    // End of variables declaration//GEN-END:variables
      //</editor-fold>
   
    //CardLayout Methods
    private void addToPanelStack(String card) {
        if (cardStack.isEmpty()) {
            cardStack.push(card);
        } else {
            if (!cardStack.peek().equals(card)) {
                cardStack.push(card);
            }
        }
    }
    
    private String previousPanel() {
        if (!cardStack.empty()) {
            cardStack.pop();
            if (!cardStack.empty()) {
                return cardStack.peek().toString();
            } else {
                return "cardHome";
            }
        } else {
            return "cardHome";
        }
    }
          
    //Timer Methods
    javax.swing.Timer waitForPlayerToJoin = new javax.swing.Timer(timerTimeInMilliSeconds, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ready = client.getServant().checkIfPlayersAreReadyToStart();
            if (ready) {
                cardStack.clear();
                cardLayout.show(panelSection1, "cardGame");
                addToPanelStack("cardGame");
                if (!updateScoreBoard.isRunning()) {
                    updateScoreBoard.start();
                }
                waitForPlayerToJoin.stop();
            } 
        }
    });

    javax.swing.Timer waitForPlayerToSelect = new javax.swing.Timer(timerTimeInMilliSeconds, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selected = client.getServant().checkIfPlayersHaveSelected();
            if (selected) {
                if (client.getServant().calculateResults()) {
                    if (client.getServant().endCurrentGame()) {
                        cardStack.clear();
                        cardLayout.show(panelSection1, "cardResult");
                        addToPanelStack("cardResult");
                        waitForPlayerToSelect.stop();
                    } 
                }
            } 
        }
    });

     javax.swing.Timer checkGameIsValid = new javax.swing.Timer(33, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selected = client.getServant().hasAPlayerLeft();
            if (selected) {                     
                    waitForPlayerToJoin.stop();
                    waitForPlayerToSelect.stop();  
                    updateScoreBoard.stop(); 
                    cardStack.clear();
                    cardLayout.show(panelSection1, "cardJoin");
                    addToPanelStack("cardJoin");
                    txtAreaScoreBoard.setText("");
                    checkGameIsValid.stop();                
            }
        }
    });
     
     
    javax.swing.Timer updateScoreBoard = new javax.swing.Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            request = client.getServant()._request("currGameDetails");
            arg = request.add_in_arg();
            arg.insert_string(player_id);
            request.set_return_type(client.getORB().get_primitive_tc(org.omg.CORBA.TCKind.tk_any));
            request.invoke();
            
            anyGameDetails = request.return_value().extract_any();
            tempGameDetails = new Game();
            tempGameDetails = GameHelper.extract(anyGameDetails);

            TypeCode tconLineDetails = anyGameDetails.type();
            if (GameHelper.type().equal(tconLineDetails)) {
                
                txtAreaScoreBoard.setText("");
                jLabel4.setIcon(null);
                if (!tempGameDetails.isActive) {
                    if (!"".equals(tempGameDetails.winner_id)) {

                        if (tempGameDetails.winner_id.equals(player_id)) {
                            jLabel4.setIcon(win_icon);
                        } else {
                            jLabel4.setIcon(lose_icon);
                        }
                    } else {
                        jLabel4.setIcon(draw_icon);
                    }
                }
                
                txtAreaScoreBoard.append(
                        " GameId: " + tempGameDetails.id
                        + "\n Start Time: " + tempGameDetails.date
                        + "\n Is Active: " + tempGameDetails.isActive
                        + "\n Message: " + tempGameDetails.message
                        + "\n Winner Id: " + tempGameDetails.winner_id
                        + "\n Winner Id: " + tempGameDetails.winner_name
                        + "\n " + tempGameDetails.players[0].name + " score: " + tempGameDetails.players[0].score
                        + "\n " + tempGameDetails.players[1].name + " score: " + tempGameDetails.players[1].score
                );

            } else {
                txtAreaEventDisplay.setText("");
            }
        }
    });

    //Help file Methods
    private void populateHowToPlay() throws FileNotFoundException, IOException {
        try {
            String s = ".\\src\\org\\ds\\rps\\assets\\HowToPlayServer.txt";
            byte data[] = client.getServant().getHowTooPlayFile(s);
            Path p = Paths.get(".\\src\\org\\ds\\rps\\assets\\HowToPlayClient.txt");

            try (OutputStream out = new BufferedOutputStream(
                    Files.newOutputStream(p, CREATE))) {
                out.write(data, 0, data.length);
                displayToHowToPlayTxtArea(p);
            } catch (IOException x) {
                System.err.println(x);
            }
        } catch (unknown_path ex) {
            Logger.getLogger(GameClientUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displayToHowToPlayTxtArea(Path p) {
        try {
            File inFile = new File(p.toString());
            FileReader fReader = new FileReader(inFile);
            try (BufferedReader bReader = new BufferedReader(fReader)) {
                String str;
                txtAreaHelp.setText("");

                while (true) {
                    str = bReader.readLine();

                    if (str == null) {
                        break;
                    }
                    txtAreaHelp.append(str);
                    txtAreaHelp.append("\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        cardLayout.show(panelSection1, "cardHelp");
        addToPanelStack("cardHelp");
    }
          
    //Radio buttons Methods
    private int getRadioValue() {
        if (rbtnRock.isSelected()) {
            return 1;
        } else if (rbtnPaper.isSelected()) {
            return 2;
        } else if (rbtnScissiors.isSelected()) {
            return 3;
        }
        return 0;
    }

    private void resetRadioValue() {
        rbtnRock.setSelected(false);
        rbtnPaper.setSelected(false);
        rbtnScissiors.setSelected(false);
    }      
    
    //CallBack class
    private class CallBackImpl implements CallBackOperations {
        @Override
        public void message(String msg) {
            txtAreaEventDisplay.append("\n" + msg);
        }
    }

}
