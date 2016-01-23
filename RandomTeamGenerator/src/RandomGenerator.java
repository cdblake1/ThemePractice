import java.util.ArrayList;
import java.util.Arrays;

public class RandomGenerator {

	

	public static void main(String[] args) {
		String[] players = { "Strafen", "Proteje", "D2Twinkie", "D2Gambit",
				"GeQuinox", "AgeOfUrfTron" };

		ArrayList<String> teamOne = new ArrayList<String>();
		ArrayList<String> teamTwo = new ArrayList<String>(); 
		
		while(teamOne.size() < 4){
			int i =(int) Math.random()*10;
			String player = players[(int) (Math.random()*10)];
			teamOne.add(player);
			
			
		}
		
	}

}
