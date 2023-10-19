
/**
 * Ryan Xayavong, Silas Wright, Risto Miettinen
 * 1/21/22
 * Abstract class for each character of pokemon will follow this abstract class format
 */
//implement all the properties from the pokemon interface
abstract public class AbstractPokemon implements Pokemon {

    static int maxHealth; //the maximum health of the pokemon
    protected String name; //the name of the pokemon
    protected double health; //the current health of the pokemon
    protected String ability1; //the first ability of the pokemon
    protected String ability2; //the second ability of the pokemon
    protected String ability3; //the third ability of the pokemon
    protected String ability4; //the fourth ability of the pokemon
    protected int level; //the level of pokemon
    /**
     * Default constructor for pokemon objects that are set to be the pokemon and its properties
     * @param pName //the name of the pokemon
     * @param pHealth //the current health of the pokemon
     * @param pAbility1 //the first ability of the pokemon
     * @param pAbility2 //the second ability of the pokemon
     * @param pAbility3 //the third ability of the pokemon
     * @param pAbility4 //the fourth ability of the pokemon
     */
    public AbstractPokemon(String pName, double pHealth, String pAbility1, String pAbility2, String pAbility3, String pAbility4) {
        //set attribues with the formal parameters
        this.name = pName;
        this.health = pHealth;
        this.ability1 = pAbility1;
        this.ability2 = pAbility2;
        this.ability3 = pAbility3;
        this.ability4 = pAbility4;

    }
    /**
     * Secondary constructor to get all the properties of the pokemon we have set as well as the pokemons level
     * but as of 1/27/22, we have not been able to add levels and will not be used throughout our program
     * @param pName //the name of the pokemon
     * @param pHealth //the health of the pokemon
     * @param pAbility1 //the first ability of the pokemon
     * @param pAbility2 //the second ability of the pokemon
     * @param pAbility3 //the third ability of the pokemon
     * @param pAbility4 //the fourth ability of the pokemon
     * @param pLevel //the level of the pokemon
     */
    public AbstractPokemon(String pName, double pHealth, String pAbility1, String pAbility2, String pAbility3, String pAbility4, int pLevel) {
        this(pName, pHealth, pAbility1, pAbility2, pAbility3, pAbility4);//call previous constructor
        this.level = pLevel;//set attribute to formal parameter

    }
    /**
     * Mutator to set the name of the pokemon inputed
     * @param pName 
     */
    public void setName(String pName) {
        name = pName;
    }
    /**
     * Accessor to get the name of the pokemon when the method is called
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * Mutator to set the health of the pokemon
     * @param pHealth 
     */
    public void setHealth(double pHealth) {
        health = pHealth;
    }
    /**
     * accessor to get the health of the pokemon when method is called
     * @return 
     */
    public double getHealth() {
        return health;
    }
    //Reset health method when the pokemon goes to the pokemon center to heal their pokemon
    public void resetHealth() {
        health = maxHealth;
    }
    /**
     * Accessor to get the name of the first ability
     * @return 
     */
    public String getAbility1() {
        return ability1;
    }
    /**
     * Accessor to get the name of the second ability
     * @return 
     */
    public String getAbility2() {
        return ability2;
    }
    /**
     * Accessor to get the name of the third ability
     * @return 
     */
    public String getAbility3() {
        return ability3;
    }
    /**
     * Accessor to get the name of the fourth ability
     * @return 
     */ 
    public String getAbility4() {
        return ability4;
    }

    //Accessor to get the max health will be set by us and will return the max health when called
    public int getMaxHealth() {
        return maxHealth;
    }
    /**
     * Mutator to set the max health
     * @param pMaxHealth 
     */
    public void setMaxHealth(int pMaxHealth) {
        maxHealth = pMaxHealth;
    }

    /**
     * Pokemon's first abilities which will be used to attack and decrease the opponents health
     * @param other 
     */
    public void ability1(Pokemon other) {

    }
     /**
     * Pokemon's second abilities which will be used to attack and decrease the opponents health
     * @param other 
     */
    public void ability2(Pokemon other) {

    }
    /**
     * Pokemon's third abilities which will be used to attack and decrease the opponents health
     * @param other 
     */
    public void ability3(Pokemon other) {

    }
     /**
     * Pokemon's fourth abilities which will be used to attack and decrease the opponents health
     * @param other 
     */
    public void ability4(Pokemon other) {

    }
    /**
     * Display the image of the pokemon
     * @param x
     * @param y 
     */
    public void display(int x, int y) {

    }
    //to string to print out the pokemons propertys
    public String toString() {
        return "\n Name: " + name
                + "\n Health: " + health
                + "\n Max Health: " + maxHealth
                + "\n Ability One: " + ability1
                + "\n Ability Two: " + ability2
                + "\n Ability Three: " + ability3
                + "\n Ability Four: " + ability4;
    }
    //clone method to help us clone the pokemon you catch from the trainer
    abstract public Pokemon clone();

}
