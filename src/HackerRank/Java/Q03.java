package HackerRank.Java;
import java.util.Scanner;

public class Q03 {
    /*
    * Input Format

There are three lines of input:

The first line contains an integer.
The second line contains a double.
The third line contains a String.
Output Format

There are three lines of output:

On the first line, print String: followed by the unaltered String read from stdin.
On the second line, print Double: followed by the unaltered double read from stdin.
On the third line, print Int: followed by the unaltered integer read from stdin.
    * */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();

        double d = scan.nextDouble();
        //By using following line you can skip unwanted characters from console input
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        /*
        if you dont use skip method then you can use scan.next();

        If you use the nextLine() method immediately following the nextDouble() method,
        recall that nextDouble() reads double tokens;
        because of this, the last newline character for that line of double input is still queued
        in the input buffer and the next nextLine() will be reading
        the remainder of the integer line (which is empty).
        * */
        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
        scan.close();
    }
}
