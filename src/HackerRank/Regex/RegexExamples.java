package HackerRank.Regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 *The Java Regex or Regular Expression is an API to define a pattern
 * for searching or manipulating strings.
 *----------------------------------
 * Matcher class: implements MatchResult interface. it is a regex engine it is used to perform
 * match operations on a character sequence.
 * -boolean matches(): test whether the regular exp matches the pattern.
 * -boolean find():finds the next expression that matches the pattern.
 * -boolean find(int start):finds the next exression that matches the pattern from the given start number.
 * -String group():returns the matched subsequence.
 * -int start():returns the starting index of matched subsequence.
 * -end():returns the ending index of matched subsequence.
 *- int groupCount():returns the total number of the matched subsequence.
 * --------------------------------------
 * Pattern Class:Is is compiled version of a regular expression. It is used to define a pattern for regex engine.
 * -static Pattern compile(String regex):compiles the given regex and returns the instance of the Pattern.
 * -Matcher matcher(CharSequence input):creates a matcher that matches the given input with the pattern.
 * -static boolean matches(String regex, CharSequence input):It works as the combination of
 * compile and matcher methods.
 * It compiles the regular expression and matches the given input with the pattern.
 * -String[] split(CharSequence input):splits the given input string around matches of given pattern.
 * -String pattern():returns the regex pattern.
 * -------------------------------------------------
Regex Character classes
--------------------------------------
[abc]	a, b, or c (simple class)
[^abc]	Any character except a, b, or c (negation)
[a-zA-Z]	a through z or A through Z, inclusive (range)
[a-d[m-p]]	a through d, or m through p: [a-dm-p] (union)
[a-z&&[def]]	d, e, or f (intersection)
[a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
[a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z](subtraction)
[abc][vz]       Set definition, can match a or b or c followed by either v or z.
X|Z             Finds X or Z.
XZ              Finds X directly followed by Z.
$               Checks if a line end follows.
^...               Checks if a line starts with ...  ex: ^Bob  :line starts with Bob and effects all lines
\A...              Checks if a line starts with ... ex:\ABob :line starts with Bob and does not effect all lines only single line
\Z                 Checks if a line ends with ...:  ex Bob\Z: effects only one line

()              you can group parts of your regular expression.
$1              first group
$2              second group
(?!pattern)     Negative look ahead ex: a(?!b) matches "a" if "a" is not followed by "b"
(?i)            makes regex case insensitive: you can add the mode modifier to the start of regex
(?s)

Regex Quantifiers
--------------------------------
X?	X occurs once or not at all
X+	X occurs once or more times
X*	X occurs zero or more times
X{n}	X occurs n times only
X{n,}	X occurs n or more times
X{y,z}	X occurs at least y times but less than z times

Regex Metacharacters
--------------------------------
 .	Any character (may or may not match terminator)
\d	Any digits, short of [0-9]
\D	Any non-digit, short for [^0-9]
\s	Any whitespace character, short for [\t\n\x0B\f\r]
\S	Any non-whitespace character, short for [^\s]
\w	Any word character, short for [a-zA-Z_0-9]
\W	Any non-word character, short for [^\w]
\b	A word boundary
\B	A non word boundary

^regex :Finds regex that must match at the beginning of the line.
regex$ :Finds regex that must match at the end of the line.

Java's String class has built-in support for regular expressions:
-matches("regex"): evaluates if regex matches s or not. boolean returns
-split("regex"): creates String[] array of substrings of s divided at occurence of regex
-replaceFirst("regex","replacement"):replaces the first occurence of "regex" with "replacement"
-replaceAll("regex","replacement"):replaces all occurences of "regex" with "replacement"

\\n :newline
\\r :enter
*
Capturing Groups:
*-----------------------------------
There are 4 types of such groups:
((A)(B(C)))
(A)
(B(C))
(C)
*/


public class RegexExamples {
    public static void main(String[] args) {
        test12();
    }

    public static void test01() {
        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        String input = "Hello hello Ab aB";
        Matcher m = p.matcher(input);

        // Check for subsequences of input that match the compiled pattern
        while (m.find()) {
            System.out.println(m.groupCount());
            for (int i = 0; i < m.groupCount(); i++) {
                System.out.println(m.group(i));
            }
            input = input.replaceAll(m.group(), m.group(1));
        }

        // Prints the modified sentence.
        System.out.println(input);
    }
    public static void test02(){
        String PIV4pattern="null";
        String zeroTo255
                = "(\\d{1,2}|(0|1)\\"
                + "d{2}|2[0-4]\\d|25[0-5])";
        PIV4pattern = zeroTo255 + "\\." + zeroTo255 + "\\."+ zeroTo255 + "\\."+ zeroTo255;
        String IP = "192.168.0.1";
        //String IP = "192.168.0.1.1";
        System.out.println(IP.matches(PIV4pattern));

    }
    public static void test03(){
        //1st way
        Pattern p = Pattern.compile(".s");//. represents single character
        Matcher m = p.matcher("as bs cs ccs asc");
        boolean b = m.matches();
        //2nd way
        boolean b2=Pattern.compile(".s").matcher("as").matches();
        //3rd way
        boolean b3 = Pattern.matches(".s", "as");
        System.out.println(b+":"+b2+":"+b3);
    }
    public static void test04(){
        System.out.println(Pattern.matches("[amn]", "abcdmn"));
        System.out.println(Pattern.matches("[amn]", "amn"));
        System.out.println(Pattern.matches("[amn]", "a"));
        System.out.println(Pattern.matches("[amn]", "A"));
        System.out.println(Pattern.matches("(?i)[amn]", "A"));

        System.out.println(Pattern.matches("[amn]?", "a"));//a or m or n comes one time only
        System.out.println(Pattern.matches("[amn]?", "aa"));

        System.out.println(Pattern.matches("[amn]+", "a"));
        System.out.println(Pattern.matches("[amn]+", "aaa"));

        System.out.println(Pattern.matches("[amn]+", "aammmnn"));//a|m|n occurs one and more
        System.out.println(Pattern.matches("[amn]+", "aazzta"));

        System.out.println(Pattern.matches("[amn]*", "ammmna"));//a|m|n occurs zero and more

        System.out.println(Pattern.matches("\\d", "abc"));//false
        System.out.println(Pattern.matches("\\d", "1"));//true
        System.out.println(Pattern.matches("\\d", "123"));//false

        System.out.println(Pattern.matches("\\D", "1"));//false non digit one character
        System.out.println(Pattern.matches("\\D", "a"));//true
        System.out.println(Pattern.matches("\\D", "ab"));//false
        System.out.println(Pattern.matches("\\D*", "mak"));//true

        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun32"));//true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "karun32"));//false

        System.out.println(Pattern.matches("[789][0-9]{9}", "9953038949"));//true
        System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "9953038949"));//true
        System.out.println(Pattern.matches("[789][0-9]{9}", "6953038949"));//false
        System.out.println(Pattern.matches("[789]{1}\\d{9}", "8853038949"));//true


    }
    public static void test05(){
        //pattern for decimal
        System.out.println(Pattern.matches("^\\d+(\\.\\d+)?", "12"));
        System.out.println(Pattern.matches("^\\d+(\\.\\d+)?", "12.1234"));
        System.out.println(Pattern.matches("^\\d+(\\.\\d+)?", "12.111.1"));
    }
    public static void test06(){
        // Removes whitespace between a word character and . or ,
        String test = "mustafa sahin         , deneme        .ee    , ";
        String pattern = "(\\w)(\\s+)([\\.,])";
        System.out.println(test.replaceAll(pattern, "$1$3"));
    }
    public static void test07(){
        // Extract the text between the two title elements
        String test = "<title   deneme>Mustafa Sahin <title>";
        String pattern = "(?i)(<title.*?>)(.+?)()";
        System.out.println(test.replaceAll(pattern, "$2"));
    }
    public static void test08(){
        //replaces one or more than one white spaces with one space
        String test = "mustafa      sahin   deneme";
        test =test.replaceAll("\\s+"," ");
        System.out.println(test);
    }
    public static void test09(){
        System.out.println(Pattern.matches("[tT]rue|[yY]es", "yes"));//true
        System.out.println(Pattern.matches("[tT]rue|[yY]es", "yeS"));//false

        System.out.println(Pattern.matches(".*true.*", "denemetruedeneme"));//true
        System.out.println(Pattern.matches(".*true.*", "denemetrudeneme"));//false

        System.out.println(Pattern.matches("(\\w){3}", "as1"));//true
        System.out.println(Pattern.matches("(\\w){3}", "as1a"));//false
        System.out.println(Pattern.matches("([a-zA-Z]){3}", "as1"));//false
        System.out.println(Pattern.matches("([a-zA-Z]){3}", "asK"));//true
        System.out.println(Pattern.matches("([a-zA-Z]){3}", "askk"));//false
        //does not have a number at the beginning
        System.out.println(Pattern.matches("^[^\\d].*", "as1 asas"));//true
        System.out.println(Pattern.matches("^[^\\d].*", "1as aass"));//false
        //contains arbitrary number of characters except b
        System.out.println(Pattern.matches("([\\w&&[^b]])*", "as1asas"));//true
        System.out.println(Pattern.matches("([\\w&&[^b]])*", "1as bass"));//false
        //contains less than 300
        System.out.println(Pattern.matches("[^0-9]*[12]?[0-9]{1,2}[^0-9]*", "299"));//true
        System.out.println(Pattern.matches("[^0-9]*[12]?[0-9]{1,2}[^0-9]*", "300"));//false
    }
    public static void test10(){
        String test ="     this is a test of regular expressions of java 123 w123   ";
        test = test.replaceAll("^\\s+\\s+?","");
        test =test.replaceAll("\\s+"," ");
        String substrings[] = test.split("\\s+");
        System.out.println(Arrays.toString(substrings));
    }
    public static void test11(){
        String patternOfHTML = "<a\\b[^>]*href=\\\"[^>]*>(.*?)</a>";
        String patternOfLink = "href=\\\"[^>]*\\\">";
    }
    public static void test12(){
        //this is back reference
        System.out.println(Pattern.matches("(\\d\\d)\\1", "1212"));//true
        System.out.println(Pattern.matches("(\\d\\d)\\1", "1213"));//false

        System.out.println(Pattern.matches("(\\d\\d)(\\d\\d)", "1212"));//true
        System.out.println(Pattern.matches("(\\d\\d)(\\d\\d)", "1213"));//true

        System.out.println(Pattern.matches("^dog", "dogs are animals"));//false
        System.out.println(Pattern.matches("^dog", "dog assa"));//false
        System.out.println(Pattern.matches("^dog", "are dog animals"));//false

        System.out.println(Pattern.matches("dog$", "Man's best friend is a dog"));//false
    }
    public static void test13(){
        //Write a regex to split String by new line?
        String str = " asasa\nasasa";
        String lines[] = str.split("\\r?\\n");

        //What is use of Dot(.) symbol in Java Regex?
        // the dot is used for matching any character
        //[0-9]. represents number and any character

        //How to extract a substring using regex ?
        String str2 = "This is a test String and 'This is data we want'";
        Pattern pattern1 = Pattern.compile("'(.*?)'");
        Matcher matcher1 = pattern1.matcher(str2);
        if (matcher1.find())
        {
            System.out.println(matcher1.group(1));
        }
        //What is difference between matches() and find() in Java Regex?
        //matches() returns true only if the whole string matches the specified pattern
        //while find() returns trues even if a substring matches the pattern.
        //matches() matches the expression against the entire string as it implicitly add
        // a ^ at the start and $ at the end of your pattern,
        // so it will not match substring or part of the string.
        // ^ and $ are meta characters that represents start of the string and
        // end of the string respectively.
        Pattern pattern2 = Pattern.compile("\\d");
        String test = "JavaInUse123";
        Matcher m = pattern2.matcher(test);

        if (m != null){
            System.out.println(m.find());
            System.out.println(m.matches());
        }

        //How to replace all non-alphanumeric characters with empty strings?
        // replaceAll("[^A-Za-z0-9]", "");

        //How to replace 2 or more spaces with single space in string
        // and delete leading and trailing spaces?
        //replaceAll("\\s{2,}", " ").trim();

        //Create a regular expression that accepts alphanumeric characters only.
        // Its length must be five characters long only
        System.out.println(Pattern.matches("[a-zA-Z0-9]{5}", "java1"));//true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{5}", "java"));//false

        //Create a regular expression that accepts 10 digit numeric characters
        // starting with 1, 2 or 3 only.
        System.out.println(Pattern.matches("[123][0-9]{9}", "1234567890"));//true
        System.out.println(Pattern.matches("[123][0-9]{9}", "5234567890"));//false
        System.out.println(Pattern.matches("[123]{1}\\d{9}", "2885338949"));//true

        //What is the mean of Regular Expressions?
        // Reg Ex is a pattern which is used to search string like "search name starts with a or end with z"

        //what isregular expression to validate email ?
        String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";

        //Write a Regular expression to match line that doesn't contain a word?
        //to find a word FINDME
        String patternNotToFindAWord = "^((?!FINDME).)*$";

        //How do I remove all non alphanumeric characters from a string?
        //replaceAll([^a-zA-Z0-9\s],"");

        //Simple regular expression for a decimal with a precision of 2
        // \d+(\\.\d{1,2})?

        //Explain the difference between String.matches and Matcher.matches.
        //Matcher.matches() is good in terms of performance as a Matcher is created
        // on a precompiled regular expressions,
        // while the String.matches() recompiles the regular expression every time it executes.

        //Is Java Regex Thread Safe?
        //Instances of Pattern class are immutable and
        // are safe for use by multiple concurrent threads.
        // Instances of the Matcher class are not thread safe.

        //Full Numeric Strings ^[0-9]+$ or ^\d+$

        //Positive Integer Literals [1-9][0-9]*|0 or [1-9]\d*|0

        //Full Integer Literals ^[+-]?[1-9][0-9]*|0$ or ^[+-]?[1-9]\d*|0$

        //Identifiers (or Names) [a-zA-Z_][0-9a-zA-Z_]* or [a-zA-Z_]\w*

        //Image Filenames ^\\w+\\.(gif|png|jpg|jpeg)$

        //Email Addresses ^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$

        //Swapping Words using Parenthesized Back-References ^(\S+)\s+(\S+)$ and $2 $1

        // HTTP Addresses ^http:\/\/\S+(\/\S+)*(\/)?$
    }
    public static void test14(){

    }
    public static void test15(){

    }
    public static void test16(){

    }
    public static void test17(){

    }
}

