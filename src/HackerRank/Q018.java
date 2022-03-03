package HackerRank;

import java.util.Scanner;

/*
* Given a string, s, matching the regular expression
* [A-Za-z !,?._'@]+, split the string into tokens.
* We define a token to be one or more consecutive English alphabetic letters.
* Then, print the number of tokens, followed by each token on a new line.

Note: You may find the String.split method helpful in completing this challenge.
*
* Input Format

A single string, s.
*
* Constraints
* 1<= length of s <=4.10^5
* s is composed of any of the following:
* English alphabetic letters, blank spaces, exclamation points (!),
* commas (,), question marks (?), periods (.),
* underscores (_), apostrophes ('), and at symbols (@).
*
* Output Format

On the first line, print an integer,n , denoting the number of tokens in string
* (they do not need to be unique). Next, print each of the n tokens on a new line
* in the same order as they appear in input string s.
*
* Sample Input

He is a very very good boy, isn't he?
* */
public class Q018 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        s = s.trim();
        if (s.length() == 0 || s.length() > 400000) {
            System.out.println(0);
            return;
        }
        //String tokens[] = s.split("[, ?.@!'_]+");
        String tokens[] = s.split("[^a-zA-Z]+");

        System.out.println(tokens.length);
        for (String w : tokens) {
            System.out.println(w.trim());
        }


    }
}
