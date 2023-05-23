
/**
 * The class represents the type of HollyDefensive wand.
 * 
 * @author (CAP) 
 * @version (1.3.5)
 */
public class HollyDefensive extends AbstractWand 
{
      
    /**
     * HollyDefensive Class Builder
     * 
     * @param Wand_name Wand name
     */
    public HollyDefensive(String Wand_name){
        super(Wand_name);
    }
    
    /**
     * method that returns the offending points of the wand
     * 
     * @return the offending points of the wand
     */
    public double useOfensiveWand(double energy,double resistance,double attack){

        return energy*0.7+attack*0.3;
    }

    /**
     * method that returns the wand's defensive points
     * 
     * @return the wand's defensive points
     */
    public double useDefensiveWand(double energy,double resistance,double attack){
        return energy*0.9+resistance*1.1;

    }

    
}

