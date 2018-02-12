package session2;

import java.util.ArrayList;
import java.util.List;

/**
 * class representing the type of the question 
 * @author Anshul Agarwal
 *
 */
public class Type {
	private List<String> optionList = new ArrayList<>();
	
	/**
	 * Constructor
	 * @param options - list of options
	 */
	public Type (List<String> options){
		this.optionList = options;
	}

	/**
	 * method to get option list
	 * @return optionList - option list
	 */
	public List<String> getOptions() {
		return this.optionList;
	}
}
