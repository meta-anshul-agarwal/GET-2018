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
	
	Element findById(Element ele , String id){
		if(ele.id == id){
			return ele;
		}
		return null;
	}
	
	List<Element> findByClass(Element ele , String className){
		List<Element> list = new ArrayList<Element>();
		if(ele.className == className){
			list.add(ele);
		}
		return list;
	}
	
	/**
	 * Recursive function to find the hierarchy of elements
	 * @param element - the composite element
	 * @param count - counts the hierarchy, upto what level the element is
	 * @return - the list
	 */
	public List<String> displayDomRecursive(Element tag, String spaces){
		
		// loop for adding string into hierarchy
		List<String> hierarchy = new ArrayList<String>();
		hierarchy.add(spaces+"<" + tag.getClass().getSimpleName() + " id='"+tag.getId()+"'>");
		
		// returns list
		return hierarchy;
	}

}
