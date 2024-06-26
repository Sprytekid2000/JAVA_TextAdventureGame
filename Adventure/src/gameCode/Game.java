package gameCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();



    public Game() {

        //Create game window
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        con = window.getContentPane();

        //Create Title
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.BLACK);

        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        //Start Button
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.BLACK);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

        window.setVisible(true);


    }

    public void createGameScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600, 250);
        mainTextPanel.setBackground(Color.BLACK);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);

        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.WHITE);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.BLACK);
        choice2.setForeground(Color.WHITE);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.BLACK);
        choice3.setForeground(Color.WHITE);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.BLACK);
        choice4.setForeground(Color.WHITE);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);
        

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.BLACK);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);

        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.WHITE);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.WHITE);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.WHITE);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.WHITE);
        playerPanel.add(weaponLabelName);

        playerSetup();

    }

    public void playerSetup(){
        playerHP = 15;
        weapon = "Knife";
        monsterHP = 20;

        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);

        townGate();

    }
    public void townGate(){
        position = "townGate";
        mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");

        choice1.setText("Talk to the guard.");
        choice2.setText("Attack the guard.");
        choice3.setText("Leave");
        choice4.setText("");

    }

    public void talkGuard(){
        position = "talkGuard";
        mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter our town.");

        choice1.setText("Continue");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void attackGuard(){
        position = "attackGuard";
        mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You receive 3 damage)");
        playerHP -= 3;
        hpLabelNumber.setText(""+playerHP);

        choice1.setText("Continue");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");


    }
    
    public void crossRoad(){
        position = "crossRoad";
        mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to town.");

        choice1.setText("Go North.");
        choice2.setText("Go East.");
        choice3.setText("Go South. (To Town)");
        choice4.setText("Go West.");
    }

    public void north(){
        position = "north";
        mainTextArea.setText("There is a river. \nYou drink water and rest at the riverside. \n\n(Your HP is recovered by 2 )");
        playerHP += 2;
        hpLabelNumber.setText(""+playerHP);

        choice1.setText("South");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void east(){
        position = "east";
        mainTextArea.setText("you walked into the forest and found a Long Sword! \n\n(You have obtained a Long Sword)");
        weapon = "Long Sword";
        weaponLabelName.setText(weapon);

        choice1.setText("West");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");


    }
    public void west(){
        position = "west";
        mainTextArea.setText("You encounter a goblin!");

        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");


    }

    public void fight() {
        position = "fight";
        mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");

        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void playerAttack(){
        position = "playerAttack";

        int playerDamage = 0;

        if(weapon.equals("Knife")){
            playerDamage = new java.util.Random().nextInt(4);
        } else if(weapon.equals("Long Sword")){
            playerDamage = new java.util.Random().nextInt(12);
        }
        
        mainTextArea.setText("You attacked the goblin and gave " + playerDamage + " damage!");

        monsterHP -=playerDamage;

        choice1.setText("Continue");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void monsterAttack(){
        position = "monsterAttack";

        int monsterDamage = 0;

        monsterDamage = new java.util.Random().nextInt(5);

        mainTextArea.setText("The monster attacks you for " + monsterDamage + " damage!");

        playerHP -= monsterDamage;
        hpLabelNumber.setText(""+playerHP);
        
        choice1.setText("Continue");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void win(){
        position = "win";

        mainTextArea.setText("You defeated the goblin!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");

        silverRing = 1;

        choice1.setText("Go East");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void lose(){
        position = "lose";

        mainTextArea.setText("You are dead! \n\n<Game Over>");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);


    }

    public void ending(){
        position = "ending";

        mainTextArea.setText("Guard: Oh you killed the Goblin!? \nThank you so much. You are true hero!\nWelcome to our town!\n\n<THE END>");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            
            String yourChoice = event.getActionCommand();

            switch(position){
                case "townGate": 
                    switch(yourChoice) {
                        case "c1":
                            if(silverRing == 1){
                                ending();
                            } else{
                                talkGuard();
                            }
                            break;
                        case "c2": attackGuard(); break;
                        case "c3": crossRoad(); break;
                    };
                    break;

                case "talkGuard":
                    switch(yourChoice) {
                        case "c1": townGate(); break;
                    }
                    break;

                case "attackGuard":
                    switch(yourChoice) {
                        case "c1": townGate(); break;
                    }
                    break;

                case "crossRoad":
                    switch(yourChoice) {
                        case "c1": north(); break;
                        case "c2": east(); break;
                        case "c3": townGate(); break;
                        case "c4": west(); break;
                    }
                    break;
                
                case "north":
                    switch(yourChoice) {
                        case "c1": crossRoad(); break;
                    }
                    break;

                case "east":
                    switch(yourChoice) {
                        case "c1": crossRoad(); break;
                    }
                    break;

                case "west":
                    switch(yourChoice) {
                        case "c1": fight(); break;
                        case "c2": crossRoad(); break;
                    }
                    break;

                case "fight":
                    switch(yourChoice) {
                        case "c1": playerAttack(); break;
                        case "c2": crossRoad(); break;
                    }
                    break;

                case "playerAttack":
                    switch(yourChoice) {
                        case "c1": 
                            if(monsterHP<1){
                                win();
                            } else {
                                monsterAttack();
                            }
                            break;
                    }
                    break;
                
                case "monsterAttack":
                    switch(yourChoice) {
                        case "c1": 
                            if(playerHP<1){
                                lose();
                            } else{
                                fight();
                            }
                            break;
                    }
                    break;
                
                case "win":
                    switch(yourChoice) {
                        case "c1": crossRoad(); break;
                    }
                    break;

            }
        }
    }

    
    public static void main(String[] args) {
        new Game();
    }
}
