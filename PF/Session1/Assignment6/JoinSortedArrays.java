package PF.Session1.Assignment6;
/**
 * 
 * @author Anshul Agarwal
 * Assuming increasing order input sorted arrays
 */
public class JoinSortedArrays {
	
	/**
	 * 
	 * @param a is 1st array
	 * @param asize is array length of array a
	 * @param b is 2nd array
	 * @param bsize is array length of array b
	 * @param c is resultant array
	 * @return c which is resultant array
	 */
	public int[] join(int a[], int asize, int b[], int bsize, int c[]){
		
		int counterA=0;
		int counterB=0;
		int counterC=0;
		
		while(counterA < asize && counterB < bsize){
			if(a[counterA] < b[counterB]){
				c[counterC++] = a[counterA];
				counterA++;
			}	
			else if(a[counterA] > b[counterB]){
				c[counterC++] = b[counterB];
				counterB++;
			}
			else{
				c[counterC++] = a[counterA]; 
				c[counterC++] = b[counterB];
				counterA++;
				counterB++;
			}
		}
		while(counterA < asize){
			c[counterC++] = a[counterA];
			counterA++;
		}
		while(counterB < bsize){
			c[counterC++] = b[counterB];
			counterB++;
		}
		return c;
	}
}
