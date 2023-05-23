/**
 * This class represents a defensive type character.
 * 
 * @author (CAP) 
 * @version (1.3.5)
 */
public class DefensiveCharacter extends Character
{


    /**
     * Constructor for objects of class Desensive
     * 
     * @param _name Character name
     * @param myWand Wand name
     * @param myHouse Name of the house it belongs to
     */
    public DefensiveCharacter(String _name,Wand myWand,String myHouse)
    {
        super(_name,myWand,myHouse);
        this.setDefensive(25.0);
    }
}