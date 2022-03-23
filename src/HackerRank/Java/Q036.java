package HackerRank.Java;

import java.util.*;

/*
Java>Data Structures>Java Sort

You are given a list of student information:
ID, FirstName, and CGPA.
Your task is to rearrange them according to their CGPA in decreasing order.
If two student have the same CGPA,
then arrange them according to their first name in alphabetical order. If those two students also have the same first name, then order them according to their ID. No two students have the same ID.

Hint: You can use comparators to sort a list of objects.
See the oracle docs to learn about comparators.
Input Format

The first line of input contains an integer , representing the total number of students.
The next  lines contains a list of student information in the following structure:

ID Name CGPA

Output Format

After rearranging the students according to the above rules, print the first name of each student on a separate line.

Sample Input

5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76
Sample Output

Ashis
Fahim
Samara
Samiha
Rumpa

*/
class Student implements Comparable<Student>{
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student o2) {
        if (o2 == null) {
            return 0;
        }
        if (this.getCgpa() == o2.getCgpa()) {
            return this.getFname().compareTo(o2.getFname());

        } else if (o2.getCgpa() > this.getCgpa()) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class Q036 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);
            testCases--;
        }
        Comparator comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1 == null || o2 == null) {
                    return 0;
                }
                if (o1.getCgpa() == o2.getCgpa()) {
                    return o1.getFname().compareTo(o2.getFname());

                } else if (o2.getCgpa() > o1.getCgpa()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        Collections.sort(studentList);
       // Collections.sort(studentList,comparator);
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
