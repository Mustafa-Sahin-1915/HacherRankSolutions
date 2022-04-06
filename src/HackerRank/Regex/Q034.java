package HackerRank.Regex;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
Regex>Applications>Detect HTML links
Charlie has been given an assignment by his Professor
to strip the links and the text name from the html pages.
A html link is of the form,

<a href="http://www.hackerrank.com">HackerRank</a>

Where a is the tag and href is an attribute
which holds the link charlie is interested in.
The text name is HackerRank.

Charlie notices that the text name can sometimes
be hidden within multiple tags

<a href="http://www.hackerrank.com"><h1><b>HackerRank</b></h1></a>

Here, the text name is hidden inside the tags h1 and b.

Help Charlie in listing all the links and the text name of the links.

Input Format

The first line contains the number of lines in the fragment (N).
This is followed by N lines from a valid HTML document or fragment.
Constraints

N < 100
Number of characters in the test fragments <= 10000 characters.
Characters will be restricted to ASCII. Fragments for the tests will be picked up from Wikipedia.
Also, some tests might not have text or names on the links.

Output Format

If there are M links in the document, display each of them in a new line.
The link and the text name must be separated by a "," (comma) with no spaces between them.
Strip out any extra spaces at the start and end position of both the link
and the text name before printing.

link-1,text name-1
link-2,text name-2
link-3,text name-3
....
link-n,text name-M

Sample Input

Sample Input:1

2
<p><a href="http://www.quackit.com/html/tutorial/html_links.cfm">Example Link</a></p>
<div class="more-info">
<a href="http://www.quackit.com/html/examples/html_links_examples.cfm">More Link Examples...</a></div>

sample input:2
13
<div class="portal" role="navigation" id='p-navigation'>
<h3>Navigation</h3>
<div class="body">
<ul>
 <li id="n-mainpage-description"><a href="/wiki/Main_Page" title="Visit the main page [z]" accesskey="z">Main page</a></li>
 <li id="n-contents"><a href="/wiki/Portal:Contents" title="Guides to browsing Wikipedia">Contents</a></li>
 <li id="n-featuredcontent"><a href="/wiki/Portal:Featured_content" title="Featured content  the best of Wikipedia">Featured content</a></li>
<li id="n-currentevents"><a href="/wiki/Portal:Current_events" title="Find background information on current events">Current events</a></li>
<li id="n-randompage"><a href="/wiki/Special:Random" title="Load a random article [x]" accesskey="x">Random article</a></li>
<li id="n-sitesupport"><a href="//donate.wikimedia.org/wiki/Special:FundraiserRedirector?utm_source=donate&utm_medium=sidebar&utm_campaign=C13_en.wikipedia.org&uselang=en" title="Support us">Donate to Wikipedia</a></li>
</ul>
</div>
</div>

Sample Output

Sample Output:1

http://www.quackit.com/html/tutorial/html_links.cfm,Example Link
http://www.quackit.com/html/examples/html_links_examples.cfm,More Link Examples...

Sample Output:2

/wiki/Main_Page,Main page
/wiki/Portal:Contents,Contents
/wiki/Portal:Featured_content,Featured content
/wiki/Portal:Current_events,Current events
/wiki/Special:Random,Random article
//donate.wikimedia.org/wiki/Special:FundraiserRedirector?utm_source=donate&utm_medium=sidebar&utm_campaign=C13_en.wikipedia.org&uselang=en,Donate to Wikipedia


regex html tag:<([A-Z][A-Z0-9]*)\b[^>]*>.*?</\1>
regex checkin doubling word: \b(\w+)\s+\1\b

regex <a .*?href=(["'])([^\1]+?)\1[^>]*>(<[^>]+>)*\s*([^<]+)?\s* /g

*/
public class Q034 {
    public static void main(String[] args) {

//<a href="http://www.quackit.com/html/tutorial/html_links.cfm"> <p> <b> Example Link </b> </ p > </a>
// <a href="/wiki/Special:Random" title="Load a random article [x]" accesskey="x">Random article</a>
// <a href="http://www.quackit.com/html/tutorial/html_links.cfm"> <p> <b> Example <b>Link</b> </b> </ p > </a>
        sol3();

    }

    public static void sol1() {
        String regexSolutionPattern = "<\\s*a\\s+href\\s*=\\s*\\\"" +
                "(?<link>[^\\\\\"]*)" +
                "\\\"[^>]*>(?:\\s*<\\s*[^>]*)*" +
                "(?<=>)(?<name>.*?)(?=\\s*<)" +
                "(?:\\s*<\\s*/[^>]*>)*<\\s*/\\s*a\\s*>";
        Pattern p = Pattern.compile(regexSolutionPattern);


        Matcher m = p.matcher("");

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String line;
        for (int i = 0; i < n; i++) {
            line = input.nextLine();
            m.reset(line);
            while (m.find()) {
                String link = m.group("link").trim();
                String name = m.group("name").trim();
                name = name.replaceAll("<\\s*[a-z0-9]+\\s*>","").trim();
                name = name.replaceAll("<\\s*/\\s*[a-z0-9]+\\s*>","").trim();
                System.out.println(link + "," + name);
            }
        }
        input.close();
    }

    public static void sol2() {
        String regexSolutionPattern = "<a.*?href=([\"'])([^\1]+?)\1[^>]*>(<[^>]+>)*\\s*([^<]+)?\\s*/g";
        Matcher m = Pattern.compile(regexSolutionPattern, Pattern.CASE_INSENSITIVE).matcher("");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String line;
        for (int i = 0; i < n; i++) {
            line = input.nextLine();
            m.reset(line);
            while (m.find()) {
                String link = m.group(2).trim();
                String name = m.group(4).trim();
                System.out.println(link + "," + name);
            }
        }
        input.close();
    }

    //Parse all tags by regex pattern <\s*[a-z0-9]+. Then sort them and print unique tags.
    public static void printTags() {
        String tagPattern = "<\\s*[a-z0-9]+";
        Scanner stdin = new Scanner(System.in);
        int lines = Integer.parseInt(stdin.nextLine());
        Set<String> tags = new TreeSet<>();
        for (int i = 0; i < lines; i++) {
            String line = stdin.nextLine();
            Pattern pattern = Pattern.compile(tagPattern);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                tags.add(matcher.group().replaceAll("<", ""));
            }
        }
        System.out.println(tags.stream().collect(Collectors.joining(";")));
        stdin.close();
    }

    public static void sol3() {
        //<a href="http://www.quackit.com/html/tutorial/html_links.cfm"> <p> <b> Example Link </b> </ p > </a>
// <a href="/wiki/Special:Random" title="Load a random article [x]" accesskey="x">Random article</a>
// <a href="http://www.quackit.com/html/tutorial/html_links.cfm"> <p> <b> Example <b>Link</b> </b> </ p > </a>

        Pattern p = Pattern.compile("<a\\s*href=\"([^\"]+)\"([^<>]*)>(.*)<\\s*/\\s*a\\s*>");
        String regexSolInner = "<([A-Z][A-Z0-9]*)\\b[^>]*>(?<nam>.*?)</\\1>";

        Matcher m = p.matcher("");
        Matcher m2 = Pattern.compile(regexSolInner, Pattern.CASE_INSENSITIVE).matcher("");

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String line;
        for (int i = 0; i < n; i++) {
            line = input.nextLine();
            m.reset(line);
            while (m.find()) {
                String link = m.group(1).trim();
                String name = m.group(3).trim();
                name = name.replaceAll("<\\s*[a-z0-9]+\\s*>","").trim();
                name = name.replaceAll("<\\s*/\\s*[a-z0-9]+\\s*>","").trim();
                System.out.println(link + "," + name);
            }
        }
        input.close();
    }
    public static void sol4(){
        Pattern p = Pattern.compile("<a[^<>]*href=\"(.*?)\"[^<>]*>((<[^<>]+>)*?([^<>]*)(</[^<>]+>)*?)</a>");
        Matcher m = p.matcher("");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String line;
        for (int i = 0; i < n; i++) {
            line = input.nextLine();
            m.reset(line);
            while (m.find()) {
                String link = m.group(1).trim();
                String name = m.group(4).trim();
                System.out.println(link + "," + name);
            }
        }
        input.close();
    }
}

