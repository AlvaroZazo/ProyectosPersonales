/**
 * Abstract class PotionExtra - This class represents the potion that 
 * a character can take.
 * This class also allows you to use the decorator design pattern
 * 
 * @author: CAP
 * Date: 3/1/2020
 */
public abstract class PotionExtra extends Character 
{
    private Character decoratedCharacter;  
    private String potion_name;
    
    /**
     * Constructor method of the PotionExtra class
     * 
     * @param c Character to apply the potion to
     * @param potion_name Potion name
     */
    public PotionExtra(Character c, String potion_name){
        super(c.getName(),c.getmyWand(),c.getmyHouse());
        this.potion_name=potion_name;
       
        decoratedCharacter= c;
    }
    
    /**
     * Method that returns the character's defensive points
     * 
     * @return the character's defensive points
     */
    public double getDefensive(){
        return this.decoratedCharacter.getDefensive();
    }
    
    /**
     * Method that returns the character's offensive points
     * 
     * @return the character's offensive points
     */
    public double getOffensive(){
        return this.decoratedCharacter.getOffensive();
    }
}
