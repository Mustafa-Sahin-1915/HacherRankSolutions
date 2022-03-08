package HackerRank;

import java.util.Scanner;
import java.util.Stack;

/*
Java>Data Structures>Java Stack
In computer science, a stack or LIFO (last in, first out) is an abstract data type
that serves as a collection of elements, with two principal operations:
push, which adds an element to the collection,
and pop, which removes the last element that was added.(Wikipedia)

A string containing only parentheses is balanced if the following is true:
1. if it is an empty string
2. if A and B are correct, AB is correct,
3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.

Input Format

There will be multiple lines in the input file,
each having a single non-empty string.
You should read input till end-of-file.

The part of the code that handles input operation is already provided in the editor.
Output Format

For each case, print 'true' if the string is balanced, 'false' otherwise.

Sample Input

{}()
({()})
{}(
[]
Sample Output

true
true
false
true
 */
public class Q034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        boolean isBalanced = true;
        while (sc.hasNext()) {
            stack.clear();
            isBalanced = true;
            String input=sc.next();
            input = input.replaceAll("\\s","").trim();
            char arr[] = input.toCharArray();
            for (char w:arr) {
                if (w=='{' || w=='('|| w=='['){
                    stack.push(w);
                }else if (w=='}' || w==')'|| w==']') {
                    if (stack.isEmpty()){
                        isBalanced=false;break;
                    }
                    char poped = stack.pop();
                    if (w=='}' && poped!='{'){
                        isBalanced = false;break;
                    } else if (w==')' && poped!='('){
                        isBalanced = false;break;
                    }else if (w==']' && poped!='['){
                        isBalanced = false;break;
                    }
                }
            }
            if (stack.size()>0){
                isBalanced=false;
            }
            System.out.println(isBalanced);
        }
    }
}
