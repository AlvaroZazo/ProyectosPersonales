
/**
 * The class represents the type of Invigoration Potion.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InvigorationPotion extends PotionExtra
{
    /**
     * Constructor method of the InvigorationPotion class
     * 
     * @param c Character to apply the potion to
     * @param potion_name Potion name
     */
    public InvigorationPotion(Character c,String potion_name)
    {
        super(c,potion_name);
    }

    /**
     * Method that returns the character's defensive points
     * 
     * @return the character's defensive points
     */
   public double getDefensive(){
       return super.getDefensive()*1.4;
    }
}
