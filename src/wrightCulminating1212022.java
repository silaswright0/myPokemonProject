//nessesary imports

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

/*
 * Silas, Ryan X, Risto
 * Completed on January 27 2022
 */

 /*  **NOTE DESIGNED TO RUN IN A NETBEANS ENVIROMENT    */

 /*This program provides a GUI which acts as a menu, from here the user can exit, access user manual which displays a guide in a new JFrame
 or play the game which instantiates a new JFrame and displays the map, from here the user can access availible Pokemon through the pokedex
 access their own pokemon or move their trainer object. Movement of the trainer object allows for encounters with enemy trainers which starts an attack sequence
 or the pokecentre which heals all the users pokemon
 */


/**
 *
 * @author siwri5851
 */
public class wrightCulminating1212022 extends javax.swing.JFrame {

    //add class varaibles
    private int loopCounter = 0;//to keep track of the efficiancy of quik sort method
    String commentation = "FIGHT!!!";//initialize commentation string so it is not redifined before the user sees the message
    boolean mapSetting = true ;//initialize a variable for if the user is supossed to be traveling the map
    boolean firstTime = true;//initialize a variable for if it is the first time the paintMap method is run to prevent extra key listeners
    private Pokedex[] pokedex = new Pokedex[8];//instaniate new array of pokedex objects 

    /**
     * This method reads a data file and stores information into a array of
     * 'pokedex' objects
     */
    private void readFile() {

        try {//try to read from file
            File f = new File("src/pokedex.txt");//instantiate a new file
            Scanner s = new Scanner(f);//instantiate a new scanner

            for (int i = 0; i < 8; i++) {//use for loop since we will be in control of the size of the data file
                 //read into array of pokedex objects
                 pokedex[i] = new Pokedex( s.nextLine(), Integer.parseInt(s.nextLine()),  Integer.parseInt(s.nextLine()),s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine());//add new pokedex object to array using the scanner
            }

        } catch (FileNotFoundException e) {//catch for file not found exception
            System.out.println(e);//print out error
        }
    }
    /**
     * This method returns a string representing the 'pokedex' array
     * @return the string representing the 'pokedex' array
     */
    public String printPokedex() {
        String toReturn = "";//initialize a string
        for (int i = 0; i < pokedex.length ; i++) {//loop based on the length of array
            toReturn += pokedex[i].toString() +"\n";//use the pokedex object toString method to accumulate to our string 
        }
        return toReturn;//return the string
    }

    /**
     * This method will use a quick sort to sort the array
     * method includes sorting and recursion
     * @param list the array
     * @param left the lowest index value
     * @param right the highest index value
     */
    public void quikSort(Pokedex[] list, int left, int right) {

        if (left >= right) {//base case check if we are done and return
            return;
        }
        int i = left;//declare int i it will be our dynamic value for the bottom  index
        int j = right;//declare int i it will be our dynamic value for the top  index
        int pivot = list[((left + right) / 2)].getIDNum();//find the middle point

        while (i < j) {//while we are not yet done

            while (list[i].getIDNum() < pivot) {//ajust i until it is one idex value below pivot
                i++;
                loopCounter += 1;//accumulate loop counter
            }
            while (pivot < list[j].getIDNum()) {//ajust j until it is one index value above pivot
                j--;
                loopCounter += 1;//accumultae loop counter
            }
            if (i <= j) {//if we need to swap

                Pokedex temp = list[i];//save the value at i temporarly
                list[i] = list[j];//set the value at i to the value at j
                list[j] = temp;//set the value at j to the former value of i

                i++;//accumulate i
                j--;//accumulate j
            }
        }
        quikSort(list, left, j);//sort bottom half by invoking method again
        quikSort(list, i, right);//sort above half by invoking method again

    }

    /**
     * Creates new form wrightCulminating1212022
     */
    public wrightCulminating1212022() {

        initComponents();
        //read from file and sort file
        readFile();//invoke read file method
        quikSort(pokedex, 0, pokedex.length-1);//invoke sort file method

        ImageIcon background = new ImageIcon("src/backgroundIcon.png");//instantiate new image icon for the background
        jlblBackgroundImage.setIcon(background);//set background labels icon to the background image
        ImageIcon logo = new ImageIcon("src/pokemonLogoResized.png");//instantiate new image icon for the logo
        jlblPokemonLogo.setIcon(logo);//set center labels icon to the logo image

        //add music here
        String titlePath = "music/titlescreen.wav";//Declare string path for the directory of the theme music
        themeMusic titleMusic = new themeMusic();//instantiate new theme music
        titleMusic.playMusic(titlePath);//play theme music
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBackground = new javax.swing.JPanel();
        jbPlay = new javax.swing.JButton();
        jbQuit = new javax.swing.JButton();
        jbUserManual = new javax.swing.JButton();
        jlblPokemonLogo = new javax.swing.JLabel();
        jlblBackgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbPlay.setText("Play");
        jbPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPlayActionPerformed(evt);
            }
        });
        jpBackground.add(jbPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 153, 120, 40));

        jbQuit.setText("Quit");
        jbQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuitActionPerformed(evt);
            }
        });
        jpBackground.add(jbQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 120, 40));

        jbUserManual.setText("User Manual");
        jbUserManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUserManualActionPerformed(evt);
            }
        });
        jpBackground.add(jbUserManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 120, 40));
        jpBackground.add(jlblPokemonLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 440, 110));
        jpBackground.add(jlblBackgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuitActionPerformed
        // TODO add your handling code here:
        System.exit(0);//when the user presses quit close the GUI
    }//GEN-LAST:event_jbQuitActionPerformed

    private void jbUserManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUserManualActionPerformed
        // TODO add your handling code here:

        //insantiate a new JFrame that will display the user manual
        JFrame userManual = new JFrame("User Manual");
        JPanel manual = new JPanel();//instantiate new JPanel
        userManual.getContentPane();//get content pane
        //instatiate three new font objects
        Font font = new Font("Montserrat", Font.PLAIN, 24);
        Font helpFont = new Font("Montserrat", Font.PLAIN, 18);
        Font displayFont = new Font("Montserrat", Font.PLAIN, 12);
        
        JLabel controls = new JLabel("Controls");//add new label
        controls.setFont(font);//set font
        Dimension cSize = controls.getPreferredSize();//set size
        controls.setBounds(70, 50, cSize.width, cSize.height);//set location and size
        
        JLabel instructions = new JLabel("Instructions");//add new label
        instructions.setFont(font);//set font
        Dimension iSize = instructions.getPreferredSize();//set size
        instructions.setBounds(70, 290, iSize.width, iSize.height);//set location and size
        
        JLabel userInstructions = new JLabel("Welcome");//add new label
        userInstructions.setFont(helpFont);//set font
        Dimension uiSize = userInstructions.getPreferredSize();//set size
        userInstructions.setBounds(70, 330, iSize.width, iSize.height);//set location and size
        
        JLabel userControls = new JLabel("How to play");//add new label
        userControls.setFont(helpFont);//set font
        Dimension ucSize = userControls.getPreferredSize();//set size
        userControls.setBounds(70, 90, 200, iSize.height);//set location and size
        
        JTextArea displayControls = new JTextArea("");//instantiate new text area
        displayControls.setFont(displayFont);//set font
        displayControls.setBounds(70, 130, 400, 160);//set position and size
        //set text
        displayControls.setText("Movement:\nKey W: Move up\tKey S:Move Down\nKey A: Move left\tKey D: Move right\nButton Pokedex: Shows all availible pokemon\nButton My Pokemon: Shows all your pokemon");
        JTextArea displayInstructions = new JTextArea("");//instantiate new text area
        displayInstructions.setFont(displayFont);//set font
        displayInstructions.setBounds(70, 370, 400, 300);//set position and size
        //set text
        displayInstructions.setText("Use movement to explore map.\n\n Entering the pokecentre (building with bright red roof)\n will heal all your pokemon.\n\nMove onto a opponent trainer to challange them.\nDefeating an opponent trainer allows you \nto catch the pokemon they used\nPokemon who reach 0 or less health\ncannot be used until healed\nIf during your fight all your pokemon\nreach 0 or less health you will be booted to the\nstarting position but keep all your pokemon\njust make sure to heal them before trying to use them again\n\nMost importantly have fun and enjoy the blast of nastolgia");
        
        manual.setLayout(null);//set layout to absolute layout
        
//add all components to panel
        manual.add(controls);
        manual.add(instructions);
        manual.add(userControls);
        manual.add(userInstructions);
        manual.add(displayControls);
        manual.add(displayInstructions);
        
        //add panel to JFrame
        userManual.add(manual);
        userManual.setVisible(true);//set visible to be true
        userManual.setSize(800, 800);//set size
        userManual.setEnabled(true);//set enabled to true
        userManual.setVisible(true);//set visible to true


    }//GEN-LAST:event_jbUserManualActionPerformed

    private void jbPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPlayActionPerformed
        // TODO add your handling code here:
        firstTime = true ;//when the user clicks play set firstTime to true because we need to create a key listener                                                                                                                                                                            
        //insantiate a new jPannel that will display the game
        JFrame map = new JFrame();//declare JFrame object
        map.setSize(1150, 640);//set size
        map.setTitle("Rolling Plains");//set title
        map.setEnabled(true);//set enabled to true
        map.setVisible(true);//set visible to true
        map.getContentPane();//get the content pane
        String name = JOptionPane.showInputDialog("Enter a name for your trainer");//ask user for the name of their trainer
        //add trainer objects
        //instantiate a new trainer for user with their name and the three starter pokemon
        Trainer user = new Trainer(name, 550, 380, "I'm ready to explore the rolling plains", ((Pokemon) new Bulbasaur("Bulbasaur", 45, "Solar Beam", "Tackle", "Vine Whip", "Seed Bomb")), ((Pokemon) new Squirtle("Squirtle", 44, "Tackle", "Tail Whip", "Water Gun", "Hydro Pump")), ((Pokemon) new Charmander("Charmander", 39, "Tackle", "Inferno", "Ember", "Dragon Breath")));
        //instantiate a new trainer for the two opponents
        Trainer opponent1 = new Trainer("Chad", 800, 250, " ", ((Pokemon) new Skiddo("Skiddo", 66, "Leaf Blade", "Vine Whip", "Leech Seed", "Double Edge")), ((Pokemon) new Gible("Gible", 58, "Sand Tomb", "Bulldozze", "Dragon Breath", "Take Down")), ((Pokemon) new Charmander("Charmander", 39, "Tackle", "Slash", "Flare Blitz", "Dragon Breath")));
        Trainer opponent2 = new Trainer("Gigachad", 5, 120, "", ((Pokemon) new Caterpie("Caterpie", 45, "String Shot", "Tackle", "Bug Bite", "Electroweb")), ((Pokemon) new Geodude("Geodude", 40, "Tackle", "Rollout", "Bulldoze", "Earthquake")), ((Pokemon) new Rayquaza("Rayquaza", 105, "Air Slash", "Crunch", "Hurricane", "Rest")));
        JPanel mainPanel = new JPanel();//instantiate a new JPanel
        mainPanel.setLayout(null);//set layout to absolute layout
        mainPanel.setSize(1200, 600);//set size
        
        paintMap(map, mainPanel, user, opponent1, opponent2);//invoke paint map method

    }//GEN-LAST:event_jbPlayActionPerformed
    /**
     * This method changes the JFrame to display the map with the trainers and adds some buttons
     * giving user more access to the possible 'pokemon' and the 'pokemon' that they have caught
     * @param map the JFrame object
     * @param mainPanel the JPanel object attached to map
     * @param user the user's trainer object
     * @param opponent1 the first opponent's trainer object
     * @param opponent2 the second opponent's trainer object
     */
    public void paintMap(JFrame map, JPanel mainPanel, Trainer user, Trainer opponent1, Trainer opponent2) {

        mainPanel.removeAll();//remove all components on the panel
        mapSetting = true ;//set the setting to map
        JButton pokedex = new JButton();//add a button to access pokedex
        JButton myPokemon = new JButton();//add a button to acces the users pokemon
        //add buttons to the panel
        mainPanel.add(pokedex);
        mainPanel.add(myPokemon);
        //declare labels to display the trainer objects
        JLabel userLabel = new JLabel();
        JLabel opponentLabel1 = new JLabel();
        JLabel opponentLabel2 = new JLabel();
        //add the labels to the panel
        mainPanel.add(userLabel);
        mainPanel.add(opponentLabel1);
        mainPanel.add(opponentLabel2);
        //add a label to display the background image
        JLabel mapBackground = new JLabel();
        //instantiate new ImageIcon with the background image
        ImageIcon backgroundImage = new ImageIcon("src/mapBackgroundResized.jpeg");//instantiate new image icon for the background
        mapBackground.setBounds(0, 0, 1200, 600);//set label's size and position
        mapBackground.setVisible(true);//set visible to true
        mapBackground.setIcon(backgroundImage);//add the image icon to the label

        map.add(mainPanel);//add the main panel to the JFrame
        mainPanel.add(mapBackground);//add the label to the main panel
        map.setFocusable(true);//set focusable to true
        //set the trainer labels to a method in the trainer class which returns an ImageIcon object
        userLabel.setIcon(user.display());
        opponentLabel1.setIcon(opponent1.display());
        opponentLabel2.setIcon(opponent2.display());
        //set size and position of the trainers
        userLabel.setBounds(user.getXPos(), user.getYPos(), 80, 80);
        opponentLabel1.setBounds(opponent1.getXPos(), opponent1.getYPos(), 80, 80);
        opponentLabel2.setBounds(opponent2.getXPos(), opponent2.getYPos(), 80, 80);
        //set the trainer labels to visible
        userLabel.setVisible(true);
        opponentLabel1.setVisible(true);
        userLabel.setVisible(true);
        //use if statments to potentially invoke methods that will transform the JFrame
        
        if (user.getXPos() < 400 && user.getXPos() > 300 && user.getYPos() > 200 && user.getYPos() < 280) {
            //if the user moves to the pokecentre
            //set all components to invisible
            mapBackground.setVisible(false);
            userLabel.setVisible(false);
            opponentLabel1.setVisible(false);
            userLabel.setVisible(false);
            pokedex.setVisible(false);
            mainPanel.removeAll();// remove all the components
            pokecentre(map, mainPanel, user, opponent1, opponent2);//invoke pokecentre method
        }else if(user.getXPos()>790&&user.getXPos()<810&&user.getYPos()>240&&user.getYPos()<260){
            //if the user moves to the first opponent
            //set all components to invisible
            mapBackground.setVisible(false);
            userLabel.setVisible(false);
            opponentLabel1.setVisible(false);
            userLabel.setVisible(false);
            pokedex.setVisible(false);
            mainPanel.removeAll();// remove all the components
            //invoke the attack sequence with the users first pokemon and a random enemy pokemon
        attackSequence(map, mainPanel, user, opponent1, opponent2, 0, (int) (Math.random()*3)+0);    
        }else if(user.getXPos()>-5&&user.getXPos()<15&&user.getYPos()>110&&user.getYPos()<130){
            //if the user moves to the second opponent
            //set all components to invisible
            mapBackground.setVisible(false);
            userLabel.setVisible(false);
            opponentLabel1.setVisible(false);
            userLabel.setVisible(false);
            pokedex.setVisible(false);
            mainPanel.removeAll();// remove all the components
            //invoke the attack sequence with the users first pokemon and a random enemy pokemon
        attackSequence(map, mainPanel, user, opponent2, opponent1,0, (int) (Math.random()*3)+0);
            }
        
        myPokemon.setText("My Pokemon");//set text of myPokemon button
        myPokemon.setVisible(true);//set visibility of myPokemon button to true
        myPokemon.setBounds(1000, 100, 120, 50);//set size and position of myPokemon button
        myPokemon.addActionListener(new ActionListener() {//add action lisenter for our button
            @Override
            public void actionPerformed(ActionEvent e) {
            mapBackground.setVisible(false);//set the background to invisible
            mainPanel.removeAll();// remove all the components
            myPokemon(map, mainPanel, user, opponent1, opponent2);//invoke myPokemon method
            }

            
        });
        
        pokedex.setText("Pokedex");//set text of pokedex button
        pokedex.setVisible(true);//set visibility of pokedex button to true
        pokedex.setBounds(1000, 0, 100, 50);//set size and position of pokedex button
        pokedex.addActionListener(new ActionListener() {//add action listener for our button
            @Override
            public void actionPerformed(ActionEvent e) {
                mapBackground.setVisible(false);//set the background to invisible
                mainPanel.removeAll();// remove all the components
                pokedex(map, mainPanel, user, opponent1, opponent2);//invoke pokedex method
            }
        });
        if (firstTime) {//if we need to add a key listener
            firstTime = false;//make sure we don't add any more key listeners
            map.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent ke) {//include all abstract methods
                
                }

                @Override
                public void keyPressed(KeyEvent ke) {//when a key is pressed
                    if(mapSetting){//if we are in the map setting
                    int keyCode = ke.getKeyCode();//get keycode
                    switch (keyCode) {//use switch statment to see what key
                        case KeyEvent.VK_W://if they pressed W
                            //change x,y attributes of user's trainer
                            user.move(user.getXPos(), (user.getYPos() - 10));
                            //move the label based on x,y attributes of user's trainer
                            userLabel.setBounds(user.getXPos(), user.getYPos(), 80, 80);
                            //invoke the paintMap method again
                            paintMap(map, mainPanel, user, opponent1, opponent2);

                            break;
                        case KeyEvent.VK_S://if they pressed S
                            //change x,y attributes of user's trainer
                            user.move(user.getXPos(), (user.getYPos() + 10));
                            //move the label based on x,y attributes of user's trainer
                            userLabel.setBounds(user.getXPos(), user.getYPos(), 80, 80);
                            //invoke the paintMap method again
                            paintMap(map, mainPanel, user, opponent1, opponent2);
                            break;
                        case KeyEvent.VK_D:
                            //change x,y attributes of user's trainer
                            user.move(user.getXPos() + 10, (user.getYPos()));
                            //move the label based on x,y attributes of user's trainer
                            userLabel.setBounds(user.getXPos(), user.getYPos(), 80, 80);
                            //invoke the paintMap method again
                            paintMap(map, mainPanel, user, opponent1, opponent2);
                            break;
                        case KeyEvent.VK_A:
                            //change x,y attributes of user's trainer
                            user.move(user.getXPos() - 10, (user.getYPos()));
                            //move the label based on x,y attributes of user's trainer
                            userLabel.setBounds(user.getXPos(), user.getYPos(), 80, 80);
                            //invoke the paintMap method again
                            paintMap(map, mainPanel, user, opponent1, opponent2);
                            break;
                    }        
                    }
                }

                @Override
                public void keyReleased(KeyEvent ke) {//include all abstract methods
                    
                }

            });
        }
    }
    /**
     * This method transforms the JFrame displaying the user's 'pokemon'
     * @param map//the JFrame object
     * @param mainPanel//the JPanel object
     * @param user//the user's trainer object
     * @param opponent1//the first opponent's trainer object
     * @param opponent2 //the second opponent's trainer object
     */
private void myPokemon(JFrame map, JPanel mainPanel, Trainer user, Trainer opponent1, Trainer opponent2) {
               mainPanel.removeAll();//first remove all the components
        mapSetting = false ;//set map setting to false
        JButton leave = new JButton();//instantiate new JButton for returning to the map
        mainPanel.add(leave);//add button to the panel
        JTextArea pokemon = new JTextArea();//instantiate a new text area
        JScrollPane scroll = new JScrollPane(pokemon);//instantiate a new scroll pane with the text area
        //add the scroll pane to the panel
        mainPanel.add(scroll);
        
        scroll.setBounds(0, 0, 1000, 600);//set size and position of the scroll pane
        scroll.setVisible(true);//set visibility of the scroll pane to true
        
        pokemon.setText(printMyPokemon(user));//set text of the text area with the printMyPokemon method
        
        
        
        leave.setText("Leave");//set text of button
        leave.setBounds(1000, 0, 100, 100);//set size and position of button
        leave.addActionListener(new ActionListener() {//add action listener for button
            @Override
            public void actionPerformed(ActionEvent e) {
                //set all components to invisible
                leave.setVisible(false);
                pokemon.setVisible(false);
                scroll.setVisible(false);
                mainPanel.removeAll();//remove all components
                paintMap(map, mainPanel, user, opponent1, opponent2);//invoke paintMap method
            }
        });
    }
    /**
     * This method will transform the JFrame into the 'pokecentre'
     * @param map //the JFrame object
     * @param mainPanel //the JPanel object
     * @param user //the user's trainer object
     * @param opponent1 //the first opponent's trainer object
     * @param opponent2 //the second opponent's trainer object
     */        
    public void pokecentre(JFrame map, JPanel mainPanel, Trainer user, Trainer opponent1, Trainer opponent2) {

        mainPanel.removeAll();//first remove all the components
        mapSetting = false ;//set map setting to false
        JButton leave = new JButton();//add a new button to return to the map setting
        mainPanel.add(leave);//add button to panel

        JLabel message = new JLabel();//add new label to display message
        mainPanel.add(message);//add label to the mainPanel
        JLabel pokecentre = new JLabel();//add label to display the background image

        message.setBounds(290, 200, 800, 200);//set size and position of the label
        //set text of label
        message.setText("Your Pokemon are healed! \nPress leave when you are ready to \nReturn to the main map");
        Font myFont = new Font("Serif", Font.BOLD, 16);//instantiate a new font object
        message.setFont(myFont);//set the text to new font object
        
        //instantiate new ImageIcon object for the background image
        ImageIcon backgroundImage = new ImageIcon("src/pokecentre.jpeg");//instantiate new image icon for the background
        pokecentre.setBounds(0, 0, 1200, 600);//set size and position of the background label
        pokecentre.setVisible(true);//set visibility of label to true
        pokecentre.setIcon(backgroundImage);//add the ImageIcon to the label
        mainPanel.add(pokecentre);//add the ackground label to the panel

        resetHealth(user);//reset the health of all the users pokemon with resetHealth method

        user.move(550, 380);//move the user object to prevent the user from infinitely entering the pokecentre
        leave.setText("Leave");//set text of the button
        leave.setBounds(1000, 0, 100, 100);//set size and position of the button

        leave.addActionListener(new ActionListener() {//add action listener for the button
            @Override
            public void actionPerformed(ActionEvent e) {
                //set componenets to invisible
                leave.setVisible(false);
                pokecentre.setVisible(false);
                mainPanel.removeAll();//remove all components
                paintMap(map, mainPanel, user, opponent1, opponent2);//invoke paintMap method

            }
        });

    }
/**
 * This method transforms the JFrame to display the available 'pokemon'
 * @param map //the JFrame object
 * @param mainPanel //the JPanel object
 * @param user //the user's trainer object
 * @param opponent1 //the first opponent's trainer object
 * @param opponent2  //the second opponent's trainer object
 */
    public void pokedex(JFrame map, JPanel mainPanel, Trainer user, Trainer opponent1, Trainer opponent2) {

        mainPanel.removeAll();//first remove all the components
        mapSetting = false ;//set the map setting to false
        JButton leave = new JButton();//add new button to returnt to the map setting
        mainPanel.add(leave);//add button to the panel
        
        
        JTextArea pokedex = new JTextArea();//instantiate new text area
        JScrollPane scroll = new JScrollPane(pokedex);//instantiate new scroll pane with the text area
        
        
        scroll.setBounds(0, 0, 1000, 600);//set size and position of the scroll pane
        scroll.setVisible(true);//set visibility of the scroll pane to true
        
        pokedex.setText(printPokedex());//set text of text area to printPokedex method
        mainPanel.add(scroll);//add the scroll pane to the mainPanel
        
        leave.setText("Leave");//set text of button
        leave.setBounds(1000, 0, 100, 100);//set size and position of button
        leave.addActionListener(new ActionListener() {//add action listener for button
            @Override
            public void actionPerformed(ActionEvent e) {
                //set components to invisible
                leave.setVisible(false);
                pokedex.setVisible(false);
                scroll.setVisible(false);
                mainPanel.removeAll();//remove all components
                paintMap(map, mainPanel, user, opponent1, opponent2);//invoke paintMap method
            }
        });
    }
/**
 * This method transforms JFrame to the attack sequence
 * @param map the JFrame object
 * @param mainPanel the JPanel object
 * @param user the user's trainer object
 * @param mainOpponent the trainer object that user is fighting
 * @param otherOpponent the other trainer object
 * @param i an integer holding the index of 'pokemon' array list for user
 * @param z an integer holding the index of 'pokemon' array list for opponent
 */
    public void attackSequence(JFrame map, JPanel mainPanel, Trainer user, Trainer mainOpponent, Trainer otherOpponent, int i, int z) {
    mainPanel.removeAll();//first remove all the components
    Font myFont = new Font("Serif", Font.BOLD, 16);//instantiate a new font
    mapSetting = false ;//set the map setting to false
    Font title = new Font("Serif", Font.BOLD, 18);//instantiate a new font
    JLabel userPokemon = new JLabel();//instantiate a new JLabel for the user's pokemon image
    userPokemon.setBounds(400, 350, 300, 300);//set size and location of label
    userPokemon.setVisible(true);//set visible to true
    userPokemon.setIcon(user.getPokemon().get(i).display());//use display method in pokemon interface to set ImageIcon of label
    JLabel opponentPokemon = new JLabel();//instantiate new label for the opponent's pokemon image
    opponentPokemon.setBounds(800, 150, 300, 200);//set size and location of label
    opponentPokemon.setVisible(true);//set visible to true
    opponentPokemon.setIcon(mainOpponent.getPokemon().get(z).display());//use display method in pokemon interface to set ImageIcon of label
    JButton run = new JButton();//Instantiate new button to return to map setting
    run.setVisible(true);//set visible to true
    run.setBounds(1000, 550, 100, 50);//set size and location of button
    run.setText("Run");//set text of button
    JButton nextPokemon = new JButton();//intantiate new button to use the next pokemon in array list
    nextPokemon.setVisible(true);//set visible to true
    nextPokemon.setBounds(800, 550, 100, 50);//set size and location of button
    nextPokemon.setText("Next");//set text of button
    JButton ability1 = new JButton();//intantiate new button to use ability 1
    ability1.setVisible(true);//set visible to true
    ability1.setBounds(800, 450, 100, 50);//set size and location of button
    ability1.setText(user.getPokemon().get(i).getAbility1());//set text of button with accessor in pokemon interface
    JButton ability2 = new JButton();//intantiate new button to use ability 2
    ability2.setVisible(true);//set visible to true
    ability2.setBounds(1000, 450, 100, 50);//set size and location of button
    ability2.setText(user.getPokemon().get(i).getAbility2());//set text of button with accessor in pokemon interface
    JButton ability3 = new JButton();//intantiate new button to use ability 3
    ability3.setVisible(true);//set visible to true
    ability3.setBounds(800, 500, 100, 50);//set size and location of button
    ability3.setText(user.getPokemon().get(i).getAbility3());//set text of button with accessor in pokemon interface
    JButton ability4 = new JButton();//intantiate new button to use ability 4
    ability4.setVisible(true);//set visible to true
    ability4.setBounds(1000, 500, 100, 50);//set size and location of button
    ability4.setText(user.getPokemon().get(i).getAbility4());//set text of button with accessor in pokemon interface
    
    JTextArea commentator = new JTextArea();//instantiate new text area to describe the fight
    commentator.setVisible(true);//set visible to true
    commentator.setBounds(0, 0, 400, 200);//set size and location of text area
    commentator.setText(commentation);//set text to the global variable
    commentator.setFont(myFont);//set font
    
    JProgressBar userHealth = new JProgressBar();//instantiate new progress bar for user's health
    userHealth.setMaximum(user.getPokemon().get(i).getMaxHealth());//set maximum value based on pokemon's max health
    userHealth.setVisible(true);//set visible to true
    userHealth.setBounds(150,350, 200, 50);//set size and location of progress bar
    userHealth.setValue((int) user.getPokemon().get(i).health());
    userHealth.setStringPainted(true);//set visible to true
    JProgressBar opponentHealth = new JProgressBar();//instantiate new progress bar for opponent's health
    opponentHealth.setMaximum(mainOpponent.getPokemon().get(z).getMaxHealth());//set maximum value based on pokemon's max health
    opponentHealth.setVisible(true);//set visible to true
    opponentHealth.setBounds(800,330, 200, 50);//set size and location of progress bar
    opponentHealth.setValue((int) mainOpponent.getPokemon().get(z).health());
    opponentHealth.setStringPainted(true);//set visible to true
    
    JLabel userTitle = new JLabel();//instantiate new label for the name of user's pokemon
    userTitle.setBounds(100, 250, 100, 100);//set size and location of label
    userTitle.setVisible(true);//set visible to true
    userTitle.setFont(title);//set font
    userTitle.setText(user.getPokemon().get(i).getName());//set name based on accessor in pokemon interface
    JLabel opponentTitle = new JLabel();//instantiate new label for the name of opponent's pokemon
    opponentTitle.setBounds(800, 350, 100, 100);//set size and location of label
    opponentTitle.setVisible(true);//set visible to true
    opponentTitle.setFont(title);//set font
    opponentTitle.setText(mainOpponent.getPokemon().get(z).getName());//set name based on accessor in pokemon interface
    
    JLabel background = new JLabel();//instantiate new label for the background image
    ImageIcon backgroundImage = new ImageIcon("src/attackBackgroundResized.jpeg");//instantiate new image icon for the background
    background.setBounds(0, 0, 1200, 600);//set size and location of label
    background.setVisible(true);//set visible to true
    background.setIcon(backgroundImage);//set Icon of label to the background image
    //enable all buttons
    ability1.setEnabled(true);
    ability2.setEnabled(true);
    ability3.setEnabled(true);
    ability4.setEnabled(true);
    nextPokemon.setEnabled(true);
    //add all components to the panel
    mainPanel.add(userTitle);
    mainPanel.add(opponentTitle);
    mainPanel.add(userHealth); 
    mainPanel.add(opponentHealth);    
    mainPanel.add(commentator);
    mainPanel.add(run);
    mainPanel.add(nextPokemon);
    mainPanel.add(ability1);
    mainPanel.add(ability2);
    mainPanel.add(ability3);
    mainPanel.add(ability4);
    mainPanel.add(userPokemon);
    mainPanel.add(opponentPokemon);
    mainPanel.add(background);
    
    //use if statments to determine when pokemon lose all their health
    
    if(allDead(user.getPokemon())){//check is all user's pokemon are dead with allDead method
        //if so move user's trainer object to prevent user from infinitely triggering attackSequence method
        user.move(550, 380);
        //set components to invisible
        background.setVisible(false);
        userPokemon.setVisible(false);
        opponentPokemon.setVisible(false);
        mainPanel.removeAll();//remove all components
        resetHealth(mainOpponent);    //reset health of opponents pokemon
        paintMap(map, mainPanel, user, mainOpponent, otherOpponent);//invoke paintMap method
        return;
    }else if(user.getPokemon().get(i).health() <=0){//if only this pokemon has reached 0 or less health
        if(i<(user.getPokemon().size()-1)){//check if we are at end of array
            //if not set all components to invisible
        background.setVisible(false);
        userPokemon.setVisible(false);
        opponentPokemon.setVisible(false);
        mainPanel.removeAll();//remove all components
        attackSequence(map,mainPanel,user,mainOpponent,otherOpponent, i+1, z);//invoke attack sequence again with user's next pokemon
        }else{
            //if we are at end of array list
            //set all components to invisible
        background.setVisible(false);
        userPokemon.setVisible(false);
        opponentPokemon.setVisible(false);
        mainPanel.removeAll();//remove all components
        attackSequence(map,mainPanel,user,mainOpponent,otherOpponent, 0, z);//invoke attack seqeunce again with user's first pokemon    
        }
    }
//if the opponent's pokemon has reached 0 or less health    
if(mainOpponent.getPokemon().get(z).health() <= 0){
    //set text area to display victory message
    commentator.setText("Victory\n "+ mainOpponent.getPokemon().get(z).getName()+" has been added to your collection\nPress run to return to map");
    //disable all buttons except run
    ability1.setEnabled(false);
    ability2.setEnabled(false);
    ability3.setEnabled(false);
    ability4.setEnabled(false);
    nextPokemon.setEnabled(false);
    //catch the opponents pokemon by adding a clone to the user's array list of pokemon
    user.getPokemon().add(mainOpponent.getPokemon().get(z).clone());
    }
    
    run.addActionListener(new ActionListener() {//add action listener for run button
        @Override
        public void actionPerformed(ActionEvent e) {
        resetHealth(mainOpponent);//reset health of opponent's pokemon    
        user.move(550, 380);//move user's trainer to prevent infinitely triggering attackSequence method
        //set components to invisible
        background.setVisible(false);
        userPokemon.setVisible(false);
        opponentPokemon.setVisible(false);
        mainPanel.removeAll();//remove all components
        paintMap(map, mainPanel, user, mainOpponent, otherOpponent); //invoke paintMap method   
        }
    });
    
    nextPokemon.addActionListener(new ActionListener() {//add action listener for nextPokemon button
        @Override
        public void actionPerformed(ActionEvent e) {
        if(i<(user.getPokemon().size()-1)){//if there is still more pokemon in the array list
        //set components to invisible
        background.setVisible(false);
        userPokemon.setVisible(false);
        opponentPokemon.setVisible(false);
        mainPanel.removeAll();//remove all components
        attackSequence(map,mainPanel,user,mainOpponent,otherOpponent, i+1, z);//invoke attackSequence again with next pokemon
        }
        }
    });
    
    ability1.addActionListener(new ActionListener() {//add action listener for ability1 button
        @Override
        public void actionPerformed(ActionEvent ae) {
        user.getPokemon().get(i).ability1(mainOpponent.getPokemon().get(z));//attack opponent with ability 1
        opponentRandAttack(user, mainOpponent,i,z);//have opponent attack user with opponentRandAttack method
        //set text of text area with the abilities both trainers used and the health of their pokemon using accessors in the pokemon interface
        commentation = (user.getPokemon().get(i).getName() +" used "+user.getPokemon().get(i).getAbility1()+"\nUser Health: "+user.getPokemon().get(i).health() +"\n"+mainOpponent.getPokemon().get(z).getName() +" used "+mainOpponent.getPokemon().get(z).getAbility1()+"\nOpponent Health: "+mainOpponent.getPokemon().get(z).health());
        //set components to invisible
        background.setVisible(false);
        userPokemon.setVisible(false);
        opponentPokemon.setVisible(false);
        mainPanel.removeAll();//remove all components
        attackSequence(map,mainPanel,user,mainOpponent,otherOpponent, i, z);//run this method again to repaint
        }

        
    });
    
    ability2.addActionListener(new ActionListener() {//add action listener for ability2 button
        @Override
        public void actionPerformed(ActionEvent ae) {
        user.getPokemon().get(i).ability2(mainOpponent.getPokemon().get(z));//attack opponent with ability 2
        opponentRandAttack(user, mainOpponent,i,z);//have opponent attack user with opponentRandAttack method
        //set text of text area with the abilities both trainers used and the health of their pokemon using accessors in the pokemon interface
        commentation =(user.getPokemon().get(i).getName() +" used "+user.getPokemon().get(i).getAbility2()+"\nUser Health: "+user.getPokemon().get(i).health() +"\n"+mainOpponent.getPokemon().get(z).getName() +" used "+mainOpponent.getPokemon().get(z).getAbility2()+"\nOpponent Health: "+mainOpponent.getPokemon().get(z).health());
        //set components to invisible
        background.setVisible(false);
        userPokemon.setVisible(false);
        opponentPokemon.setVisible(false);
        mainPanel.removeAll();//remove all components
        attackSequence(map,mainPanel,user,mainOpponent,otherOpponent, i, z);//run this method again to repaint
        }
    });
    
    ability3.addActionListener(new ActionListener() {//add action listener for ability3 button
        @Override
        public void actionPerformed(ActionEvent ae) {
        user.getPokemon().get(i).ability3(mainOpponent.getPokemon().get(z));//attack opponent with ability 3
        opponentRandAttack(user, mainOpponent,i,z);//have opponent attack user with opponentRandAttack method
        //set text of text area with the abilities both trainers used and the health of their pokemon using accessors in the pokemon interface
        commentation =(user.getPokemon().get(i).getName() +" used "+user.getPokemon().get(i).getAbility3()+"\nUser Health: "+user.getPokemon().get(i).health() +"\n"+mainOpponent.getPokemon().get(z).getName() +" used "+mainOpponent.getPokemon().get(z).getAbility3()+"\nOpponent Health: "+mainOpponent.getPokemon().get(z).health());
        //set components to invisible
        background.setVisible(false);
        userPokemon.setVisible(false);
        opponentPokemon.setVisible(false);
        mainPanel.removeAll();//remove all components
        attackSequence(map,mainPanel,user,mainOpponent,otherOpponent, i, z);//run this method again to repaint    
        }
    });
    
    
    ability4.addActionListener(new ActionListener() {//add action listener for ability4 button
        @Override
        public void actionPerformed(ActionEvent ae) {
        user.getPokemon().get(i).ability4(mainOpponent.getPokemon().get(z));//attack opponent with ability 4
        opponentRandAttack(user, mainOpponent,i,z);//have opponent attack user with opponentRandAttack method
        //set text of text area with the abilities both trainers used and the health of their pokemon using accessors in the pokemon interface
        commentation =(user.getPokemon().get(i).getName() +" used "+user.getPokemon().get(i).getAbility4()+"\nUser Health: "+user.getPokemon().get(i).health() +"\n"+mainOpponent.getPokemon().get(z).getName() +" used "+mainOpponent.getPokemon().get(z).getAbility4()+"\nOpponent Health: "+mainOpponent.getPokemon().get(z).health());
        //set components to invisible
        background.setVisible(false);
        userPokemon.setVisible(false);
        opponentPokemon.setVisible(false);
        mainPanel.removeAll();//remove all components
        attackSequence(map,mainPanel,user,mainOpponent,otherOpponent, i, z);//run this method again to repaint    
        }
    });
    }
/**
 * This method causes a trainer to use a random ability on another trainer
 * @param user //the user's trainer object
 * @param mainOpponent //the opponents trainer object
 * @param i //the 'pokemon' index for user
 * @param z //the 'pokemon' index for opponent
 */
    private void opponentRandAttack(Trainer user, Trainer mainOpponent, int i, int z) {
    int rand = (int) (Math.random()*4)+1 ;//create random number for the ability to use
    if(rand ==1 ){//if the random number is 1
    //cause opponent to use ability 1 on user    
    mainOpponent.getPokemon().get(z).ability1(user.getPokemon().get(i));
    }else if(rand ==2 ){//if the random number is 2
        //cause opponent to use ability 2 on user  
    mainOpponent.getPokemon().get(z).ability2(user.getPokemon().get(i));    
    }else if(rand ==3 ){//if the random number is 3
        //cause opponent to use ability 3 on user  
    mainOpponent.getPokemon().get(z).ability3(user.getPokemon().get(i));    
    }else if(rand == 4){//if the random number is 4
        //cause opponent to use ability 4 on user  
    mainOpponent.getPokemon().get(z).ability4(user.getPokemon().get(i));    
    }
        }
    
    /**
     * Checks if all the 'pokemon' in a array list are dead
     * @param pokemon the array list of 'pokemon' objects
     * @return the boolean of if they are all dead
     */
    public boolean allDead(ArrayList<Pokemon> pokemon){
        int totalHealth = 0 ;//initialize an integer at 0
        for(int i=0 ; i<pokemon.size();i++){//use for loop to go through the entire array list
        totalHealth += pokemon.get(i).health() ;//accumulate health of each pokemon to the integer
        }
        if(totalHealth <= 0){//if the combined health is 0 or less
            return true;//return true
        }else{//if not
            return false;//return false
        }
    }
    
    /**
     * This method heals all the 'pokemon' objects of a trainer
     * @param toHeal the trainer to heal
     */
    public void resetHealth(Trainer toHeal){
    for(int i=0 ; i<toHeal.getPokemon().size();i++){//use for loop to go through entire array list
        toHeal.getPokemon().get(i).resetHealth();//for each pokemon invoke resetHealth method
    }
    }
    /**
     * This method returns the user's 'pokemon' as a string
     * @param user the trainer object
     * @return the string representing the user's 'pokemon'
     */
    private String printMyPokemon(Trainer user) {
    String toReturn = "";//initilize a string
        for (int i = 0; i < user.getPokemon().size(); i++) {//use for loop to loop through entire array list
            toReturn += user.getPokemon().get(i).toString() +"\n";//accumulate string with toString method of each pokemon
        }
        return toReturn;//return the string
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(wrightCulminating1212022.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(wrightCulminating1212022.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(wrightCulminating1212022.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(wrightCulminating1212022.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new wrightCulminating1212022().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbPlay;
    private javax.swing.JButton jbQuit;
    private javax.swing.JButton jbUserManual;
    private javax.swing.JLabel jlblBackgroundImage;
    private javax.swing.JLabel jlblPokemonLogo;
    private javax.swing.JPanel jpBackground;
    // End of variables declaration//GEN-END:variables

    
}
