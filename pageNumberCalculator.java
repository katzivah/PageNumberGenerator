/**
 * @(#)pageNumberCalculator.java
 *
 *
 * @author Kris Caruso
 * @version 1.00 2020/10/13
 */
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class pageNumberCalculator {

    public static void main(String[] args) {
        	Scanner input = new Scanner(System.in);
        	System.out.print("Input a 16-bit logical address: ");
        	String logical_address = input.next();
        	
        	char[] addyHex = new char[logical_address.length() - 2];
        	
        	for(int i = 2; i < logical_address.length(); i++) {
        		addyHex[i-2] = logical_address.charAt(i);
        	}
        	
        	System.out.println(Arrays.toString(addyHex));
        	
        	int[] convert = hexNumberValues(addyHex);
        	
        	int addyToDec = getDecimal(convert)/256;
        	System.out.println("Page number: " + addyToDec);
        	System.out.print("Convert to hex address? (Y/n) ");
        	char ans = input.next().charAt(0);
        	if(ans == 'Y' || ans == 'y') {
            System.out.println("Answer in hex: " + hexConvert(addyToDec));
        }
    }
    
    public static int[] hexNumberValues(char[] addy) {
        	int[] convert = new int[addy.length];
        	for(int i = 0; i < addy.length; i++) {
        		if(addy[i] >= 'A' && addy[i] <= 'F') convert[i] = addy[i] - 55;
        		else convert[i] = addy[i] - 48; 
        	}
        	return convert;
    }
    
    public static int getDecimal(int[] hexaNum) {
        	int sum = 0;
        	for(int i = 0; i < hexaNum.length; i++) {
        		sum += hexaNum[hexaNum.length - i - 1] * Math.pow(16, i);
        	} 
        	return sum;
    }
    
    public static String hexConvert(int decimalValue){
        	String hex = "";
        	while(decimalValue > 0){
        		if((decimalValue % 16)>=10 && (decimalValue % 16)<=15) {
        			int rem = decimalValue % 16;
        			hex = (char)(rem + 55) + hex; 
        			
        			decimalValue /= 16;
        		} 
        		else hex += decimalValue % 16;
        	}
        	hex = "0x" + hex;
        	return hex;
    }
}
