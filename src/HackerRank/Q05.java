package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* Task
Given an integer ,N , print its first 10 multiples.
* Each multiple Nxi (where 1<=i<=10) should be printed on a new line in the form: N x i = result.

Input Format

A single integer, .

Constraints
2<=N<=20
Output Format

Print 10 lines of output; each line i (where 1<=i<=10) contains the result  of Nxi  in the form:
N x i = result.
* */
public class Q05 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(bufferedReader.readLine().trim());
            if (N>=2 && N<=20){
                for (int i = 1; i < 11; i++) {
                    System.out.println(N+" x "+i+" = "+N*i);
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
