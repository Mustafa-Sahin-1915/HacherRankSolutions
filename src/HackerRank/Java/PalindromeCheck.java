package HackerRank.Java;

public class PalindromeCheck {
    public static void main(String[] args) {
        //1. way
        String s1 = "AAAAAB";
        StringBuilder sb = new StringBuilder(s1);
        if (sb.reverse().toString().equals(s1)) {
            System.out.println("Palindrome");
        }else{
            System.out.println("is not palindrome");
        }
        //2. way
        boolean isPalindrome = true;
        for (int i = 0; i < s1.length()/2+1; i++) {
            if (s1.charAt(i)!=s1.charAt(s1.length()-1-i)){
                isPalindrome=false;break;
            }
        }
        if (isPalindrome){
            System.out.println("Palindrome");
        }else{
            System.out.println("is not palindrome");
        }
        //3.way
        String str = "AAABAAA";
        int i=0;
        int k=str.length()-1;
        while((str.charAt(i)-str.charAt(k))==0){
            i++;
            k--;
            if (i==k) break;
        }
        if (i==k){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }
}
