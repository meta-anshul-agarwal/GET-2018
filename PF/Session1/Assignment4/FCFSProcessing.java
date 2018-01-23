package PF.Session1.Assignment4;
/**
 * 
 * @author Anshul Agarwal
 * Assuming arrival time to be sorted in increasing order
 */

public class FCFSProcessing {
	
		/**
		 * 
		 * @param arrival_time is an array
		 * @param job_size is an array
		 * @return variable result which is a 2d array includes 4 attributes(arrival time, waiting time, starting time, finishing time)
		 */
		int[][] FCFS( int arrival_time [], int job_size[] ){
			
			int[][] result = new int[job_size.length][job_size.length];
			int job_start = arrival_time[0];
			int job_finish = 0;
			int job_wait = 0;
			
			for(int rowCounter=0;rowCounter<job_size.length;rowCounter++){
				result[rowCounter][0] = arrival_time[rowCounter];
				job_wait = job_finish - arrival_time[rowCounter] + 1;
				
				if(job_wait < 0){ 	// checks if next arrival time is greater than last finish time, if true then waiting time will be 0.  
					job_wait = 0;
				}
				
				result[rowCounter][1] = job_wait;
				result[rowCounter][2] = job_start;
				result[rowCounter][3] = job_finish + job_size[rowCounter];
				
				if(job_finish < arrival_time[rowCounter]){
					result[rowCounter][2] = arrival_time[rowCounter];
					result[rowCounter][3] = arrival_time[rowCounter] 
											+ job_size[rowCounter]-1;
				}
				
				job_finish = result[rowCounter][3];
				job_start = job_finish + 1;	
			}
			return result;
		}
}
