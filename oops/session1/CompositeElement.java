package session1;

import java.util.List;
import java.util.ArrayList;
/**
 * 
 * @author Anshul Agarwal
 * This class is responsible for initializing Composite element i.e. the elements which have more tags inside it. 
 *
 */
public class CompositeElement extends Element{
	
	// List stores tags inside parent tag
	List<Element> element = new ArrayList<Element>();
	
	// constructor to initialization of values
	public CompositeElement(String id, String className) {
		
		// calling parent class for initialization
		super(id,className);
		this.hasInstance = true;
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
	
	Element findById(Element ele , String id){
		if(ele.id == id){
			return ele;
		}
		for(Element e : element){
			Element return_tag = e.findById(e , id);
			if(return_tag!=null){
				return return_tag;
			}
		}
		return null;
	}
	
	List<Element> findByClass( Element ele , String className){
		List<Element> list = new ArrayList<Element>();
		if(ele.className.equals(className)){
			
			list.add(ele); 
		}
		for(Element e : element){
			list.addAll(e.findByClass(e , className));
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
		
		// loop for adding string of composite elements into hierarchy
		for (Element ele : ((CompositeElement) tag).tagList()) { 
				if(ele.hasInstance){
					hierarchy.add(spaces+"<" + ele.getClass().getSimpleName() + " id='"+ele.getId()+"'>");
					hierarchy.addAll( ele.displayDomRecursive(ele, spaces+"    ") );
					hierarchy.add(spaces +"</" + ele.getClass().getSimpleName() + ">");
				}
				else{
					hierarchy.addAll(ele.displayDomRecursive(ele, spaces));
				}
		}
		
		// returns list
		return hierarchy;
	}
}
