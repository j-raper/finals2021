package raperfinals01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Raperfinals01 {

    //String to Binary
    public static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                        .replaceAll(" ", "0")                             // zero pads
            );
        }
        return result.toString();
    }

    //Print Binary per character
    public static String printBinary(String binary, int blockSize, String separator) {

        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
            index += blockSize;
        }
        return result.stream().collect(Collectors.joining(separator));
    }
    
    //XOR Operation
    private static String  xorOperate(String a, String b, int n){
    String ans = "";
         
        // Loop to iterate over the
        // Binary Strings
        for (int i = 0; i < n; i++)
        {
            // If the Character matches
            if (a.charAt(i) == b.charAt(i))
                ans += "0";
            else
                ans += "1";
        }
        return ans;
    }
    
    //Binary to String
    private static int binaryToDecimal(String n) {
        String num = n;

        // Stores the decimal value
        int dec_value = 0;

        // Initializing base value to 1
        int base = 1;

        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {

            // If the current bit is 1
            if (num.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }

        // Return answer
        return dec_value;
    }
 
    // Function to convert binary to ASCII
    private static String setStringtoASCII(String str) {
        // To store size of s
        int N = (str.length());

        // If given String is not a
        // valid String
        if (N % 8 != 0) {
            return "Not Possible!";
        }

        // To store final answer
        String res = "";

        // Loop to iterate through String
        for (int i = 0; i < N; i += 8) {
            int decimal_value
                = binaryToDecimal((str.substring(i, 8+i)));

            // Apprend the ASCII character
            // equivalent to current value
            res += (char)(decimal_value);
        }

        // Return Answer
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //First Name *Default
        String firstName = "julieza"; 
        System.out.println("First Name: " + firstName);

        //Test Cases
        System.out.print("Enter string: ");
        String testCaseStr = sc.nextLine();
        
        /*Check the length
        System.out.println("testCaseStr: " + testCaseStr.length());
        System.out.println("firstName: " + firstName.length()); 
        */
                
        if(firstName.length() > testCaseStr.length()){
            //System.out.println("firstname is the greater length");
            String newStr = testCaseStr.repeat(testCaseStr.length()).substring(0, firstName.length());       
            testCaseStr = newStr;
        }
        
        String result_TestCase = convertStringToBinary(testCaseStr);  

        if(testCaseStr.length() > firstName.length()){
            //System.out.println("testcase is the greater length");
            String newStrFN = firstName.repeat(firstName.length()).substring(0, testCaseStr.length());
            firstName = newStrFN;
        }
        
        String result_FirstName = convertStringToBinary(firstName);
       
        /*Check result length
        System.out.println("testCaseStr length: " + result_FirstName.length());
        System.out.println("firstName length: " + result_TestCase.length()); 
        */
                
        String printBinary_FirstName = printBinary(result_FirstName, 8, " ");
        String printBinary_TestCase = printBinary(result_TestCase, 8, " ");
        
        System.out.println();
        System.out.println("First Name 8-bit Binary: \n" + printBinary_FirstName);
        System.out.println("Test Case 8-bit Binary: \n" + printBinary_TestCase);
        
        //Run XOR Operation
        int length = result_FirstName.length();
        
        String result_XOR = xorOperate(result_FirstName, result_TestCase, length);
        System.out.println("\nXOR Result: \n" + printBinary(result_XOR, 8, " "));
        
        //Binary to Hexadecimal
        System.out.println("\nFinal Output: ");
        System.out.println(setStringtoASCII(result_XOR));       
    }    
}
