package raperfinals02;

import java.util.Scanner;

class RaperFinals02
{
    // Perform Run–length encoding (RLE) data compression algorithm
    // on string `str`
    public static String encode(String str)
    {
        // stores output string
        String encoding = "";
 
        // base case
        if (str == null) {
            return encoding;
        }
 
        int count;
 
        for (int i = 0; i < str.length(); i++)
        {
            // count occurrences of character at index `i`
            count = 1;
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1))
            {
                count++;
                i++;
            }
 
            // append current character and its count to the result
            encoding += String.valueOf(count) + str.charAt(i);
        }
 
        return encoding;
    }
    
    public static String encode2(String s){
        
        String encoding = "";
        int i = 0;
        int count = 0;
        char current = s.charAt(i);
        
        while (i <= s.length()){
            
            if (i == s.length()){
                encoding = encoding + count + current;
            }
            else if (current != s.charAt(i) && i==1){
                encoding = encoding + count + current;
                current = s.charAt(i);
                count = 1;
            }
            else if(current != s.charAt(i)){
                encoding = encoding + (count) + current;
                current = s.charAt(i);
                count = 1;
            }
            else{
                count++;
            }
            
            i++;
        }
        
        return encoding;
    }
 
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        
        //Run encode method
        System.out.println();
        System.out.println("Method encode() output: " + encode(str));    //encode()
        System.out.println("Method encode2() output: " + encode2(str));  //encode2()
        
        //Check if both are equal
        System.out.println("\nAre both equal?: " + encode2(str).equals(encode(str)));
    }
}