package HackerRank.Java;

import java.util.Scanner;
/*
* Two strings, a and b, are called anagrams
* if they contain all the same characters in the same frequencies.
* For this challenge, the test is not case-sensitive.
* For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.
* Function Description

Complete the isAnagram function in the editor.

isAnagram has the following parameters:

string a: the first string
string b: the second string
* Returns

boolean: If a and b are case-insensitive anagrams, return true. Otherwise, return false.
* Input Format

The first line contains a string a.
The second line contains a string b.
* Constraints
* 1<=length(a),length(b)<=50
* Strings a and b consist of english characters.
* The comparasion should not be case sensitive.
*
* Sample Input 0

anagram
margana
* Sample Output 0
Anagrams

* Sample Input 1

anagramm
marganaa
* Sample Output 1

Not Anagrams
* */
public class Q017 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
    static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        char aChs[] = a.toCharArray();
        char bChs[] = b.toCharArray();
        boolean isAnag = true;
        if (a.length()!=b.length()){
            return false;
        }
        for (int i=0;i<a.length();i++){
            char ch = aChs[i];
            int suma=0;
            int sumb=0;
            for(int j=0;j<aChs.length;j++){
                if (ch==aChs[j]) suma++;
            }
            for(int k=0;k<bChs.length;k++){
                if (ch==bChs[k]) sumb++;
            }
            if (suma!=sumb){
                isAnag = false;break;
            }
        }
        return isAnag;
    }
    public static boolean isAnagram2(String a, String b){
        boolean isAng =true;
        if (a==null || b==null){
            return false;
        }
        if (a.length()!=b.length()){
            return false;
        }
        a=a.toLowerCase();
        b=b.toLowerCase();
        int al[]=new int [256];

        for(char c : a.toCharArray()){
            int i=(int) c;
            al[i]++;
        }
        for(char c : b.toCharArray()){
            int i=(int) c;
            al[i]--;
        }
        for (int i=0;i<256;i++){
            if(al[i]!=0){
                isAng=false;
                break;
            }
        }
        return isAng;
    }
    public static boolean isAnagram3(String a, String b){
        if (a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        int sum = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i=0; i<a.length(); i++) {
                if (a.charAt(i) == c) {
                    sum++;
                }
                if (b.charAt(i) == c) {
                    sum--;
                }
            }
            if (sum != 0) {
                return false;
            }
        }
        return true;
    }
}

