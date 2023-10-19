
import javax.swing.ImageIcon;


/**
 * Ryan Xayavong, Silas Wright, Risto Miettinen
 */

public class Bulbasaur extends AbstractPokemon {
    int maxHealth = 45 ;
    private static String type = "Grass";
    private static String type2 = "poison";
    public Bulbasaur(String pName, double pHealth, String pAbility1, String pAbility2, String pAbility3, String pAbility4) {
        super(pName, pHealth, pAbility1, pAbility2, pAbility3, pAbility4);
    }
    public String getType(){
        return type;
    }
    public String getType2(){
        return type2;
    }
    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public double health() {
        return health;
    }

    public void setHealth(double pHealth) {
        health = pHealth;
    }

    //Method to reset health back to max health which is full bar
    public void resetHealth() {
        health = maxHealth ;
        
    }

    public String getAbility1() {
        return ability1;
    }

    public String getAbility2() {
        return ability2;
    }

    public String getAbility3() {
        return ability3;
    }

    public String getAbility4() {
        return ability4;
    }

    public String toString() {
        return "\n Name: " + name
                + "\n Health: " + health
                + "\n Max Health: " + maxHealth
                + "\n Ability One: " + ability1
                + "\n Ability Two: " + ability2
                + "\n Ability Three: " + ability3
                + "\n Ability Four: " + ability4;
    }

    public boolean equals(Bulbasaur other) {
        return this.name.equals(other.name)
                && this.health == other.health
                && this.maxHealth == other.maxHealth
                && this.ability1.equals(other.ability1)
                && this.ability2.equals(other.ability2)
                && this.ability3.equals(other.ability3)
                && this.ability4.equals(other.ability4);
    }

    public Pokemon clone() {
        Bulbasaur clone = new Bulbasaur(name, health, ability1, ability2, ability3, ability4);
        return clone;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int pMaxHealth) {
        maxHealth = pMaxHealth;
    }

    //Abilities for later use
    public void ability1(Pokemon other) {
        double attack = (Math.random()*10)+10;
        other.setHealth(other.health() - attack);
        if(other.getType().equals("Rock") || other.getType2().equals("Rock") || other.getType().equals("Water")||other.getType2().equals("Water") || other.getType().equals("Ground") || other.getType2().equals("Ground")){
            other.setHealth(other.health() - attack);
        }

    }

    public void ability2(Pokemon other) {
        double attack = (Math.random()*7)+4;
        other.setHealth(other.health() - attack);

    }

    public void ability3(Pokemon other) {
        double attack = (Math.random()*10)+4;
        other.setHealth(other.health() - attack);
        if(other.getType().equals("Rock") || other.getType2().equals("Rock") || other.getType().equals("Water")||other.getType2().equals("Water") || other.getType().equals("Ground") || other.getType2().equals("Ground")){
            other.setHealth(other.health() - attack);
        }

    }

    public void ability4(Pokemon other) {
        double attack = (Math.random()*10)+8;
        other.setHealth(other.health() - attack);
        if(other.getType().equals("Rock") || other.getType2().equals("Rock") || other.getType().equals("Water")||other.getType2().equals("Water") || other.getType().equals("Ground") || other.getType2().equals("Ground")){
            other.setHealth(other.health() - attack);
        }

    }

    public ImageIcon display() {
        ImageIcon pokemon = new ImageIcon("src/bulbRight.png");
        return pokemon;
    }
    
   

}
