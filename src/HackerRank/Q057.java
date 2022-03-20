package HackerRank;
/*
"The singleton pattern is a design pattern
that restricts the instantiation of a class to one object.
This is useful when exactly one object is needed to coordinate actions across the system."
Complete the Singleton class in your editor which contains the following components:

A private Singleton non parameterized constructor.

A public String instance variable named str.

Write a static method named getSingleInstance
that returns the single instance of the Singleton class.

Once submitted, our hidden Solution class will check
your code by taking a String as input and then using your Singleton class to print a line.

 */
class Singleton{
    private static Singleton instance = new Singleton();
    public String str;
    private Singleton() {
    }
    public static Singleton getInstance(){
        return instance;
    }
}
public class Q057 {

}
