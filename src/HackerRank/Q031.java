package HackerRank;

import java.util.Scanner;

/*
Java>Data Structures>Java 1D Array (Part 2)
Let's play a game on an array!
You're standing at index  of 0 an n-element array named game.
From some index i (where 0<=i<n), you can perform one of the following moves:
-Move Backward: If cell i-1 exists and contains a 0, you can walk back to cell i-1.
-Move Forward:
->If cell i+1 contains a zero, you can walk to cell i+1.
->If cell i+leap contains a zero, you can jump to cell i+leap.
->If you're standing in cell n-1 or the value of i+leap>=n,
you can walk or jump off the end of the array and win the game.

In other words, you can move from index i to index i+1,i-1, or i+leap
as long as the destination index is a cell containing a 0.
If the destination index is greater than n-1, you win the game.

Function Description

Complete the canWin function in the editor below.

canWin has the following parameters:

int leap: the size of the leap
int game[n]: the array to traverse

Returns

boolean: true if the game can be won, otherwise false

Input Format

The first line contains an integer, q, denoting the number of queries (i.e., function calls).
The 2*q subsequent lines describe each query over two lines:
->The first line contains two space-separated integers
    describing the respective values of n and leap .
->The second line contains n space-separated binary integers
(i.e., zeroes and ones) describing the
respective values of game[0],game[1]...game[n-1].
Sample Input

STDIN           Function
-----           --------
4               q = 4 (number of queries)
5 3             game[] size n = 5, leap = 3 (first query)
0 0 0 0 0       game = [0, 0, 0, 0, 0]
6 5             game[] size n = 6, leap = 5 (second query)
0 0 0 1 1 1     . . .
6 3
0 0 1 1 1 0
3 1
0 1 0

Sample OUTput
YES
YES
NO
NO
 */
public class Q031 {

   public static boolean canWin(int leap, int[] game){
       return isPathAvailable(leap, game, 0);
   }
   public static boolean isPathAvailable(int leap,int[] game,int loc){
       if (loc<0 || game[loc]!=0) {
           return false;
       }
       if (loc ==game.length-1 || (loc+leap)>game.length-1){
           return true;
       }
       game[loc] = 1;//it is being checked and cancels backward with 3
       if (isPathAvailable(leap,game,loc+1)){ //1:jump forward by 1
           return true;
       }
       if (isPathAvailable(leap,game,loc+leap)){ //2:jump forward by leap
           return true;
       }
       if (isPathAvailable(leap,game,loc-1)){ //3:jump backward by 1
           return true;
       }
       game[loc] = 0;
       return false;
   }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
