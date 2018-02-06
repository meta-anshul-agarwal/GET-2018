package session2;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * this class represents the participants with their answers
 * @author Anshul Agarwal
 *
 */
public class Participant {
	HashMap<Question, String> answerList = new LinkedHashMap<>();
	
	/**
	 * method that adds question and answer to the hashmap
	 * @param question - object of question type having the question
	 * @param answer - answer of the participant for corresponding questions
	 */
	public void setParticipantAnswer (Question question, String answer) {
		this.answerList.put (question, answer);
	}

	/**
	 * method to gt answer list
	 * @return answerList - list of answers with respect to question
	 */
	public HashMap<Question, String> getAnswerList () {
		return this.answerList;
	}
}
