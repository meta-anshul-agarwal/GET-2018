package session1;

import java.util.List;
import java.util.ArrayList;
/**
 * 
 * @author Anshul Agarwal
 * This class is responsible for initializing Composite element i.e. the elements which have more tags inside it. 
 *
 */
abstract class CompositeElement extends Element{
	
	// List stores tags inside parent tag
	List<Element> element = new ArrayList<Element>();
	
	// constructor to initialization of values
	public CompositeElement(String id, String className) {
		
		// calling parent class for initialization
		super(id,className,true);
	}
	
	
	
	// method for adding Tag
	void add(Element tag){
		
		// Adding tag or element
		element.add(tag);
	}
	
	// Returns list of tags inside parent tag
	List<Element> tagList(){
		
		// returns list of composite element tag
		return this.element;
	}
	
	
	
	
}
