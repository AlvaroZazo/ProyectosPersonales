/**
 * Main class that starts the game
 * 
 * @author (CAP) 
 * @version (1.3.8)
 */
import java.util.*;
import java.io.*;
public class Game
{
    private Hogwarts hogwarts;
    private ArrayList<Character> char_duel;
    private House victoryHouse;

    /**
     * 
     * Method responsible for making duels between the characters
     * of the house.
     * 
     * @param writer file to write
     * @throws IOException 
     */
    public Game(FileWriter writer) throws IOException{
        initialization(writer);
    }

    /**
     * Method that starts the game
     * 
     * @author (CAP) 
     * @version (2.0)
     */
    public void start(FileWriter writer) throws IOException{
        duels(writer);
        //endSimulation();
        writer.write("end of simulation:"); writer.write("\n");
        writer.write("------------------"); writer.write("\n");
        showData(writer);
        hogwarts.showDungeon(writer);
        checkVictory();
        showVictory(writer);
    }

    /**
     * 
     * Method that initializes game data
     * 
     * @param writer file to write
     * @throws IOException 
     */
    private void initialization(FileWriter writer) throws IOException{
        InitData1 game1;
        game1= new InitData1();
        //InitData2 game2;        
        //game2= new InitData2();
        hogwarts=hogwarts.getInstance();
        char_duel= new ArrayList<Character>();
        victoryHouse=null;
        showData(writer);
    }

    /**
     * 
     * Method responsible for making duels between the characters of the house.
     * 
     * @param writer file to write
     * @throws IOException 
     */
    private void duels(FileWriter writer) throws IOException{
        int i=0;
        int Max_turnos=10;
        boolean victory=false;

        while(i<Max_turnos && victory==false){
            writer.write("\n");
            writer.write("turn:<"+i+">"); writer.write("\n");
            writer.write("characters who are going to duel:"); writer.write("\n");
            writer.write("---------------------------------"); writer.write("\n");

            for(String houseName : hogwarts.getHousesName()){
                if(!hogwarts.getHouse(houseName).getArrayChar().isEmpty()){
                    //Insert into duel List
                    this.char_duel.add(hogwarts.getHouse(houseName).getCharacter(0));
                    //Remove From character house
                    this.hogwarts.getHouse(houseName).removeChar(0);
                }
            }

            //Sort the list of duelists by their energy in ascending order

            Collections.sort(char_duel, new Order_Energy_asc());

            for(Character duelist : char_duel){
                writer.write(duelist.toString()); writer.write("\n");
            }
            writer.write("\n");

            //DUELS FIGHT//
            int duelList_size;
            int l,d;//Iterator duel
            duelList_size=this.char_duel.size();

            writer.write("duels:"); writer.write("\n");
            writer.write("------"); writer.write("\n");
            for(l=0;l<duelList_size;l++){
                for(d=1;d<duelList_size;d++){

                    //Duels Messages
                    writer.write("<"+this.char_duel.get(0).getName()+"> is dueling against <"
                        +this.char_duel.get(d).getName()+">");
                    writer.write("\n");

                    if(this.char_duel.get(0).hasEnergy() &&
                    this.char_duel.get(d).hasEnergy() )
                        this.char_duel.get(0).figth(this.char_duel.get(d),writer);

                }
                //add the first element to the last position
                this.char_duel.add(this.char_duel.remove(0));
            }
            writer.write(""); writer.write("\n");
            writer.write("duel result:"); writer.write("\n");
            writer.write("------------"); writer.write("\n");

            while(!this.char_duel.isEmpty()){
                if(this.char_duel.get(0).hasEnergy()){
                    //Back to house
                    writer.write(this.char_duel.get(0).toString());
                    writer.write("\n");
                    writer.write(this.char_duel.get(0).getName()+" returns to the house"); 
                    writer.write("\n");

                    if(!hogwarts.getTreeWand().isEmpty()){
                        //Assig a new wand to the victor
                        this.char_duel.get(0).setmyWand(hogwarts.asignWand());
                        //Delete wand from Treeset wands.
                        hogwarts.getTreeWand().remove(hogwarts.getTreeWand().first());
                        //Print wand info
                        writer.write("new wand assigned: <"
                            +this.char_duel.get(0).getmyWand().toString());
                        writer.write("\n");
                    }

                    //The character return to his or her house.
                    hogwarts.getHouse(this.char_duel.get(0).getmyHouse())
                    .insertChar(this.char_duel.get(0));
                    //Delete victor from duel list.
                    this.char_duel.remove(0);
                    writer.write("\n");
                }else{
                    //Go to Dungeon
                    writer.write(this.char_duel.get(0).toString());
                    writer.write("\n");
                    writer.write(this.char_duel.get(0).getName()+" goes to dungeon");
                    writer.write("\n");
                    hogwarts.getDungeon().add(this.char_duel.get(0));
                    this.char_duel.remove(0);
                    writer.write("\n");
                }
            }

            //condicion de victoria
            victoryHouse=onlyOneHouse();
            if(victoryHouse==null){
                i++;
            }else{
                victory=true;
            }
        }
    }

    /**
     * 
     * Method in charge of displaying all information about houses and wands
     * belonging to Hogwarts
     * 
     * @param writer file to write
     * @throws IOException 
     */
    private void showData(FileWriter writer) throws IOException{
        writer.write("Houses:");
        writer.write("\n");
        writer.write("----------------");
        writer.write("\n");
        hogwarts.showHouses(writer);
        writer.write("new wands:");
        writer.write("\n");
        writer.write("----------------");
        writer.write("\n");
        hogwarts.showWands(writer);

    }

    /**
     * Method that returns the house that only has characters.
     * 
     * @return The house that only has characters in it or NULL if exist 
     * more than one.
     */
    private House onlyOneHouse(){
        int housesWithCharacters=0;
        House houseWinner= null;

        for(String houseName : hogwarts.getHousesName()){
            if(!hogwarts.getHouse(houseName).getArrayChar().isEmpty()){
                houseWinner=hogwarts.getHouse(houseName);
                housesWithCharacters++;
            }
        }

        if(housesWithCharacters==1){
            return houseWinner;
        }else{
            return null;
        }
    }

    /**
     * Method that checks which house is the winner
     * 
     */
    private void checkVictory(){
        House auxHouse=null;
        double totalEnergy=0;
        double auxTotalEnergy=0;
        double totalPoints=0;
        double auxTotalPoints=0;
        if(victoryHouse==null){
            for(String houseName : hogwarts.getHousesName()){
                if(victoryHouse==null){
                    victoryHouse=hogwarts.getHouse(houseName);
                    totalEnergy=victoryHouse.totalEnergy();
                    totalPoints=victoryHouse.totalPoints();
                    //writer.write("CASA 1: "+houseName);
                    //writer.write("CASA 1- Personajes: "+hogwarts.getHouse(houseName).getArrayChar().size());
                    //writer.write("CASA 1-Energia: "+totalEnergy);
                    //writer.write("CASA 1-totalPoints: "+totalPoints);
                }else{
                    auxHouse=hogwarts.getHouse(houseName);
                    auxTotalEnergy=auxHouse.totalEnergy();
                    auxTotalPoints=auxHouse.totalPoints();
                    //writer.write("CASA auX: "+houseName);
                    //writer.write("CASA auX- Personajes: "+ hogwarts.getHouse(houseName).getArrayChar().size());
                    //writer.write("CASA auX-Energia: "+auxTotalEnergy);
                    //writer.write("CASA auX-totalPoints: "+auxTotalPoints);
                    if(auxHouse.getArrayChar().size()==victoryHouse.getArrayChar().size()){
                        if(auxTotalEnergy==totalEnergy){
                            if(auxTotalPoints<totalPoints){
                                //asignaciones
                                victoryHouse=auxHouse;
                                totalEnergy=auxTotalEnergy;
                                totalPoints=auxTotalPoints;
                            }
                        }else{
                            if(auxTotalEnergy>totalEnergy){
                                //asignaciones
                                victoryHouse=auxHouse;
                                totalEnergy=auxTotalEnergy;
                                totalPoints=auxTotalPoints;
                            }
                        }
                    }else{
                        if(auxHouse.getArrayChar().size()>victoryHouse.getArrayChar().size()){
                            //asignaciones
                            victoryHouse=auxHouse;
                            totalEnergy=auxTotalEnergy;
                            totalPoints=auxTotalPoints;
                        }
                    }
                }
            }
        }

    }

    /**
     * Method that shows the winning house
     * 
     * @param writer file to write
     * @throws IOException 
     */
    private void showVictory(FileWriter writer) throws IOException{
        writer.write("the winner house is: ");
        writer.write("\n");
        victoryHouse.showHouse(writer);  
    }
}
