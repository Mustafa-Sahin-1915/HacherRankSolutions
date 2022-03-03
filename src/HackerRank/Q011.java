package HackerRank;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/*
* The Calendar class is an abstract class that provides methods for converting
* between a specific instant in time and a set of calendar fields such as YEAR, MONTH, DAY_OF_MONTH, HOUR,
* and so on, and for manipulating the calendar fields, such as getting the date of the next week.
*
* You are given a date. You just need to write the method, getDay, which returns the day on that date.
* To simplify your task, we have provided a portion of the code in the editor.
*
* Example
* month = 8
* day = 14
* year 2017
*
* The method should return MONDAY as the day on that date.
Function Description

Complete the findDay function in the editor below.

findDay has the following parameters:

int: month
int: day
int: year
Returns

string: the day of the week in capital letters
* A single line of input containing the space separated month, day and year,
* respectively, in MM DD YYYY   format.
*
* Constraints
* 2000<year<3000

 * */
public class Q011 {
    public static void main(String[] args) throws IOException {
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput =
                bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Q011.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
        08 05 2015
        */
        System.out.println(findDay(8,5,2015));
        //WEDNESDAY
        try {
            cc();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private static void cc() throws ParseException {
        Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse("5/8/2015");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inputDate);
        String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
        System.out.println(dayOfWeek);
    }
    private static String findDay(int month, int day, int year) {
        Date inputDate=null;
        try {
             inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(day+"/"+month+"/"+year);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c1 = GregorianCalendar.getInstance();
        c1.setTime(inputDate);  //January 30th 2000
        String result =null;
        String dayOfWeek = c1.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();

        return dayOfWeek;
    }
    public static String findDay2(int month, int day, int year) {
        Calendar c1 = Calendar.getInstance();
        String dts = month+"/"+day+"/"+year;
        Date dt = null;
        try {
            dt = new SimpleDateFormat("MM/dd/YYYY").parse(dts);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c1.setTime(dt);  //January 30th 2000
        String result =null;
        int dayofweek = c1.get(Calendar.DAY_OF_WEEK);
        switch (dayofweek){
            case Calendar.MONDAY: result="MONDAY";break;
            case Calendar.TUESDAY: result="TUESDAY";break;
            case Calendar.WEDNESDAY: result="WEDNESDAY";break;
            case Calendar.THURSDAY: result="THURSDAY";break;
            case Calendar.FRIDAY: result="FRIDAY";break;
            case Calendar.SATURDAY: result="SATURDAY";break;
            case Calendar.SUNDAY: result="SUNDAY";break;
        }

        return result;
    }
}
