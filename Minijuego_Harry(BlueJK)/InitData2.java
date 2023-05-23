/**
 * Class to init data of the simulation. 
 * 
 * 
 * @author CAP 
 * @version 1.3.5
 */
import java.util.*;
public class InitData2
{
    private Hogwarts hogwarts; //hogwarts must be a unique instance

    /**
     * Constructor for objects of class InitData
     */
    public InitData2()
    {
        hogwarts = hogwarts.getInstance();
        initData2();
    }

    /**
     * Method of loading wands and houses
     */
    private void initData2()
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
        hogwarts.newWand(new HollyDefensive("Cypress"));
        hogwarts.newWand(new HollyDefensive("Ebony"));
        hogwarts.newWand(new OffensiveHawthorn("Reed"));
        hogwarts.newWand(new HollyDefensive("Aspen"));
        hogwarts.newWand(new OffensiveHawthorn("Walnut"));
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
        Character Harry = new OffensiveCharacter("Harry Potter",new HollyDefensive("HarryW"),"Gryffindor"); 
        //->assign  InvigorationPotion to harry
        Harry= new InvigorationPotion(Harry,"InvigorationPotion");
        //->assign  FelixFelicisPotion to harry 
        Harry= new FelixFelicisPotion(Harry,"FelixFelicisPotion");
        hogwarts.getHouse(gryffindor.getH_name()).insertChar(Harry);

        //**Hermione Granger**//
        // Character hermione = new DefensiveCharacter("Hermione Granger"  … );
        Character Hermione = new OffensiveCharacter("Hermione Granger",new HollyDefensive("HermioneW"),"Gryffindor");  
        //->assign  FelixFelicisPotion to hermione 
        Hermione=new FelixFelicisPotion(Hermione,"InvigorationPotion");
        // ->assign  InvigorationPotion to hermione 
        Hermione=new InvigorationPotion(Hermione,"InvigorationPotion");
        hogwarts.getHouse(gryffindor.getH_name()).insertChar(Hermione);

        //**Ron Weasley**//
        //Character ron = new DefensiveCharacter("Ron Weasley" … );
        Character Ron = new OffensiveCharacter("Ron Weasley",new HollyDefensive("RonW"),"Gryffindor");
        // ->assign  FelixFelicisPotion to ron 
        Ron = new FelixFelicisPotion(Ron ,"FelixFelicisPotion");
        hogwarts.getHouse(gryffindor.getH_name()).insertChar(Ron);

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
        //House hufflepuff = new House("Hufflepuff" … );
        House hufflepuff = new House("Hufflepuff");
        hogwarts.setHouse(hufflepuff.getH_name(),hufflepuff );
        hogwarts.getHousesName().add(hufflepuff.getH_name());

        //**Cedric Diggory**//
        //Character cedric = new DefensiveCharacter("Cedric Diggory"  … );
        Character Cedric = new DefensiveCharacter("Cedric Diggory",new OffensiveHawthorn("CedricW"),"Hufflepuff"); 
        //->assign  InvigorationPotionPotion to cedric
        Cedric=new InvigorationPotion(Cedric,"InvigorationPotion");
        hogwarts.getHouse(hufflepuff.getH_name()).insertChar(Cedric);

        //**Nymphadora Tonks**//
        //Character nymphadora = new DefensiveCharacter("Nymphadora Tonks" … );
        Character Nymphadora = new DefensiveCharacter("Nymphadora Tonks",new OffensiveHawthorn("NymphadoraW"),"Hufflepuff");
        hogwarts.getHouse(hufflepuff.getH_name()).insertChar(Nymphadora);

        //**Pomona Sprout**//
        //Character pomona = new OffensiveCharacter("Pomona Sprout" … );
        Character Pomona = new DefensiveCharacter("Pomona Sprout",new OffensiveHawthorn("PomonaW"),"Hufflepuff");
        //->assign  FelixFelicisPotion to Pomona 
        Pomona= new FelixFelicisPotion(Pomona,"FelixFelicisPotion");
        hogwarts.getHouse(hufflepuff.getH_name()).insertChar(Pomona);

        //**Rolf Scamander**//
        //Character rolf = new DefensiveCharacter("Rolf Scamander" … );
        Character Rolf = new DefensiveCharacter("Rolf Scamander",new OffensiveHawthorn("RolfW"),"Hufflepuff");
        hogwarts.getHouse(hufflepuff.getH_name()).insertChar(Rolf);

        //**Silvanus Kettleburn**//
        Character Silvanus = new DefensiveCharacter("Silvanus Kettleburn",new OffensiveHawthorn("SilvanusW"),"Hufflepuff");
        Silvanus = new FelixFelicisPotion(Silvanus ,"FelixFelicisPotion");
        hogwarts.getHouse(hufflepuff.getH_name()).insertChar(Silvanus);

        //**Susan Bones**//
        Character Susan = new DefensiveCharacter("Susan Bones",new OffensiveHawthorn("SusanW"),"Hufflepuff");
        hogwarts.getHouse(hufflepuff.getH_name()).insertChar(Susan);

        //**Newton Scamander**//
        Character Newton = new DefensiveCharacter("Newton Scamander",new OffensiveHawthorn("NewtonW"),"Hufflepuff");
        hogwarts.getHouse(hufflepuff.getH_name()).insertChar(Newton);

        //**Hannah Abbott**//
        Character Hannah = new DefensiveCharacter("Hannah Abbott",new OffensiveHawthorn("HannahW"),"Hufflepuff");
        // ->assign  FelixFelicisPotion to hannah
        Hannah = new FelixFelicisPotion(Hannah ,"FelixFelicisPotion");
        hogwarts.getHouse(hufflepuff.getH_name()).insertChar(Hannah);

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
        //House slytherin = new House("Slytherin" … );
        House slytherin= new House("Slytherin");
        hogwarts.setHouse(slytherin.getH_name(),slytherin );
        hogwarts.getHousesName().add(slytherin.getH_name());

        //**Draco Malfoy**//
        //Character draco = new DefensiveCharacter("Draco Malfoy" … );
        Character Draco = new DefensiveCharacter("Draco Malfoy",new HollyDefensive("DracoW"),"Slytherin");
        //->assign FelixFelicisPotion to draco
        Draco = new FelixFelicisPotion(Draco ,"FelixFelicisPotion");
        hogwarts.getHouse(slytherin.getH_name()).insertChar(Draco);

        //System.out.println("MEMBERS BEFORE");
        //hogwarts.getHouse(slytherin.getH_name()).showHouse();

        Collections.sort(
            hogwarts.getHouse(slytherin.getH_name()).getArrayChar(),
            new Order_Offen_desc());

        //System.out.println("MEMBERS AFTER");
        //hogwarts.getHouse(slytherin.getH_name()).showHouse();
    }
}