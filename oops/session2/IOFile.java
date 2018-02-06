package session2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * This class has two functions ,one is to read the questions from the input file
 * and the second is to write the expected result in the output file.
 * @author Anshul Agarwal
 *
 */
public class IOFile {
	private String fileName ;
	private List<Question> questionList = new ArrayList<>();
	
	/**
	 * constructor
	 * @param path - contains the path of input file
	 */
	public IOFile(String fileName){
		this.fileName = fileName;
	}
	
	/**
	 * this method reads the questions from the input file and adds the question 
	 * object in the question list
	 */
	public void readQuestion() throws IOException{
		try {
			URL url = getClass().getResource(this.fileName);
			File file = new File(url.getPath());
			Scanner scanner = new Scanner(file);
			
			/*fetching and creating object for each line of file*/
			while (scanner.hasNext()) {
				Question questionObject =  new Question();
				questionObject.tokenize ( scanner.nextLine() );
				this.questionList.add (questionObject);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to get the question list
	 * @return questionList - question list is returned
	 */
	public List<Question> getQuestionList() {
		return this.questionList;
	}
	
	/**
	 * this method writes the final result in the output file
	 * @param participantList - list of the participants to fetch answers
	 */
	public void writeAnswer(List<Participant> participantList) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("participant-Result.txt", "UTF-8");
		int count = 1;										//participant count
		
		/*write each participant answers in a file*/
		for(Participant p : participantList){
			writer.print("Participant " + count++);
			
			for(Entry<Question, String> m : p.answerList.entrySet()){
				writer.print(", " + m.getValue());
			}
			writer.println();
		}
		writer.close();
	}
}
