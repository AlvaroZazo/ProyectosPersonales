/**
 * This class represents the castle where the characters are and the duels
 * are established.
 * This class uses the Singleton Pattern Design
 * 
 * @author (CAP) 
 * @version (1.3.8)
 * 
 */
import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Set;
public class Hogwarts
{
    //ArrayList for Wands
    private TreeSet<Wand> wands;
    private HashMap<String ,House> houses;
    private static Hogwarts instance;
    private ArrayList<Character> Dungeon;
    private ArrayList<String> housesName;
    /**
     * Constructor for objects of class Hogwarts
     */
    private Hogwarts()
    {
        wands= new TreeSet<Wand>();
        houses= new HashMap<String ,House>();
        Dungeon= new ArrayList<Character>();
        housesName = new ArrayList<String>();
    }

    /**
     * Method used to initialize the creation of the Hogwarts instance
     * (Singleton Pattern)
     * 
     * @return Object Hogwarts
     */
    public synchronized static
    Hogwarts getInstance(){
        if(instance == null){
            instance= new Hogwarts();
        }
        return instance;
    }

    /**
     * Method for adding a new wand to the Hogwarts wand list
     * 
     * @param myWand Wand to add to Hogwarts wand list
     */
    public void newWand(Wand myWand){
        this.wands.add(myWand);
    }

    /**
     * Method that adds a house to the Hogwarts house Set Map
     * 
     * @param H_name House name
     * @param H Object House
     */
    public void setHouse(String H_name,House H){
        this.houses.put(H_name, H);
    }

    /**
     * Method that returns a house from the Hogwarts Home SetMap by passing
     * the name of the corresponding house by parameter
     * 
     * @return The house using the name of the parameter
     */
    public House getHouse(String H_name){
        return this.houses.get(H_name);
    }

    /**
     * Method that shows the information of the Hogwarts Houses
     * 
     * @param writer file to write
     * @throws IOException 
     */
    public void showHouses(FileWriter writer) throws IOException{
        for(String houseName : housesName){
        this.houses.get(houseName).showHouse(writer);        
        }
    }

    /**
     * Method that shows the information of the Hogwats Wands
     * 
     * @param writer file to write
     * @throws IOException 
     */
    public void showWands(FileWriter writer) throws IOException{
        for(Wand Thewand : wands){
            writer.write("Wand:<"+Thewand.getWand_name()+
                " ("+Thewand.getClass().getSimpleName()+")>");
            writer.write("\n");
        }
    }

    /**
     * Method that returns a wand to assign it to a character
     * 
     * @return The Wand to assign
     */
    public Wand asignWand(){
        return wands.first();
    }

    /**
     * Method that returns the TreeWand of Hogwarts (Getter method)
     * 
     * @return TreeWands of Hogwarts
     */
    public TreeSet getTreeWand(){
        return this.wands;
    }

    /**
     * Method that assign a TreeWand to the TreeWand of Hogwarts 
     * (Setter method)
     * 
     * @param wands Wands to assign to TreeWands of Hogwarts
     */
    public void setTreeWand(TreeSet wands){
        this.wands=wands;
    }

    /**
     * Method that returns the array of characters defeated in duels
     * (Getter method)
     * 
     * @return the array of characters defeated in duels
     */
    public ArrayList getDungeon(){
        return this.Dungeon;
    }

    /**
     * Setter method of attribute Dungeon
     * 
     * @param dungeon the array of characters defeated in duels
     */
    public void setDungeon(ArrayList dungeon){
        this.Dungeon=dungeon;
    }

    /**
     * Method that shows the characters in the dungeon
     * 
     * @param writer file to write
     * @throws IOException 
     */
    public void showDungeon(FileWriter writer) throws IOException{
        writer.write("dungeon characters:"); writer.write("\n");
        writer.write("-------------------"); writer.write("\n");
        writer.write("\n");
        for(Character c : this.Dungeon){
            writer.write(c.toString()); writer.write("\n");
        }
        writer.write("\n");
    }
    /**
     * HashMap houses getter method
     * 
     * @return HashMap Houses
     */
    public HashMap getHashMapH(){
        return this.houses;
    }

    /**
     * HashMap houses setter method
     * 
     * @param HashMap Houses
     */
    public void setHashMapH(HashMap houses){
        this.houses=houses;
    }

    /**
     * ArrayList housesName setter method
     * 
     * @param ArrayList houses name
     */
    public void setHousesName(ArrayList housesName){
        this.housesName=housesName;
    }

    /**
     * ArrayList housesName getter method
     * 
     * @return ArrayList houses name
     */
    public ArrayList<String> getHousesName(){
        return this.housesName;
    }
}
