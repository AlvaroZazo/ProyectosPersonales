import java.io.FileWriter;
import java.io.IOException;

/**
 * Class that loads the game
 * 
 * @author (CAP) 
 * @version (1.3.7)
 */
public class Main
{
    public static void main(String[] args){
        
    	try {
			FileWriter writer = new FileWriter ("output.log");
			Game myGame=new Game(writer);
	        myGame.start(writer);
	        writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        
    }
}
