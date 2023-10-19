/**
 * Ryan,Silas,Risto
 * 1/27/22
 * This class will be used to store information of pokemon from its id to to is health and ability names
 * and will show to the player in-game when used
 * @author Ryan
 */
public class Pokedex {
    /**creating all the variables that will contain all the pokemon's properties
     * such as names and ID number and health, etc.
     */
    private String name;//name of the pokedmon
    private int idNum;//id number of pokemon
    private int maxHealth;// maximum health of pokemon
    private String type ;//the type of pokemon
    private String ability1;//the pokemon's first ability
    private String ability2;//the pokemon's second ability
    private String ability3;//the pokemon's third ability
    private String ability4;//the pokemon's fourth ability
    private boolean caught;//boolean representing if the pokemon is caught
    
    /**
     * Default constructor of the pokemons attributes
     * @param pName the name of pokemon
     * @param pIDNum the id number of pokemon
     * @param pMaxHealth maximum health of pokemon
     * @param type the type of pokemon
     * @param pAbility1 the pokemon's first ability
     * @param pAbility2 the pokemon's second ability
     * @param pAbility3 the pokemon's third ability
     * @param pAbility4 the pokemon's fourth ability
     */
    public Pokedex(String pName, int pIDNum, int pMaxHealth,String type, String pAbility1, String pAbility2, String pAbility3, String pAbility4){
        //set attributes with formal parameters
        this.name = pName;
        this.idNum = pIDNum;
        this.maxHealth = pMaxHealth;
        this.type = type ;
        this.ability1 = pAbility1;
        this.ability2 = pAbility2;
        this.ability3 = pAbility3;
        this.ability4 = pAbility4;
    }
    /**
     * Secondary constructor that will add if the pokemon was caught but we later on did not
     * implement this and focused our time and resources on more important aspects so it will not show
     * @param pName the name of pokemon
     * @param pIDNum the id number of pokemon
     * @param pMaxHealth maximum health of pokemon
     * @param type the type of pokemon
     * @param pAbility1 the pokemon's first ability
     * @param pAbility2 the pokemon's second ability
     * @param pAbility3 the pokemon's third ability
     * @param pAbility4 the pokemon's fourth ability
     * @param pCaught boolean if the pokemon is caught
     */
    public Pokedex (String pName, int pIDNum, int pMaxHealth, String type, String pAbility1, String pAbility2, String pAbility3, String pAbility4, boolean pCaught){
        this(pName, pIDNum, pMaxHealth,type, pAbility1, pAbility2, pAbility3, pAbility4);//calls previous contructor
        this.caught = pCaught;//sets attribute to the formal parameter
    }
    /**
     * Accessor to get the name of the pokemon
     * @return 
     */
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
     * Accessor to get the ID number of the pokemon
     * @return 
     */
    public int getIDNum(){
        return idNum;
    }
    /**
     * Mutator to set the ID number of the pokemon
     * @param pIDNum 
     */
    public void setIDNum(int pIDNum){
        idNum = pIDNum;
    }
    /**
     * Accessor to check if the pokemon was caught and will either get true or false
     * @return 
     */
    public boolean getCaught(){
        return caught;
    }
    /**
     * Mutator to set the pokemon to a state if it was caught or not
     * @param pCaught 
     */
    public void setCaught(boolean pCaught){
        caught = pCaught;
    }
    /**
     * To string will return a print statement of the pokemons properties onto the pokedex
     * @return 
     */
    public String toString(){
        return "\n Name: "+ name
              +"\n ID Numbers: "+ idNum
              +"\n Max Health: "+ maxHealth
              +"\n Ability One: "+ ability1
              +"\n Ability Two: "+ ability2
              +"\n Ability Three: "+ ability3
              +"\n Ability Four: "+ ability4;
    }
    /**
     * equals method to check if the pokemon are identical to eachother
     * @param other
     * @return 
     */
    public boolean equals(Pokedex other){
        return this.name.equals(other.name)
                && this.idNum == other.idNum
                && this.maxHealth == maxHealth
                && this.ability1.equals(other.ability1)
                && this.ability2.equals(other.ability2)
                && this.ability3.equals(other.ability3)
                && this.ability4.equals(other.ability4);
    }
    /**
     * Returns a clone of a pokemon to be identical to another
     * @return 
     */
    public Pokedex clone(){
        Pokedex clone = new Pokedex(name,idNum,maxHealth,type,ability1,ability2,ability3,ability4);
        return clone;
    }
   
}
