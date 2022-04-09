package HackerRank.Regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
Regex>Applications>Detect HTML Attributes
Charlie's second assignment was given by the Professor as soon as he submitted the first one.
Professor asked Charlie to create a list of all the attributes of every tag found in HTML pages.

<p>This is a paragraph</p>
The above HTML string has p as its tag but no attributes.

<a href="http://www.quackit.com/html/tutorial/html_links.cfm">Example Link</a>
This string has a as a tag and href as an attribute.

Input Format

The first line contains N, the number of lines in the HTML fragment.
This is followed by lines from a valid HTML document or fragment.

Output Format

Each tag must be separated by a newline arranged in lexicographic order
Each attribute noted for a given tag must be arranged next to a tag in lexicographic order.

The output will be of the format

tag-1:attribute-1,attribute-2,attribute-3....
tag-2:attribute-1,attribute-2,attribute-3....
tag-3:attribute-1,attribute-2,attribute-3....
...
tag-n:attribute-1,attribute-2,attribute-3....
Where tag-1 is lexicographically smaller than tag-2 and attribute-1 is
lexicographically smaller than attribute-2
Sample Input:1

2
<p><a href="http://www.quackit.com/html/tutorial/html_links.cfm">Example Link</a></p>
<div class="more-info"><a href="http://www.quackit.com/html/examples/html_links_examples.cfm">More Link Examples...</a></div>

Sample Output:1

a:href
div:class
p:

Sample Input:2

9
<li style="-moz-float-edge: content-box">... that <a href="/wiki/Orval_Overall" title="Orval Overall">Orval Overall</a> <i>(pictured)</i> is the only <b><a href="/wiki/List_of_Major_League_Baseball_pitchers_who_have_struck_out_four_batters_in_one_inning" title="List of Major League Baseball pitchers who have struck out four batters in one inning">Major League Baseball player to strike out four batters in one inning</a></b> in the <a href="/wiki/World_Series" title="World Series">World Series</a>?</li>
<li style="-moz-float-edge: content-box">... that the three cities of the <b><a href="/wiki/West_Triangle_Economic_Zone" title="West Triangle Economic Zone">West Triangle Economic Zone</a></b> contribute 40% of Western China's GDP?</li>
<li style="-moz-float-edge: content-box">... that <i><a href="/wiki/Kismet_(1943_film)" title="Kismet (1943 film)">Kismet</a></i>, directed by <b><a href="/wiki/Gyan_Mukherjee" title="Gyan Mukherjee">Gyan Mukherjee</a></b>, ran at the <a href="/wiki/Roxy_Cinema_(Kolkata)" title="Roxy Cinema (Kolkata)">Roxy, Kolkata</a>, for 3 years and 8 months?</li>
<li style="-moz-float-edge: content-box">... that <a href="/wiki/Vauix_Carter" title="Vauix Carter">Vauix Carter</a> both coached and played for the <b><a href="/wiki/1882_Navy_Midshipmen_football_team" title="1882 Navy Midshipmen football team">1882 Navy Midshipmen football team</a></b>?</li>
<li style="-moz-float-edge: content-box">... that <a href="/wiki/Zhu_Chenhao" title="Zhu Chenhao">Zhu Chenhao</a> was sentenced to <a href="/wiki/Slow_slicing" title="Slow slicing">slow slicing</a> for leading the <b><a href="/wiki/Prince_of_Ning_rebellion" title="Prince of Ning rebellion">Prince of Ning rebellion</a></b> against the <a href="/wiki/Ming_Dynasty" title="Ming Dynasty">Ming Dynasty</a> <a href="/wiki/Zhengde_Emperor" title="Zhengde Emperor">emperor Zhengde</a>?</li>
<li style="-moz-float-edge: content-box">... that <b><a href="/wiki/Mirza_Adeeb" title="Mirza Adeeb">Mirza Adeeb</a></b> was a prominent modern Pakistani <a href="/wiki/Urdu" title="Urdu">Urdu</a> playwright whose later work focuses on social problems and daily life?</li>
<li style="-moz-float-edge: content-box">... that in <i><b><a href="/wiki/La%C3%9Ft_uns_sorgen,_la%C3%9Ft_uns_wachen,_BWV_213" title="Lat uns sorgen, lat uns wachen, BWV 213">Die Wahl des Herkules</a></b></i>, Hercules must choose between the good cop and the bad cop?<br style="clear:both;" />
<div style="text-align: right;" class="noprint"><b><a href="/wiki/Wikipedia:Recent_additions" title="Wikipedia:Recent additions">Archive</a></b>  <b><a href="/wiki/Wikipedia:Your_first_article" title="Wikipedia:Your first article">Start a new article</a></b>  <b><a href="/wiki/Template_talk:Did_you_know" title="Template talk:Did you know">Nominate an article</a></b></div>
</li>

Sample Output:2

a:href,title
b:
br:style
div:class,style
i:
li:style
Pattern EMAIL_ADDRESS_PATTERN =
  Pattern.compile("([a-z0-9_.-]+)@([a-z0-9_.-]+[a-z])");
 \G                     # start where the last match left off
   (?>                    # begin non-backtracking expression
       .*?                # *anything* until...
       <[Aa]\b            # an anchor tag
    )??                   # but look ahead to see that the rest of the expression
                          #    does not match.
    \s+                   # at least one space
    ( \p{Alpha}           # Our first capture, starting with one alpha
      \p{Alnum}*          # followed by any number of alphanumeric characters
    )                     # end capture #1
    (?: \s* = \s*         # a group starting with a '=', possibly surrounded by spaces.
        (?: (['"])        # capture a single quote character
            (.*?)         # anything else
             \2           # which ever quote character we captured before
        |   ( [^>\s'"]+ ) # any number of non-( '>', space, quote ) chars
        )                 # end group
     )?                   # attribute value was optional

*/
public class Q026 {
    public static void main(String[] args) {
        String regexSolutionPattern = "<\\s*(?<tag>[a-zA-Z0-9]+)(?<attrs>(?:\\s[^>]*)?)\\s*>";

        Pattern p = Pattern.compile(regexSolutionPattern,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher("");

        String attrsRegEx="(?<attr>[a-zA-Z0-9_]+)(?:\\s*=\\s*(?:\\\"(?:\\\\\"|.)*?\\\"|'(?:\\\\'|.)*?'))?";
        Matcher attrMatch = Pattern.compile(attrsRegEx,Pattern.CASE_INSENSITIVE).matcher("");

        Map<String, Set<String>> tagsAndAttributes = new TreeMap<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String line;
        for (int i = 0; i < n; i++) {
            line = input.nextLine().trim();
            m.reset(line);
            while (m.find()) {
                String tag = m.group("tag").trim();
                String attrs = m.group("attrs").trim();
                if (!tagsAndAttributes.containsKey(tag)){
                    tagsAndAttributes.put(tag,new TreeSet<>());
                }
                if (m.group("attrs")!=null) {
                    attrMatch.reset(attrs);
                    while (attrMatch.find()){
                        String attr = attrMatch.group("attr");
                        tagsAndAttributes.get(tag).add(attr);
                    }
                }

            }
        }
        for (Map.Entry<String, Set<String>> w:tagsAndAttributes.entrySet()){
            System.out.print(w.getKey()+":");
            int count=w.getValue().size();
            for (String v:w.getValue()){
                System.out.print(v+(--count>0?",":""));
            }
            System.out.println();
        }
        input.close();
    }
}
