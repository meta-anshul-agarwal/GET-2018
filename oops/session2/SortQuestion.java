package session2;

import java.util.ArrayList;
import java.util.List;

/**
 * this class sorts the questions in the question list using selection sort algorithm
 * @author Anshul Agarwal
 *
 */
public class SortQuestion {
		
	/**
	 * method sorts the question list
	 * @param questionList- list of question objects
	 * @return list - sorted list
	 */
	public List<Question> sortQuestion(List<Question> questionList){
		List<Question> list = new ArrayList<>();
			
		/*Sort the question using selection sort concept*/
		for(int i = 0; i < questionList.size() - 1; i++){
			String temp = questionList.get(i).getQuestion();		//stores the question string
			Question tempQuestion = questionList.get(i);			//stores the object of question
				
			/*finds the smallest element*/
			for(int j = i+1; j < questionList.size(); j++){
				
				if( questionList.get(j).getQuestion(). compareTo(temp) < 0){
					temp = questionList.get(j).getQuestion();
					tempQuestion = questionList.get(j);
				}
			}
			list.add(tempQuestion);				//add smallest element in the list
			questionList.remove(tempQuestion);
		}
		list.addAll(questionList);				//add remaining element to the list
		return list;
	}
}

