
/**
 * This class represents a offensive type character.
 * 
 * @author (CAP) 
 * @version (1.3.5)
 */
public class OffensiveCharacter extends Character
{

    /**
     * Constructor for objects of class Offensive
     * 
     * @param _name Character name
     * @param myWand Wand name
     * @param myHouse Name of the house it belongs to
     */
    public OffensiveCharacter(String _name,Wand myWand,String myHouse)
    {
        super(_name,myWand,myHouse);
        this.setOffensive(25.0);
    }
}