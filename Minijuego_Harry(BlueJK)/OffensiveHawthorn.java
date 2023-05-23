
/**
 * The class represents the type of OffensiveHawthorn wand.
 * 
 * @author (CAP) 
 * @version (1.3.5)
 */
public class OffensiveHawthorn extends AbstractWand
{
    
    
    /**
     * OffensiveHawthorn Class Builder
     * 
     * @param Wand_name Wand name
     */
    public OffensiveHawthorn(String Wand_name){
        super(Wand_name);
    }

    /**
     * method that returns the offending points of the wand
     * 
     * @return the offending points of the wand
     */
    public double useOfensiveWand(double energy,double resistance,double attack){
        return energy*0.6+attack*1.4;
    }

    /**
     * method that returns the wand's defensive points
     * 
     * @return the wand's defensive points
     */
    public double useDefensiveWand(double energy,double resistance,double attack){
        return energy*0.8+resistance*0.2;
    }
    
    
}

