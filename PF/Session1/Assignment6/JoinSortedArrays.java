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
		
		for(counterC=0 ; counterC < asize+bsize ; counterC++){
			if(a[counterA] < b[counterB]){	
				
				c[counterC] = a[counterA];
				a[counterA] = Integer.MAX_VALUE;
				
				if(counterA != asize-1){
					counterA++;
				}
			}
			else if(a[counterA] > b[counterB]){
				c[counterC] = b[counterB];
				b[counterB] = Integer.MAX_VALUE;
				
				if(counterB != bsize-1){
					counterB++;
				}
			}
			else{
				c[counterC] = b[counterB];
				a[counterA] = Integer.MAX_VALUE;
				b[counterB] = Integer.MAX_VALUE;
				
				if(counterA != asize-1){
					counterA++;
				}
				
				if(counterB != bsize-1){
					counterB++;
				}
				
			}
		}
		return c;
	}
}
