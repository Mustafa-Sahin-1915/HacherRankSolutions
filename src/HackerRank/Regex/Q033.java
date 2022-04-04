package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Applications>HackerRank Language
Every submission at HackerRank has a field called language
which indicates the programming language which a hacker used to code his solution.

C:CPP:JAVA:PYTHON:PERL:PHP:RUBY:CSHARP:HASKELL:CLOJURE:
BASH:SCALA:ERLANG:CLISP:LUA:BRAINFUCK:JAVASCRIPT:GO:D:OCAML:R:PASCAL:SBCL:DART: GROOVY:OBJECTIVEC

Sometimes, error-prone API requests can have an invalid language field.
Could you find out if a given submission has a valid language field or not?

Input Format

First line contains N.
N API requests follow, each in a newline.
Each request has an integer api_id and a string language
which are the request parameters placed by the an API request.
Constraints

1 <= N <= 100
10^4 <= api_id < 10^5
a valid language is any of the languages listed above (case sensitive):
Output Format

For every api request given in input,
print "VALID" if it has a valid language string in it or
print "INVALID" otherwise.

3
11011 LUA
11022 BRAINFUCK
11044 X

Sample Output

VALID
VALID
INVALID

 */
public class Q033 {
    public static void main(String[] args) {
        String regexSolutionPattern = "^[1-9][0-9]+\\s(C|CPP|JAVA|PYTHON|PERL|PHP|RUBY|CSHARP|HASKELL|CLOJURE|BASH|SCALA|ERLANG|CLISP|LUA|BRAINFUCK|JAVASCRIPT|GO|D|OCAML|R|PASCAL|SBCL|DART|GROOVY|OBJECTIVEC)$";
        Matcher m = Pattern.compile(regexSolutionPattern).matcher("");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String line;
        for (int i = 0; i < n; i++) {
            line =input.nextLine();
            if (m.reset(line).matches()){
                System.out.println("VALID");
            }else{
                System.out.println("INVALID");
            }
        }
        input.close();
    }
}
