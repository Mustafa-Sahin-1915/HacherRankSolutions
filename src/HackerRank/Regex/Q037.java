package HackerRank.Regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Applications>The British and American Style of Spelling

American English and British English differ in several aspects
which are reflected in their spelling. One difference frequently observed,
is that words written in American English, which have a suffix ze often end in se in British English.
Given the American-English spelling of a word which ends in ze your task is to find
the total count of all its British and American variants in all the given sequences of words.
i.e. you need to account for the cases where the word occurs as it is given to you
(i.e. the version ending in -ze) and you also need to find the occurances of
its British-English counterparts (i.e, the version ending in -se).

Input Format

First line contains N, N lines follow each line contains a sequence of words (W)
separated by a single space. Next line contains T. T testcases follow in a new line.
Each line contains the American English spelling of a word (W')

Output Format

Output T lines and in each line output the total number of
American and British versions of (W') in all of N lines that contains a sequence of words.

Sample Input

2
hackerrank has such a good ui that it takes no time to familiarise its environment
to familiarize oneself with ui of hackerrank is easy
1
familiarize

Sample Output
2

 */
public class Q037 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String line="";
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            line = in.nextLine();
            //words = Arrays.asList(line.split(" "));
            words.add(line);
        }
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int t = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> testCases = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            line = in.nextLine();
            testCases.add(line);
        }
        int count=0;
        for (String w:testCases) {
            count=0;
            String wordBase = w.substring(0,w.length()-2);
            Matcher mAme = Pattern.compile(wordBase+"ze").matcher("");
            Matcher mBri = Pattern.compile(wordBase+"se").matcher("");
            for (String v:words){
                mAme.reset(v);
                mBri.reset(v);
                while (mAme.find()){
                    count++;
                }
                while(mBri.find()){
                    count++;
                }
            }
            System.out.println(count);
        }
        in.close();
    }
}
