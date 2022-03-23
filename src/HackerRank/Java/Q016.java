package HackerRank.Java;
/*
*A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.

Given a string A, print Yes if it is a palindrome, print No otherwise
*
* Constraints
* A will consist at most 50 lower case english letters.
* */


import java.util.Scanner;

public class Q016 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        char AsChars[] = A.toCharArray();
        int j =0;
        boolean isPalindrome = true;
        for (int i = AsChars.length-1;i>=0;i--){
            if (AsChars[i]!=AsChars[j]){
                isPalindrome = false; break;
            }
            j++;
        }
        if (isPalindrome){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        /* Enter your code here. Print output to STDOUT. */

    }
    public static boolean isPalindrome(String s){
        char AsChars[] = s.toCharArray();
        int j =0;
        boolean isPalindrome = true;
        for (int i = AsChars.length-1;i>=0;i--){
            if (AsChars[i]!=AsChars[j]){
                isPalindrome = false; break;
            }
            j++;
        }
       return isPalindrome;
    }
    public static boolean isPalindrome(int num){
        boolean isPalindrome = false;
        int reversedNum = 0, remainder;
        // store the number to originalNum
        int originalNum = num;
        // get the reverse of originalNum
        // store it in variable
        while (num != 0) {
            remainder = num % 10;
            reversedNum = reversedNum * 10 + remainder;
            num /= 10;
        }
        if (originalNum==reversedNum){
            return true;
        }else {
            return false;
        }
    }
}
