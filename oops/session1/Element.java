package session1;

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

	// for checking instance of element
	public boolean has_instance() {
		
		// by default value is false
		return false;
	}

		
}
