package session1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Anshul Agarwal
 * This class is responsible for initializing atomic element i.e. the elements which doesn't have any more tags inside it. 
 *
 */
abstract class AtomicElement extends Element{
	
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
		this.hasInstance = false;
	}
	
	Element findById(String id){
		if(this.id == id){
			return this;
		}
		return null;
	}
	
	List<Element> findByClass(String className){
		List<Element> list = new ArrayList<Element>();
		if(this.className == className){
			list.add(this);
		}
		return list;
	}
	
	/**
	 * Recursive function to find the hierarchy of elements
	 * @param element - the composite element
	 * @param count - counts the hierarchy, upto what level the element is
	 * @return - the list
	 */
	public List<String> displayDomRecursive(String spaces){
		
		// loop for adding string into hierarchy
		List<String> hierarchy = new ArrayList<String>();
		hierarchy.add(spaces+"<" + this.getClass().getSimpleName() + " id='"+this.getId()+"'>");
		
		// returns list
		return hierarchy;
	}

}
