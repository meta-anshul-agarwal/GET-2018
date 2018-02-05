package session1;

import java.util.List;

/**
 * 
 * @author Anshul Agarwal
 * Abstract class which contains methods to find details of tag
 */
abstract class Element {
	
	// id of tag
	String id;


	// class of tag
	String className;
	
	// Constructor for initializing values
	public Element(String id, String className) {
		
		// initializing id
		this.id = id;
		
		// initializing class name
		this.className = className;
		
	}
	
	// returns id of a particular tag
	public String getId() {
		
		return id;
	}
	
	// returns class name of a particular tag
	public String getClassName() {
		
		return className;
	}

	Element findById( String id){
		return null;
	}
	
	List<Element> findByClass(String className){
		return null;
	}
	/**
	 * Recursive function to find the hierarchy of elements
	 * @param element - the composite element
	 * @param count - counts the hierarchy, upto what level the element is
	 * @return - the list
	 */
	public List<String> displayDomRecursive(String spaces){
		return null;
	}
		
}
