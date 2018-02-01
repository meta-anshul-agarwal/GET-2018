package session1;

/**
 * 
 * @author Anshul Agarwal
 * Image is a HTML tag, in this we denote Image as "img"
 * Image is type of Atomic Element
 * 
 */
public class Img extends AtomicElement {
	
	// Attribute of Image tag
	String src;
	
	// Constructor to initialize the values
	Img(String id, String src, String className){
		
		// calling parent class for initialization
		super(id , className);
		
		// initializing the value
		this.src = src;
		
	}
}
