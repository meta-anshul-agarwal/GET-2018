package session1;

/**
 * 
 * @author Anshul Agarwal
 * This class is responsible for initializing atomic element i.e. the elements which doesn't have any more tags inside it. 
 *
 */
public class AtomicElement extends Element{
	
	/**
	 * 
	 * @param id
	 * @param className
	 * 
	 * constructor to initialization of values
	 */
	public AtomicElement(String id, String className) {
	
		// calling parent class for initialization
		super(id,className);
	}
	

}
