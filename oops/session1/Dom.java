package session1;

import java.util.List;

/**
 * 
 * @author Anshul Agarwal
 * 
 */
public class Dom {
	Element element;
	Dom(Element root){
		element = (CompositeElement) root;
	}
	/**
	 * 
	 * @param id
	 * @returns Element
	 * 
	 * Searches element by ID
	 */
	Element findElementByID (String id) {
		// returns element 
		return this.element.findById(id);
	}
	
	/**
	 * 
	 * @param className
	 * @returns Element's List
	 * 
	 * Searches element by class name
	 */
	public List<Element> findElementByClass(String className) {
		// return list of elements with same class
		return this.element.findByClass(className);
	}
		
	/**
	 * To get the list of elements of the DOM in hierarchical form
	 * @return the list of the hierarchy of elements
	 */
	public List<String> displayDOM(){
		return this.element.displayDomRecursive("");
	
	}
}
