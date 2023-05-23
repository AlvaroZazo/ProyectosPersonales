
/**
 * This class is created to sort the characters by their energy from
 * least to greatest
 * 
 * @author (CAP) 
 * @version (1.3.5)
 */
import java.util.*;
public class Order_Energy_asc implements Comparator<Character>
{
    /**
     * Method that compares two characters according to their energy for
     * their ascending ordering. If the values are the same, they are ordered
     * in alphabetical order
     *
     * 
     * @param C1 First character to be compared
     * @param C2 Second character to be compared
     * @return a negative integer, zero, or a positive integer as the first
     * Character is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Character C1, Character C2) {
        if(C1.getEnergy()==C2.getEnergy()){
            return C1.getName().compareTo(C2.getName());
        }else{
            if(C1.getEnergy()>C2.getEnergy()){
                return 1;
            }else{
                return -1;
            } 
        }
    }

}
