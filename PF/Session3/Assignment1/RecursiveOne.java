package PF.Session3.Assignment1;
/**
 * 
 * @author Anshul Agarwal
 * This class consists of 4 methods i.e. 
 * 1. To find remainder
 * 2. To find gcd
 * 3. to find largest digit
 * 4. to find maximum number among 2
 */
public class RecursiveOne {
	
	/**
	 * 
	 * @param x > 0
	 * @param y >= 0
	 * @return remainder when x divided by y
	 */
	public int rem(int x,int y){
		// checking x and y range, if false throw exception. 
		if(y <= 0 || x < 0){
			throw new IllegalArgumentException();
		}
		// checks x is greater than y or not, if yes then go into recursive, if not return x
		if(x >= y){
			return rem(x-y,y); // calling function itself with less value of x 
		}
		return x;
		
	}
	/**
	 * 
	 * @param x > 0
	 * @param y > 0
	 * @return gcd of x and y
	 */
	public int gcd(int x,int y){
		// checking range of x,if not throw exception
		if(x <= 0){
			throw new IllegalArgumentException();
		}
		// base condition
		if(x==1 || y==0){
			return x;
		}
		// applying euclid's method to find gcd by calling function itself with param y , x%y
		else{
			return gcd(y,x%y);
		}	
	}
	
	/**
	 * 
	 * @param x
	 * @return largest digit in x
	 */
	public int largestDigit(int x){
		// checking range of x,if not throw exception
		if(x < 0){
			throw new IllegalArgumentException();
		}
		
		// base condition
		if(x == 0){
			return x;
		}
		int max = x%10; // assuming max number
		return maximum(max , largestDigit(x/10)); // checks maximum of two and call recursive function
		
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @return maximum of x and y
	 */
	int maximum(int x , int y){
		if(x > y){
			return x;
		}
		else{
			return y;
		}
	}
}
