package PF.Session1.Assignment1;

/**
 * 
 * @author Anshul agarwal
 * This class is used for binary to octal conversion. 
 * Assuming no floating number.
 *	number n can,t be start with 0.
 */
public class BinaryToOctal {
	
	/**
	 * @param input is a binary number.
	 * @returns octal number which is stored in resultNumber.
	 * 
	 * This method is generating decimal number in 3 digit slots which is also a octal number.
	 * 
	 * Example - input -> 100100, take last 3 i.e. 100,
	 * 	convert 100 into decimal which is 4 and one variable counterOctalDigit counting octal digit,
	 * 	now next 3 digit i.e. 100 which in decimal is 4 but counterOctalDigit is 1 now so take
	 * 	power of (10,counterOctalDigit) which gives tens place, now add them 40+4=44(octal number).
	 *   
	 */
	public int octalConversion(int input){
		
        double remainder=0.0;
        double counterThreeDigit=0;
        double sum=0.0;
        double resultNumber=0.0;
        double counterOctalDigit=0;
        
        while( input != 0){
            remainder = input % 10;
            input = input / 10;
            sum =  sum + ( remainder * Math.pow(2.0,counterThreeDigit));
            counterThreeDigit++;
            if(counterThreeDigit == 3){
            	counterThreeDigit=0;
            	resultNumber = resultNumber + sum * Math.pow(10.0,counterOctalDigit);
                sum=0;
                counterOctalDigit++;
            }
        }
        
        if(counterThreeDigit > 0){
        	resultNumber = resultNumber + sum * Math.pow(10.0,counterOctalDigit);
        }
        
        return (int)resultNumber;
	}
}
