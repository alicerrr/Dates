/*****************************************************************************
 * The Dates class receives a day, month and year of a specific date and  
 * calculates the date after a given number of days.
 *****************************************************************************/
package dates;
import java.util.Scanner;
public class Dates 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        
        // declsaration of variables
        int day, month, year, num, numDay, numMonth, numYear; 
        
        //declaration of finals
        final int JAN=1, FEB=2, MAR=3, APR=4, MAY=5, JUN=6, JUL=7, AUG=8, SEP=9, 
            OCT=10, NOV=11, DEC=12;       // months represented by numbers
        final int MIN_MONTH=1, MAX_MONTH=12;  // maximal/minimal month
        final int MIN_DAY=1, MAX_DAY=31;   // maximal/minimal day
        final int MIN_NUM=1, MAX_NUM=10;  //maximal/minimal number entered
                                          //by user 
        
        // gets 3 integers from user that represent day, month and year
        System.out.println("Please enter 3 integers to represent a valid day:");
        day = scan.nextInt();
        month = scan.nextInt();
        year = scan.nextInt();
        
        // the boolean variable checks whether it's a leap year or not
        boolean leapYear = ((year%4==0 && year%100!=0)||(year%100==0 && 
            year%400==0));
        
        // the intetegers taken from user must represent a valid day
        if(year<=0 || month<MIN_MONTH || month>MAX_MONTH || day<MIN_DAY || 
            day>MAX_DAY) { 
            System.out.println("The original date " + day + "/" + month + "/" +
            year + " is invalid.");
        }
        else if((month==APR && day>30)|| (month==JUN && day>30)||
            (month==SEP && day>30) || (month==NOV && day>30)) { 
            System.out.println("The original date " + day + "/" + month + "/" +
            year + " is invalid.");
            }
            // there is 29 days on february in a leap year
            else if(leapYear==true) { 
                if(month==FEB && day>29) {
                    System.out.println("The original date " + day + "/" + month 
                    + "/" + year + " is invalid.");
                    }
                    else {
                        System.out.println("Please enter an integer which "
                        + "represents the number of days:");
                         }
            }
            //There is no 29 days on february in a non-leap year
            else if(leapYear==false) { 
                if(month==FEB && day>28) {
                    System.out.println("The original date " + day + "/" + month 
                    + "/" + year + " is invalid.");
                    }
                else {System.out.println("Please enter an integer which "
                    + "represents the number of days:");
                     }
            }
            
        // if date is valid, system gets a number between 1 to 10 from user.
        else {   
            System.out.println("Please enter an integer which represents the "
            + "number of days:");
            }
        
        num = scan.nextInt();
                    
        //calculation of date after given number of days
        if((month==JAN || month==MAR || month==MAY || month==JUL || 
        month==AUG || month==OCT)&&(day+num>31)) { 
        numDay=(num-(31-day)); 
        numMonth=(month+1); 
        numYear=year;
        }
        else if ((month==DEC)&&(day+num>31)) {
        numDay=(num-(31-day)); 
        numMonth=(month+1); 
        numYear=(year+1);
        }
        else if((month==APR || month==JUN || month==SEP || month==NOV)&&
            (day+num>30)) {
            numDay=(num-(30-day)); // SHAY: Use finals (-3)
            numMonth=(month+1); 
            numYear=year;
            }
            else if(leapYear==true) { 
                if ((month==FEB) && (day+num>29)) {
                numDay=(num-(29-day)); 
                numMonth=(month+1); 
                numYear=year;
                }
                else { 
                    numDay=(day+num); 
                    numMonth=month; 
                    numYear=year;
                }   
            }
            else if(leapYear==false) {
                if ((month==FEB) && (day+num>28)) {
                numDay=(num-(28-day)); 
                numMonth=(month+1); 
                numYear=year;
                }
                else { 
                numDay=(day+num); 
                numMonth=month; 
                numYear=year;
                }   
            }
            else { 
                numDay=(day+num); 
                numMonth=month; 
                numYear=year;
                }

        //what system should print on every case
        if((MIN_NUM<num) && (num<MAX_NUM)) {
            System.out.println("The original date " + day + "/" + month + "/" +
            year + ".");
            System.out.println("After " + num + " days the date is " + numDay +
            "/" + numMonth + "/" + numYear + "."); 
        }
        if(num<MIN_NUM) {
            System.out.println("The number of days must be positive.");
        }
        if(num>MAX_NUM) {
            System.out.println("The number of days must be between 1 to 10.");
        }
        // SHAY: Correct
     } //main
} // class