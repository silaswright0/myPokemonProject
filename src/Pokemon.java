
import javax.swing.ImageIcon;

/**
 * Ryan Xayavong, Silas Wright, Risto Miettinen
 */


public interface Pokemon {
    public String getType();
    public String getType2();
    public String getName();//accessor
    public void setName(String name);//mutator
    public double health();//accessor
    public void setHealth(double health);//mutator
    public void resetHealth();//sets health attribute to maximum
    public String getAbility1();//accessor
    public String getAbility2();//accessor
    public String getAbility3();//accessor
    public String getAbility4();//accessor
    public String toString();//represents pokemon as string
    public int getMaxHealth();//accessor
    public void setMaxHealth(int maxHealth);//mutator
    public void ability1(Pokemon other);
    public void ability2(Pokemon other);
    public void ability3(Pokemon other);
    public void ability4(Pokemon other);
    public ImageIcon display();//returns the image of pokemon
    public Pokemon clone();//returns a new instance of the class with the same attributes


}
