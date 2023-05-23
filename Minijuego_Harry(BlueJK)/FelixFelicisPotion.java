
/**
 * The class represents the type of FelixFelicis Potion.
 * 
 * @author (CAP) 
 * @version (1.3.5)
 */
public class FelixFelicisPotion extends PotionExtra
{
     

    /**
     * Constructor method of the FelixFelicisPotion class
     * 
     * @param c Character to apply the potion to
     * @param potion_name Potion name
     */
    public FelixFelicisPotion(Character c,String potion_name)
    {
        super(c,potion_name);
        
    }

    /**
     * Method that returns the character's offensive points
     * 
     * @return the character's offensive points
     */
   public double getOffensive(){
       return super.getOffensive()*1.3;
    }
}
