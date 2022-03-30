package HackerRank.Regex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Applications>UK and US: Part 2
We've already seen how UK and US words differ in their spelling.
One other difference is how UK has kept the usage of letters our in some
of its words and US has done away with the letter u and uses just or.
Given the UK format of the word that has our in it, find out the total number of occurrences
of both its UK and US variants in a given sequence of words.

Input Format
First line contains an integer N. N lines follow, each line contains a sequence
of words (W) separated by a single space.
Next lines contains an integer T. T testcases follow in a new line.
Each line contains the UK spelling of a word (W')

Output Format
Output T lines and in each line output the number
of UK and US version of (W') in all of N lines that contains a sequence of words.

Sample Input

2
the odour coming out of the left over food was intolerable
ammonia has a very pungent odor
1
odour

Sample Output
2

 */
public class Q025 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String regexSolutionPattern = "[a-z]*our[a-z]*";
        Pattern p = Pattern.compile(regexSolutionPattern,Pattern.CASE_INSENSITIVE);
        int N = scan.nextInt();
        String str;
        Matcher m = p.matcher("");
        Map<String,Integer> wordCounts = new HashMap<>();
        scan.nextLine();
        for (int i = 0; i < N; i++) {
            //change "or" to "our"
            str =scan.nextLine().toLowerCase().replaceAll("([a-zA-Z]+)or|or([a-zA-Z]+)","$1our$2");
            m.reset(str);
            while(m.find()){
                String w = m.group();
                Integer count = wordCounts.get(w);
                if (count==null || count==0){
                    wordCounts.put(w,1);
                }else{
                    wordCounts.put(w,count+1);
                }
            }
        }

        int T = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < T; i++) {
            str = scan.nextLine().toLowerCase();
            Integer count = wordCounts.get(str);
            System.out.println( count==null ? 0 : count);
        }
        scan.close();
    }
}
