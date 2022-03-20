package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/*
Java>Advanced>Java Lambda Expressions

This Java 8 challenge tests your knowledge of Lambda expressions!

Write the following methods that
return a lambda expression performing a specified action:

-PerformOperation isOdd(): The lambda expression must return true if a number is odd or
       false  if it is even.

PerformOperation isPrime(): The lambda expression must return true
     if a number is prime or false if it is composite.

PerformOperation isPalindrome(): The lambda expression must return true
         if a number is a palindrome or false if it is not.


 */
interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    public static PerformOperation isOdd(){
        return (int n)-> n%2!=0;
    }

    public static PerformOperation isOdd2(){
        return (int n)->  (n&1)==1;
    }

    public static PerformOperation isPrime(){
        return n -> {
             if(n<3) return true;
             if((n % 2)==0) return false;
             for(int i=3;i<Math.sqrt(n);i+=2){
                 if((n % i)==0)return false;
             }
             return true;
        };
    }
    public static PerformOperation isPrime2(){
        return (int n) -> java.math.BigInteger.valueOf(n).isProbablePrime(1);
    }
    public static PerformOperation isPrime3(){

        return n -> IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .noneMatch(i -> n%i == 0);
    }

    public static PerformOperation isPalindrome(){
        return n -> {
            String pS=String.valueOf(n);
            int sz=pS.length();
            for(int i=0;i<sz/2;i++) {
                if (pS.charAt(i) != pS.charAt(sz - 1 - i)) return false;
            }
            return true;
        };
    }
    public static PerformOperation isPalindrome2(){
        return (int n) -> {
            return Integer.toString(n).equals(new StringBuilder(Integer.toString(n)).reverse().toString());
        };
    }
    public static PerformOperation isPalindrome3(){

        return n -> IntStream.iterate(n, e -> e/10 )
                .limit(11)
                .filter(f -> f>0)
                .map(e -> e%10)
                .reduce(0, (c,e)->c*10+e)
                == n;
    }
}

public class Q053 {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
