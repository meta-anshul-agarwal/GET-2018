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
		
		int counterA=0;		// initial counter of array a
		int counterB=0;		// initial counter of array b
		int counterC=0;		// initial counter of array c
		
		// merging arrays to c, putting smaller value. 
		while(counterA < asize && counterB < bsize){
			if(a[counterA] <= b[counterB]){
				c[counterC++] = a[counterA];
				counterA++;
			}	
			else{
				c[counterC++] = b[counterB];
				counterB++;
			}
			
		}
		while(counterA < asize){              // add remaining elements of array a if there exists
			c[counterC++] = a[counterA];
			counterA++;
		}
		while(counterB < bsize){	      // add remaining elements of array b if there exists
			c[counterC++] = b[counterB];
			counterB++;
		}
		return c;
	}
}
