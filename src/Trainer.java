/**
 * Ryan,Silas,Risto
 * 1/27/22
 * This will be the trainer class where they will store pokemon objects to allow
 * the player to store pokemon and fight with them with the other trainers on the map
 */

//imported image icon to display trainers on the map
//imported arraylist to store the pokemon inside and make it easier on us
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Trainer {
    //creating variables to store the trainers properties and an arraylist to store the pokemon
    private String name;
    private int xPos;//x position to get their position on the map when they move
    private int yPos;//y position to get their position on the map when they move
    private String dialog;
    private ArrayList<Pokemon> pokemon = new ArrayList();  
    
    /**
     * Default constructor set to what we input into the object
     * @param pName name of trainer
     * @param xLoc x position of trainer
     * @param yLoc y position of trainer
     */
    public Trainer(String pName, int xLoc, int yLoc){
        //set attributes with formal parameters
        this.name = pName; 
        this.xPos = xLoc;
        this.yPos = yLoc;
    }
    /**
     * secondary constructor to add the pokemon into the arraylist that will
     * be a part of the trainer object
     * @param pName the name of trainer
     * @param xLoc the x position of trainer
     * @param yLoc the y position of trainer
     * @param pDialog the string of dialog of the trainer
     * @param pokemon1 first pokemon object
     * @param pokemon2 second pokemon object
     * @param pokemon3 third pokemon object
     */
    public Trainer(String pName, int xLoc, int yLoc, String pDialog, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3){
        this(pName, xLoc, yLoc);//use previous constructor
        //set attributes with formal parameters
        this.dialog = pDialog;
        this.pokemon.add(pokemon1);
        this.pokemon.add(pokemon2);
        this.pokemon.add(pokemon3);
    }
    /**
     * Accessor to get the name of the trainer
     * @return 
     */
    public String getName(){
        return name;
    }
    /**
     * Mutator to set the name of the trainer
     * @param pName 
     */
    public void setName(String pName){
        name = pName;
    }
    /**
     * Accessor to get the dialog of the trainer
     * @param pDialog 
     */
    public String getDialog(){
        return dialog;
    }
    /**
     * Mutator to set the dialog of the trainer
     * @param pDialog 
     */
    public void setDialog(String pDialog){
        dialog = pDialog;
    }
    /**
     * Accessor to get the y position
     * @return 
     */
    public int getXPos(){
        return xPos;
    }
    /**
     * Accessor to get the y position
     * @return 
     */
    public int getYPos(){
        return yPos;
    }
    //Move method used to get the x and y position and be used in the GUI
    //for the player to move around
    public void move(int x, int y){
    xPos = x ;
    yPos = y ;    
    }
    /**
     * Accessor to get the pokemon inside the array
     * @return 
     */
    public ArrayList<Pokemon> getPokemon(){
        return pokemon;
    }
    /**
     * Mutator to set the pokemon inside the array
     * @param pokemonArray 
     */
    public void setPokemon(ArrayList<Pokemon> pokemonArray){
        pokemon = pokemonArray;
    }
    /**
     * Equals method to check if the trainers are identical to each other
     */
    public boolean equals(Trainer other){
        return this.name.equals(other.name)
                && this.dialog.equals(other.dialog)
                && this.pokemon == other.pokemon;
    }
    /**
     * Clone method to make an identical trainer to the one being cloned
     * @return 
     */
    public Trainer clone(){
        Trainer clone = new Trainer(name, xPos, yPos, dialog, pokemon.get(0),pokemon.get(1),pokemon.get(2));
        return clone;
    }
    /**
     * Displays the trainer the user will be moving around and
     * playing against on the map
     * @return 
     */
    public ImageIcon display(){
    return new ImageIcon("src/TrainerFront.png");
    }
    //To string for print statements of the trainers properties
    public String toString(){
        return "\n Name: "+ name
                +"\n xPos: "+ xPos
                +"\n yPos: "+ yPos
                +"\n Dialog: "+ dialog
                +"\n Pokemon: "+ pokemon;
    }
}
