/**
 * Abstract class Wand - Class that allows the character carrying a Wand 
 * object to generate his offensive and defensive points for his duels
 * 
 * @author: CAP
 * Date: 3/1/2020
 */
public abstract class AbstractWand implements Wand, Comparable<Wand>
{
    private String Wand_name;
    private String Wand_type;

    /**
     * Wand Class Builder
     * 
     * @param Wand_name Wand name
     */
    public AbstractWand(String Wand_name){
        this.Wand_name=Wand_name;
    }
    
    /**
     * Wand_name atribute setter method
     * 
     * @param Wand_name Wand name
     */
    public void setWand_name(String Wand_name){

        this.Wand_name=Wand_name;
    }

    /**
     * Wand_name atribute getter method
     * 
     * @return Wand name
     */
    public String getWand_name(){
        return this.Wand_name;
    }

    /**
     * CompareTo method that compares wands
     * 
     * @param w Wand to Compare
     * @return a negative integer, zero, or a positive integer as this Wand
     * is less than, equal to, or greater than the specified Wand.
     */
    @Override
    public int compareTo(Wand w){
        return this.getWand_name().compareTo(w.getWand_name());
    }
    
    /**
     * Method that shows wand data
     * 
     * @return the data of the wand
     */
    public String toString(){
        return this.getWand_name()+"("+this.getClass().getSimpleName()+")"+"> ";
    }
}