package session2;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * This class is responsible to calculate the percent of how many times 
 * a particular option is selected by the participants
 * @author Anshul Agarwal
 */
public class Calculation {
	
	/**
	 * This function takes the question as input and calculates the percentage 
	 * of it's options and saves it 
	 * @param question - object of particular question
	 * @param totalParticipant - number of participant
	 */
	public void calculate(Question question, int totalParticipant) {
		HashMap<String, Integer> result = question.getResultObject().getResult();		//To contain the options of the question
		/*calculating relative percentage for every options of question as per the participant answers*/
		for(Entry<String, Integer> m: result.entrySet()){
			question.getResultObject().setResult ( m.getKey().toString(), Integer.toString(( ((int) m.getValue () * 100 ) / totalParticipant )) + "%");
		}
	}
}
