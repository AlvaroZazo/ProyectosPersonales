
/**
 * Class to init data of the simulation. 
 * 
 * 
 * @author CAP 
 * @version 1.3.5
 */

import java.util.*;

public class InitData1 
{
    private Hogwarts hogwarts; //hogwarts must be a unique instance

    /**
     * Constructor for objects of class InitData
     */
    public InitData1()
    {
        hogwarts = hogwarts.getInstance();
        initData1();
    }

    /**
     * Method of loading wands and houses
     */
    private void initData1()
    {
        dataWands();
        dataHufflepuff();
        dataGryffindor();
        dataSlytherin();
    }
    /**
     * Method of loading the list of wands
     */
    private void dataWands(){
        //New wands
        //-----------------------
        hogwarts.newWand(new OffensiveHawthorn("Ivy"));
        hogwarts.newWand(new OffensiveHawthorn("Larch"));
        hogwarts.newWand(new HollyDefensive("Rowan"));
        hogwarts.newWand(new OffensiveHawthorn("Yew"));
        hogwarts.newWand(new OffensiveHawthorn("Hazel"));
        hogwarts.newWand(new OffensiveHawthorn("Pine"));
        hogwarts.newWand(new HollyDefensive("Tamarack"));
        hogwarts.newWand(new OffensiveHawthorn("Spruce"));
        hogwarts.newWand(new OffensiveHawthorn("Pear"));
        hogwarts.newWand(new OffensiveHawthorn("Laurel"));
    }

    /**
     * Method of loading the house Gryffindor and its characters
     */
    private void dataGryffindor(){
        //Griffindor's characters
        //-----------------------------
        House gryffindor = new House("Gryffindor");
        hogwarts.setHouse(gryffindor.getH_name(),gryffindor );
        hogwarts.getHousesName().add(gryffindor.getH_name());

        //**Harry Potter**//
        Character Harry = new OffensiveCharacter("Harry Potter",new OffensiveHawthorn("HarryW"),"Gryffindor"); 
        //->assign  InvigorationPotion to harry
        Harry= new InvigorationPotion(Harry,"InvigorationPotion");
        //->assign  FelixFelicisPotion to harry 
        Harry= new FelixFelicisPotion(Harry,"FelixFelicisPotion");
        hogwarts.getHouse(gryffindor.getH_name()).insertChar(Harry);        

        //**Hermione Granger**//
        Character Hermione = new DefensiveCharacter("Hermione Granger",new HollyDefensive("HermioneW"),"Gryffindor");  
        // ->assign  InvigorationPotion to hermione 
        Hermione=new InvigorationPotion(Hermione,"InvigorationPotion");
        hogwarts.getHouse(gryffindor.getH_name()).insertChar(Hermione);

        //**Ron Weasley**//
        Character Ron = new DefensiveCharacter("Ron Weasley",new HollyDefensive("RonW"),"Gryffindor");
        // ->assign  FelixFelicisPotion to ron 
        Ron = new FelixFelicisPotion(Ron ,"FelixFelicisPotion");
        hogwarts.getHouse(gryffindor.getH_name()).insertChar(Ron);

        //Neville Longbottom//
        Character Neville = new DefensiveCharacter("Neville Longbottom",new OffensiveHawthorn("NevilleW"),"Gryffindor");
        hogwarts.getHouse(gryffindor.getH_name()).insertChar(Neville);

        //System.out.println("MEMBERS BEFORE");
        //hogwarts.getHouse(gryffindor.getH_name()).showHouse();

        Collections.sort(
            hogwarts.getHouse(gryffindor.getH_name()).getArrayChar(),
            new Order_Def_asc());

        //System.out.println("MEMBERS AFTER");
        //hogwarts.getHouse(gryffindor.getH_name()).showHouse();

    }

    /**
     * Method of loading the house Hufflepuff and its characters
     */
    private void dataHufflepuff(){
        //Hufflepuff's characters
        //------------------------------
        House hufflepuff = new House("Hufflepuff");
        hogwarts.setHouse(hufflepuff.getH_name(),hufflepuff );
        hogwarts.getHousesName().add(hufflepuff.getH_name());

        //**Cedric Diggory**//
        Character Cedric = new DefensiveCharacter("Cedric Diggory",new OffensiveHawthorn("CedricW"),"Hufflepuff"); 
        //->assign  InvigorationPotionPotion to cedric
        Cedric=new InvigorationPotion(Cedric,"InvigorationPotion");
        hogwarts.getHouse(hufflepuff.getH_name()).insertChar(Cedric);

        //**Nymphadora Tonks**//
        Character Nymphadora = new DefensiveCharacter("Nymphadora Tonks",new OffensiveHawthorn("NymphadoraW"),"Hufflepuff");
        hogwarts.getHouse(hufflepuff.getH_name()).insertChar(Nymphadora);

        //**Pomona Sprout**//
        Character Pomona = new OffensiveCharacter("Pomona Sprout",new OffensiveHawthorn("PomonaW"),"Hufflepuff");
        //->assign  FelixFelicisPotion to Pomona 
        Pomona= new FelixFelicisPotion(Pomona,"FelixFelicisPotion");
        hogwarts.getHouse(hufflepuff.getH_name()).insertChar(Pomona);

        //**Rolf Scamander**//
        Character Rolf = new DefensiveCharacter("Rolf Scamander",new OffensiveHawthorn("RolfW"),"Hufflepuff");
        hogwarts.getHouse(hufflepuff.getH_name()).insertChar(Rolf);

        //System.out.println("MEMBERS BEFORE");
        //hogwarts.getHouse(hufflepuff.getH_name()).showHouse();

        Collections.sort(
            hogwarts.getHouse(hufflepuff.getH_name()).getArrayChar(),
            new Order_Offen_asc());

        //System.out.println("MEMBERS AFTER");
        //hogwarts.getHouse(hufflepuff.getH_name()).showHouse();

    }

    /**
     * Method of loading the house Slytherin and its characters
     */
    private void dataSlytherin(){
        //Slytherin's characters
        //----------------------
        House slytherin= new House("Slytherin");
        hogwarts.setHouse(slytherin.getH_name(),slytherin );
        hogwarts.getHousesName().add(slytherin.getH_name());

        //**Draco Malfoy**//
        Character Draco = new DefensiveCharacter("Draco Malfoy",new HollyDefensive("DracoW"),"Slytherin");
        hogwarts.getHouse(slytherin.getH_name()).insertChar(Draco);

        //**Dolores Umbridge**//
        Character Dolores = new OffensiveCharacter("Dolores Umbridge",new OffensiveHawthorn("DoloresW"),"Slytherin");
        hogwarts.getHouse(slytherin.getH_name()).insertChar(Dolores);

        //**Pansy Parkinson**//
        Character Pansy = new OffensiveCharacter("Pansy Parkinson",new OffensiveHawthorn("PansyW"),"Slytherin");
        //->assign  FelixFelicisPotion to pansy
        Pansy=new FelixFelicisPotion(Pansy ,"FelixFelicisPotion");
        hogwarts.getHouse(slytherin.getH_name()).insertChar(Pansy);

        //**Albus Severus Potter**//
        Character Albus = new OffensiveCharacter("Albus Severus Potter",new HollyDefensive("AlbusW"),"Slytherin");
        hogwarts.getHouse(slytherin.getH_name()).insertChar(Albus);

        //System.out.println("MEMBERS BEFORE");
        //hogwarts.getHouse(slytherin.getH_name()).showHouse();

        Collections.sort(
            hogwarts.getHouse(slytherin.getH_name()).getArrayChar(),
            new Order_Offen_desc());
               
        //System.out.println("MEMBERS AFTER");
        //hogwarts.getHouse(slytherin.getH_name()).showHouse();
    }
}