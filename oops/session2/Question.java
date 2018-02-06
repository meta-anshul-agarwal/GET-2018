package session2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * this class represents the questions that have been fetched from input file
 * @author Anshul Agarwal
 *
 */
public class Question {
	private String question;
	private String type;
	private Type questionType;
	private Result result;
	private String questionOptions;
	
	/**
	 * method to tokenize the question line
	 * @param line - string having complete question line
	 */
	public void tokenize(String line){
		Scanner input = new Scanner(line).useDelimiter(",");
		input.next();
		this.type = input.next();
		this.question = input.next();
		this.questionOptions = null;
			
		if ( input.hasNext() ) {
			this.questionOptions = input.next();
		}

		if ( this.type. equalsIgnoreCase ("single") ) {
			List<String> list = getOptionList(questionOptions);		//creating temporary list for options
			Single options = new Single (list);						//creating single type object
			this.questionType = options;
			this.result = new Result();
			this.result.initialize(list);
			
		} else if(this.type. equalsIgnoreCase ("multi") ) {
			List<String> list = getOptionList(questionOptions);		//creating temporary list for options
			Multi options = new Multi (list);						//creating multiple type object
			this.questionType = options;
		}
	}
	
	/**
	 * method to get the list of options
	 * it separate the options from /
	 * @param questionOptions - string having all options untokenized
	 * @return list - option list
	 */
	private List<String> getOptionList(String questionOptions){
		Scanner scannerOption = new Scanner(questionOptions).useDelimiter("/");
		List<String> list = new ArrayList<>();
		
		/* tokenize option list*/
		while (scannerOption.hasNext()) {
			list.add(scannerOption.next());
		}
		return list;
	}

	/**
	 *method to get the result list 
	 * @return result - result of particular question
	 */
	public Result getResultObject() {
		return this.result;
	}
	
	/**
	 * method to get the type of the question
	 * @return type - type of question
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * returns the object of type class
	 * @return questionType - object of question type
	 */
	public Type getQuestionType() {
		return this.questionType;
	}

	/**
	 * method to get the question string
	 * @return question - question string
	 */
	public String getQuestion() {
		return this.question;
	}

	/**
	 * method to get options of question
	 * @return questionOptions - string of question options untokenized
	 */
	public String getQuestionOptions() {
		return this.questionOptions;
	}
}