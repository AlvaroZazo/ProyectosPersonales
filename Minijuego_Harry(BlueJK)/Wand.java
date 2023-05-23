
/**
 * Interface Class of the Wand Object
 * 
 * @author (CAP) 
 * @version (1.3.5)
 */
public interface Wand {
    //method that returns the offending points of the wand
    public double useOfensiveWand(double energy,double resistance,double attack);
    //method that returns the wand's defensive points
    public double useDefensiveWand(double energy,double resistance,double attack);
    //Wand_name atribute setter method
    public void setWand_name(String Wand_name);
    //Wand_name atribute getter method
    public String getWand_name();
    //Method that shows wand data
    public String toString();    
}
