import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * In this class each house is represented, in which the different 
 * characters are grouped together.
 * 
 * 
 * @author (CAP) 
 * @version (1.3.8)
 */
public class House
{
    // instance variables - replace the example below with your own

    protected ArrayList<Character> Char_list;
    private String H_name;
    /**
     * Constructor for objects of class House
     * 
     * @param H_name house name
     */
    public House(String H_name)
    {
        this.H_name=H_name;
        Char_list= new ArrayList<Character>();
    }

    /**
     * Getter method of attribute H_name
     * 
     * @return House name
     */
    public String getH_name(){
        return this.H_name;
    }

    /**
     * Method that allows you to insert a Character in the house's
     * character list
     * 
     * @param c Character to be inserted
     */
    public void insertChar(Character c){
        this.Char_list.add(c);

    }

    /**
     * Method that allows you to remove a Character from the House
     * Character list
     * 
     * @param i Character's position in the list
     */
    public void removeChar(int i){
        this.Char_list.remove(i);
    }

    /**
     * Method that shows the name of the house, as well as the list
     * of characters it has
     * 
     * @param writer file to write
     * @throws IOException 
     */
    public void showHouse(FileWriter writer) throws IOException{

        writer.write("House:"+this.getH_name());
        writer.write("\n");
        int i=0;

        while(i<this.Char_list.size()){
            writer.write(this.Char_list.get(i).toString());
            writer.write("\n");
            i++;
        }
        writer.write("\n");
    }

    /**
     * Method that returns a Character from the House Character list
     * 
     * @param i Position of the character in the list
     * @return Character on the list
     */
    public Character getCharacter(int i){
        return this.Char_list.get(i);
    }

    /**
     * Getter method of the Char_list object
     * 
     * @return The List of Characters
     */
    public ArrayList getArrayChar(){
        return this.Char_list;
    }

    /**
     * Method that sums up the energy of every Character in that House
     * 
     * @return The energy of all the characters in the house adds up
     */
    public double totalEnergy(){
        double totalEnergy=0;
        for(Character c : this.Char_list){
            totalEnergy=totalEnergy+c.getEnergy();
        }
        return totalEnergy;                
    }

    /**
     * Method that sums up the attack and defense points of each character
     * in that house
     * 
     * @return The sum of the characters' attack and defence points
     */
    public double totalPoints(){
        double totalPoints=0;
        for(Character c : this.Char_list){
            totalPoints=totalPoints+c.getDefensive()+c.getOffensive();
        }
        return totalPoints;    
    }
}