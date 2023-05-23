import java.io.FileWriter;
import java.io.IOException;

/**
 * Abstract class Personaje - This class defines the common characteristics
 * of the characters that exist in the simulation
 * 
 * @author: CAP
 * Date: 3/1/2020
 */
public abstract class Character
{
    private String name;
    private double energy;
    private double offensive;
    private double defensive;
    private String myHouse;
    private Wand myWand;
    /**
     * Character Class Builder
     * 
     * @param _name Character name
     * @param myWand Wand name
     * @param myHouse Name of the house it belongs to
     */
    Character (String _name,Wand myWand,String myHouse)
    {
        this.name=_name;
        this.energy=20.0;
        this.offensive=20.0;
        this.defensive=20.0;
        this.myWand=myWand;
        this.myHouse=myHouse;
    }
    /**
     * Getter method of the name attribute
     * 
     * @return Char name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method of the name attribute
     * 
     * @param name Char name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method of the myHouse attribute
     * 
     * @return House name
     */
    public String getmyHouse() {
        return this.myHouse;
    }

    /**
     * Setter method of the myHouse attribute
     * 
     * @Param myHouse House name
     */
    public void setmyHouse(String myHouse) {
        this.myHouse=myHouse;
    }

    /**
     * Getter method of the Energy attribute
     * 
     * @return The character's energy
     */
    public double getEnergy() {
        return energy;
    }

    /**
     * Setter method of the Energy attribute
     * 
     * @param energy The new energy of the character
     */
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    /**
     * Getter method of the Offensive attribute
     * 
     * @return The character's offensive points
     */
    public double getOffensive() {
        return offensive;
    }

    /**
     * Setter method of the Offensive attribute
     * 
     * @param offensive the new offensive points of the character
     */
    public void setOffensive(double offensive) {
        this.offensive = offensive;
    }

    /**
     * Getter method of the Defensive attribute
     * 
     * @return The character's Defensive points
     */
    public double getDefensive() {
        return defensive;
    }

    /**
     * Setter method of the Defensive attribute
     * 
     * @param defensive the new defensive points of the character
     */
    public void setDefensive(double defensive) {
        this.defensive = defensive;
    }

    /**
     * Setter method of the myWand Object
     * 
     * @param myWand new wand for the character
     */
    public void setmyWand(Wand myWand){
        this.myWand=myWand;
    }

    /**
     * Getter method of the myWand Object
     * 
     * @return The character's wand
     */
    public Wand getmyWand(){
        return this.myWand;
    }

    /**
     * Method that checks if a character has energy
     * 
     * @return "True" if the character has energy. "False" if not
     */
    public boolean hasEnergy(){
        if(this.getEnergy()>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Method that performs the fight between two characters
     * 
     * @param c Character who defends from combat
     * @param writer file to write
     * @throws IOException 
     */
    public void figth (Character c, FileWriter writer) throws IOException
    {

        double points; 
        double PA=this.myWand.useOfensiveWand(this.getEnergy(),
                this.getDefensive(),this.getOffensive());
        double PD=c.myWand.useDefensiveWand(c.getEnergy(),
                c.getDefensive(),c.getOffensive());
          
        //writer.write("att="+PA);
        //writer.write("DEF="+PD);
        points=PA-PD;
        //writer.write("tOT="+points);

        if(points>0)
        {
            c.setEnergy(c.getEnergy()-points);
            if(c.getEnergy()<=0){
                c.setEnergy(0.0);
            }
        }else{

            writer.write(c.getName()+" blocks attack");
            writer.write("\n");
        }
        writer.write("attack points of <"+this.getName()+"> are: <"
          +PA+">");
        writer.write("\n");
          writer.write("resistance points of <"+c.getName()+"> are: <"
          +PD+">");
          writer.write("\n");
          writer.write("the remaining energy of <"+c.getName()+
          "> after the duel are: <"+c.getEnergy()+">");
          writer.write("\n");
          writer.write("\n");
          
    }
    
    /**
     * Method that shows the character's data
     */
    public String toString(){
        return "character: <"
            +this.getName()+"> <e:"+this.getEnergy()+"> "+"<o:"+this.getOffensive()+
            "> "+"<d:"+this.getDefensive()+"> "+"<wand:"+
            this.myWand.toString();
    }
    
    
}