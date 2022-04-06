package HackerRank.Regex;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
Regex>Applications>Detect HTML Tags
In this challenge, we're using regular expressions to detect
the various tags used in an HTML document.

-Tags come in pairs. Some tag name, t, will have an opening tag,<t> ,
followed by some intermediate text, followed by a closing tag,</t> .
The forward slash in a closing tag will always come before the tag name.
-The exception to this is self-closing tags, which consist of a single tag
(not a pair) with a forward slash after the tag name:<p/>

Here are a few examples of tags:
-The <p> tag is for paragraphs:<p>this is a paragraph</p>
There may be 1 or more spaces before or after a tag name:< p>this is also a paragraph</p>
-A void or empty tag involves an opening
and closing tag with no intermediate characters:<p></p>

Some tags can also have attributes, such as the a tag,
which is used to add a hyperlink to another document:
<a href="http://www.google.com">Google</a>

In the above case, a is the tag name and href is an attribute having the value http://www.google.com.

Task
Given N lines of HTML, find the tag names (ignore any attributes)
and print them as a single line of lexicographically ordered
semicolon-separated values (e.g.: tag1;tag2;tag3).

Input Format

The first line contains an integer, N , the number of HTML fragments.
Each of the N subsequent lines contains a fragment of an HTML document.

Output Format

Print a single line containing all of the unique tag names found in the input.
Your output tags should be semicolon-separated and ordered
lexicographically (i.e.: alphabetically).
Do not print the same tag name more than once.

Sample Input
2
<p><a href="http://www.quackit.com/html/tutorial/html_links.cfm">Example Link</a></p>
<div class="more-info"><a href="http://www.quackit.com/html/examples/html_links_examples.cfm">More Link Examples...</a></div>

Sample Output
a;div;p

*/
public class Q035 {
    public static void main(String[] args) {
//        String regexSolutionPattern = "<\\s*a\\s+href\\s*=\\s*\\\"" +
//                "(?<link>[^\\\\\"]*)" +
//                "\\\"[^>]*>"+"(?<name>.*?)" +
//                "<\\s*/\\s*a\\s*>";
        String regexSolutionPattern = "<\\s*(?<tag>[a-zA-Z0-9]+)(?:\\s(?:\\s*[a-z]+\\s*=\\s*\"[^\"]*\")*)?\\s*(?:\\/>|>)";
        Pattern p = Pattern.compile(regexSolutionPattern);
        Matcher m = p.matcher("");

        HashSet<String> hset = new HashSet<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String line;
        for (int i = 0; i < n; i++) {
            line = input.nextLine().trim();
            m.reset(line);
            while (m.find()) {
                String tag = m.group("tag").trim();
                hset.add(tag);
            }
        }
        TreeSet<String> tset = new TreeSet<>(hset);
        System.out.println(tset.stream().collect(Collectors.joining(";")));
        input.close();
    }

}
