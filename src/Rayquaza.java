/**
 * Ryan,Silas,Risto
 * 1/27/22
 * Rayquaza class to represent rayquaza and will be given a name and a set of its own damage when the abilities are given
 * through instantiating the object
 */

//import image icon to display image on game screen
import javax.swing.ImageIcon;
//extends the pokemon abstract class for methods and properties of the object
public class Rayquaza extends AbstractPokemon{
    //setting the max health to 45
    int maxHealth = 105 ;
    private String type = "Dragon";
    private String type2 = "Flying";
    /**
     * Default constructor of the pokemon
     * @param pName the name of pokemon
     * @param pHealth the health of pokemon
     * @param pAbility1 the first ability of the pokemon
     * @param pAbility2 the second ability of the pokemon
     * @param pAbility3 the third ability of the pokemon
     * @param pAbility4 the fourth ability of the pokemon
     */
    public Rayquaza(String pName,double pHealth, String pAbility1, String pAbility2, String pAbility3, String pAbility4){
        super(pName, pHealth, pAbility1, pAbility2, pAbility3, pAbility4);//calls the superclasses contructor
    }
    /**
     * Accessor to get the name of the pokemon
     * @return 
     */
    public String getType(){
        return type;
    }
    public String getType2(){
        return type2;
    }
    public String getName(){
        return name;
    }
    /**
     * Mutator to set the name of the pokemon
     * @param pName 
     */
    public void setName(String pName){
        name = pName;
    }
    /**
     * Accessor to get the health of the pokemon
     * @return 
     */
   public double health(){
       return health;
   }
   /**
     * Mutator to set the health of the pokemon
     * @param pHealth 
     */
    public void setHealth(double pHealth){
    health = pHealth;
    }
    //Method to reset health back to max health which is full bar
    public void resetHealth(){
        health = maxHealth ;
    }
    /**
     * Accessor to get the pokemons first ability
     * @return 
     */
    public String getAbility1(){
    return ability1;
    }
    /**
     * Accessor to get the pokemons second ability
     * @return 
     */
    public String getAbility2(){
        return ability2;
    }
    /**
     * Accessor to get the pokemons third ability
     * @return 
     */
    public String getAbility3(){
        return ability3;
    }
    /**
     * Accessor to get the pokemons fourth ability
     * @return 
     */
    public String getAbility4(){
        return ability4;
    }
    //To string returns print out all the properties of this object once called
    public String toString(){
        return "\n Name: "+ name
              +"\n Health: "+ health
              +"\n Max Health: "+ maxHealth
              +"\n Ability One: "+ ability1
              +"\n Ability Two: "+ ability2
              +"\n Ability Three: "+ ability3
              +"\n Ability Four: "+ ability4;
    }
    /**
     * equals method to check if two object are the same
     * @param other
     * @return 
     */
    public boolean equals(Skiddo other){
        return this.name.equals(other.name)
                && this.health == other.health
                && this.maxHealth == other.maxHealth
                && this.ability1.equals(other.ability1)
                && this.ability2.equals(other.ability2)
                && this.ability3.equals(other.ability3)
                && this.ability4.equals(other.ability4);
    }
    /**
     * clone method to be used when you catch the pokemon and making sure it has the same abilities
     * @return 
     */
    public Pokemon clone(){
        Rayquaza clone = new Rayquaza(name,health,ability1,ability2,ability3,ability4);
        return clone;
    }
    /**
     * Accessor to get the max health
     * @return 
     */
    public int getMaxHealth(){
        return maxHealth;
    }
    /**
     * Mutator to set the max health of the pokemon
     * @param pMaxHealth 
     */
    public void setMaxHealth(int pMaxHealth){
        maxHealth = pMaxHealth;
    }
    /**
     * Ability one will have a specific amount of damage depending on the pokemons ability which
     * will be set by us
     * @param other 
     */
    public void ability1(Pokemon other){
        double attack = (Math.random()*10)+8;
        other.setHealth(other.health() - attack);
        if(other.getType().equals("Bug") || other.getType2().equals("Bug") || other.getType().equals("Grass")||other.getType2().equals("Grass")){
            other.setHealth(other.health() - attack);
        }
    }
    /**
     * Ability two will have a specific amount of damage depending on the pokemons ability which
     * will be set by us
     * @param other 
     */
    public void ability2(Pokemon other){
        double attack = (Math.random()*4)+8;
        other.setHealth(other.health()-attack);
    }
    /**
     * Ability three will have a specific amount of damage depending on the pokemons ability which
     * will be set by us
     * @param other 
     */
    public void ability3(Pokemon other){
        double attack = (Math.random()*10)+10;
        other.setHealth(other.health() - attack);
        if(other.getType().equals("Bug") || other.getType2().equals("Bug") || other.getType().equals("Grass")||other.getType2().equals("Grass")){
            other.setHealth(other.health() - attack);
        }
    }
    /**
     * Ability four will have a specific amount of damage depending on the pokemons ability which
     * will be set by us
     * @param other 
     */
    public void ability4(Pokemon other){ 
        this.health += 13;
        if (health > getMaxHealth()){
        this.health = getMaxHealth();
    }
    }
    /**
     * display the 8-bit sprite onto the screen for players to see
     * @return 
     */
    public ImageIcon display(){
        ImageIcon pokemon = new ImageIcon("src/rayRightResized.png");
        return pokemon;
    }
}
