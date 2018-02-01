package session1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Anshul Agarwal
 * 
 */
public class Dom {
	CompositeElement element;
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
		return findElementById(this.element, id);
	}
	
	/**
	 * 
	 * @param tag
	 * @param id
	 * @return element
	 * 
	 * 
	 */
	Element findElementById(Element tag , String id){
		
		// loop to check id of element in list of composite element
		for(Element tagInList: ((CompositeElement) tag).tagList()) {
			
			// checks tag id
			if ( id == tagInList.getId()) {
				
				// return tag
				return tagInList;
			}
		
			// check if tagInList is a composite element or not
			if(tagInList.isHasInstance()) {
				// recursive call for checking list of tagInList element
				Element return_tag = findElementById(tagInList, id);
				
				// checks if return_tag is null or not
				if (return_tag != null){
					
					// returns tag
					return return_tag;
				}
			}
		}
		// if element not found returns null
		return  null;
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
		return addElementByClass(this.element, className);
	}
	
	/**
	 * 
	 * @param tag
	 * @param className
	 * @return list containing tag
	 * 
	 * This is a recursive method to find element by Id
	 * 
	 */
	List<Element> addElementByClass(Element tag, String className) {
		
		// list containing tags
		List<Element> list = new ArrayList<Element>();
		
		// loop to check class name of element in list of composite element
		for(Element tagInList: ((CompositeElement) tag).tagList()) {
			// checks tag's class name
			if ( className == tagInList.getClassName()) {
				
				// add the tag into list
				list.add(tagInList);
				
			}  
			
			//checks instance
			if(tagInList.isHasInstance()) {
				
				// calling recursive function to check list if composite element
				list.addAll( addElementByClass(tagInList, className) );
			}
			
		}
		// returns list
		return  list;
	}
	
	/**
	 * To get the list of elements of the DOM in hierarchical form
	 * @return the list of the hierarchy of elements
	 */
	public List<String> displayDOM(){

		return displayDomRecursive(this.element, 0);
	
	}
	/**
	 * Recursive function to find the hierarchy of elements
	 * @param element - the composite element
	 * @param count - counts the hierarchy, upto what level the element is
	 * @return - the list
	 */
	private List<String> displayDomRecursive(Element tag, int count){
		
		// loop for adding string into hierarchy
		List<String> hierarchy = new ArrayList<String>();
		
		// loop for adding string of composite elements into hierarchy
		for (Element ele : ((CompositeElement) tag).tagList()) {
			
			// checks instance of composite element
			if(ele.isHasInstance()){
				hierarchy.add(spaces(count)+"<" + ele.getClass().getSimpleName() + " id='"+ele.getId()+"'>");
				hierarchy.addAll( displayDomRecursive(ele, count + 1) );
				hierarchy.add(spaces(count)+"</" + ele.getClass().getSimpleName() + ">");
			} else {
				hierarchy.add(spaces(count)+"<" + ele.getClass().getSimpleName() + " id='"+ele.getId()+"'>");
			}
		}
		
		// returns list
		return hierarchy;
	}
	/**
	 * Counts the spaces to be printed to maintain hierarchy
	 * @param count- counts spaces
	 * @return spaces
	 */
	protected String spaces(int count){
		
		String space="";
		// loop for adding spaces
		while(count != 0){
			space += "    ";
			count--;
		}
		
		// return spaces
		return space;
	}
}
