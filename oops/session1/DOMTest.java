package session1;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class DOMTest {
	static Dom dom;
	static CompositeElement div1;
	static CompositeElement root; 
	static CompositeElement div2;
	static CompositeElement div3;
	static AtomicElement a;
	static AtomicElement img3;
	static AtomicElement img1;
	static AtomicElement img2;
	
	@BeforeClass
	 public static void doBefore() {
		root = new Root("0","root");
		dom = new Dom(root);
		div1 = new Div("1", "abc");
		div2 = new Div("0", "abc");
		a = new A("9", "ab", "asa");
		div3 = new Div("4", "abcd");
		img3 = new Img("6", "ab", "abcd");
		img1 = new Img("3", "ab", "abc"); 
		img2 = new Img("8", "ab", "abcd"); 
		((CompositeElement) root).add(div1);
		div1.add(div2);
		div2.add(a);
		div2.add(div3);
		div3.add(img3);
		((CompositeElement) root).add(img1);
		div1.add(img2);
	}
	@Test
	public void className_test() {
		
		List<Element> actual2 = dom.findElementByClass("abcd");
		List<String> result = new ArrayList<String>();
		for ( Element listElement : actual2) {
 			result.add(listElement.getClass().getSimpleName());
 		}
		List<String> expected = new ArrayList<String>();
		expected.addAll( Arrays.asList("Div","Img","Img"));
		assertEquals(expected,result);
		
	}
	
	@Test
	public void id_test() {
		
		String actual = dom.findElementByID("3").getClass().getSimpleName();
		String expected = "Img" ;
		assertEquals(expected,actual);
		
	}
	
	@Test
	public void dom_test() {
		
		List<String> expected= new ArrayList<String>();
		expected.addAll(Arrays.asList("<Div id='1'>","    <Div id='0'>","        <A id='9'>","        <Div id='4'>",
									  "            <Img id='6'>","        </Div>","    </Div>","    <Img id='8'>",
									  "</Div>","<Img id='3'>" ));
		List<String> actual = dom.displayDOM();
		assertEquals(expected,actual);
		
	}

}
