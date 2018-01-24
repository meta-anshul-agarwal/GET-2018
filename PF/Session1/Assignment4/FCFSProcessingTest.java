package PF.Session1.Assignment4;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class FCFSProcessingTest {
	
	FCFSProcessing fcfs = new FCFSProcessing();

	@Test
	public void fcfsTest() {
		
		int[] arrival_time = new int[]{1,5,9,25};
		int[] job_size = new int[]{12,7,2,5};
		int actual[][] = fcfs.FCFS(arrival_time, job_size);
		int expected[][] = new int[][] {{1,0,1,12},{5,8,13,19},{9,11,20,21}
											,{25,0,25,29}};
		assertTrue(isArrayEqual(actual,expected));
	}
	
	boolean isArrayEqual(int[][] actual,int[][] expected){
		
		int rowCounter = 0;
		boolean result = true;
		
		for(rowCounter = 0 ; rowCounter < actual.length ; rowCounter++){
			result = Arrays.equals(actual[rowCounter]  
					, expected[rowCounter]);
			if(result == false){
				break;
			}
		}
		return result;
	}

}
