package session1;

/**
 * 
 * @author Anshul Agarwal
 * Anchor is a HTML tag, in this we denote Anchor as "A"
 * Anchor is type of Atomic Element
 */
public class A extends AtomicElement {
	
	// Attribute of Anchor tag
	String href;
	
	/**
	 *  Constructor to initialize the values
	 * @param id 
	 * @param href
	 * @param className
	 */
	A(String id, String href, String className){
		
		// calling parent class for initialization
		super(id,className);
		
		// initializing the value
		this.href= href;
	
	}
}
