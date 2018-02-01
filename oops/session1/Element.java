package session1;

/**
 * 
 * @author Anshul Agarwal
 * Abstract class which contains methods to find details of tag
 */
abstract class Element {
	
	// id of tag
	String id;
	
	boolean hasInstance;

	// class of tag
	String className;
	
	// Constructor for initializing values
	public Element(String id, String className ,boolean hasInstance) {
		
		// initializing id
		this.id = id;
		
		// initializing class name
		this.className = className;
		
		this.hasInstance = hasInstance;
	}
	
	public boolean isHasInstance() {
		return hasInstance;
	}

	public void setHasInstance(boolean hasInstance) {
		this.hasInstance = hasInstance;
	}
	
	// returns id of a particular tag
	public String getId() {
		
		return id;
	}
	
	// returns class name of a particular tag
	public String getClassName() {
		
		return className;
	}


		
}
