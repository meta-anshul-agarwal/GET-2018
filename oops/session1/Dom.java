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
	
	// List containing tags in DOM
	List<Element> element = new ArrayList<Element>();

	// for adding element in DOM
	void add(Element a){
		
		// adding element
		element.add(a);
	}
	
	/**
	 * 
	 * @param id
	 * @returns Element
	 * 
	 * Searches element by ID
	 */
	Element findElementByID (String id) {
		
		// loop for elements in DOM
		for( Element tag : element) {
			
			// calling function for checking id
			Element return_tag = returnElementById(tag , id);
			
			// checking return_tag if null or not
			if(return_tag != null){
				
				// returns return_tag
				return return_tag;
			}
				
		}
		// if element not found returns null
		return null;
	}
	
	/**
	 * 
	 * @param tag
	 * @param id
	 * @return element
	 * 
	 * 
	 */
	Element checkIdInComposite(Element tag, String id){
		
		// loop to check id of element in list of composite element
		for(Element tagInList: ((CompositeElement) tag).tagList()) {
			
			// calling function for checking id
			Element return_tag = returnElementById(tagInList , id);
			
			// checking return_tag if null or not
			if(return_tag != null){
				
				// return tag
				return return_tag;
			}
	
		}
		
		// if element not found returns null
		return  null;
	}
	
	private Element returnElementById(Element tag, String id) {
		
		// checks tag id
		if ( id == tag.getId()) {
			
			// return tag
			return tag;
		}
	
		// check if tagInList is a composite element or not
		if(tag.has_instance()) {
			System.out.println(""+tag.getId());
			// recursive call for checking list of tagInList element
			Element return_tag = checkIdInComposite(tag, id);
			
			// checks if return_tag is null or not
			if (return_tag != null){
				
				// returns tag
				return return_tag;
			}
		}
		
		// if element not found then return null
		return null;
	}

	/**
	 * 
	 * @param className
	 * @returns Element's List
	 * 
	 * Searches element by class name
	 */
	public List<Element> findElementByClass(String className) {
		
		// list contains element of same class
		List<Element> list = new ArrayList<Element>();
		
		// loop for checking DOM element class name
		for( Element tag : element) {
			
			// add elements to return list
			list.addAll(AddElementByClass(tag , className));
		}
		
		// returns list
		return list;
	}
	
	/**
	 * 
	 * @param tag
	 * @param className
	 * @return list containing tags
	 */
	private List<Element> AddElementByClass(Element tag,
			String className) {
		
		// List contains tags
		List<Element> list = new ArrayList<Element>();
		
		// checks tag's class name
		if ( className == ((Element) tag).getClassName()) {
			
			// add the tag into list
			list.add(tag);
			
		}  
		
		//checks instance
		if(tag.has_instance()) {
			
			// calling recursive function to check list if composite element
			list.addAll( checkClassInComposite(tag, className) );
		}
		
		// returns list
		return list;
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
	List<Element> checkClassInComposite(Element tag, String className) {
		
		// list containing tags
		List<Element> list = new ArrayList<Element>();
		
		// loop to check class name of element in list of composite element
		for(Element tagInList: ((CompositeElement) tag).tagList()) {
			
			// add returned tags to list
			list.addAll(AddElementByClass(tagInList , className));
			
		}
		// returns list
		return  list;
	}
	
	/**
	 * To get the list of elements of the DOM in hierarchical form
	 * @return the list of the hierarchy of elements
	 */
	public List<String> displayDOM(){
		// list contains String of DOM hierarchy
		List<String> hierarchy = new ArrayList<String>();
		
		// loop for adding string into hierarchy
		for (Element tag : element) {
			
			// checks instance of composite element
			if(tag.has_instance()){
				hierarchy.add("<" + tag.getClass().getSimpleName() + " id='"+tag.getId()+"'>");
				hierarchy.addAll( displayDomRecursive(tag, 1) );
				hierarchy.add("</" + tag.getClass().getSimpleName() + ">");
			} else{
				hierarchy.add("<" + tag.getClass().getSimpleName() +  " id='"+tag.getId()+"'>");
			}
		}
		
		// returns list
		return hierarchy;
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
			if(ele.has_instance()){
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
