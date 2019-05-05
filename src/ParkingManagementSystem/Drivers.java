package ParkingManagementSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

/**
 * @author Rijan Chp
 * @date started at 06.03.2019
 */

public class Drivers extends ManagementTeam{
    //attributes of a Drivers
    //private String name;
    
    private static String carNumber;
    private static String parkColor;
    private static String quit;
    private static int carParkNum;

    /**
     *
     */
    public static int num = 0;//static can be used by this class only
    private static int idNum = 0;
    private static int idList ;
    //private static int space = 20;
    private static int id = 0;
    private static String visitorName = "";
    private static String todayAsString = "";
    private static String idNumber = "";
    private static String payment = "";
    private static boolean flag = true;    
    private static String displayBay = "";
    
    CarParkGreen green; //  = new CarParkGreen();
    CarParkRed red;
    ParkingForVisitors visitor;
    PaymentSystem pay;
    
//    Joption jop =  new Joption(carNumber);
    
    Scanner input = new Scanner(System.in);
    
    /**
     * this is a first constructor
     * @param carN 
     * It make the value of carN equal to carNumber
     */
    public Drivers(String carN) 
    {
        carN = carNumber;          
    }
    
    Drivers()//Default constructor
    {
        
    }    
   
//    Drivers(space)
//    {
//        
//    }
    
    /**
     * This is a readLine method which reads the file in ARRAY
     * And extract information of the file
     * ALSO if the file is not found then it will throw file not found exception
     */ 
    public void readLine() 
    {
        try 
        {
            File file = new File("D:\\parking.txt");
            FileReader fileReader = new FileReader(file);
            StringBuffer stringBuffer = new StringBuffer();
            int numCharsRead;
            char[] charArray = new char[1024];
            while ((numCharsRead = fileReader.read(charArray)) > 0) 
            {
                stringBuffer.append(charArray, 0, numCharsRead);
            }

            fileReader.close();
            JOptionPane.showMessageDialog(null, "\t\t" + stringBuffer.toString(), "Contents of file:", JOptionPane.INFORMATION_MESSAGE);

          String idS = stringBuffer.toString();
           idList = Integer.parseInt(idS);;
        } 
        
        catch (IOException e) 
        {
            System.out.println("File not found Exception!!");
        }
    }
    
    /**
     *
     */
    public void WelcomeMsg()
    {
        JOptionPane.showMessageDialog(null, "***Welcome to parking Management System.***\n" +
                "You must have a Murdoch Card number to park in red and Green Zone.", "Welcome", JOptionPane.PLAIN_MESSAGE);
    }
    /**
     * This is idInput method 
     * It takes idNum input from user 
     */       
    public void idInput()
    {
        idNumber = JOptionPane.showInputDialog("Your ID number must have 4 Integer Number.\nEnter your ID number: ");      
        idNum = Integer.parseInt(idNumber); 

    }//end of idInput
     
    /**
     *This is paymentInp method.
     * IT READS user input from user.
     * IF user input is yes then CALL a constructor of class payment system.
     */
    public void paymentInp()
    {
        payment = JOptionPane.showInputDialog("Do you want to go to payment setting or not.\nType yes/YES to go and any key to continue.");
        if(payment.equalsIgnoreCase("yes"))
        {
            pay = new PaymentSystem();
            pay.checkIdN();
            pay.leftAmount();
            
        }
        else 
        {
            pay = new PaymentSystem();
        }
    }
    
//    public boolean checkId()
//    {
//        if (idList == idNum)
//        {
//            flag = true;
//        }
//        else
//        {
//            flag = false;
//        }
//        return flag;
//    }

    /**
     *
     * @return
     */
    
    public int getIdList()
    {
        return idList;
    }
    
    /**
      * This is takeInput method 
      * It takes carNumber input from user
      */         
    public final void takeInput()
    {
        carNumber = JOptionPane.showInputDialog("Enter your Car number: ");
    }//end of takeinput
    
    
    /*  After taking the car number check if that car number has got any parking permit or not!!
        This needs to take data from database of parking permit.
    */
    /**
      * This is chooseParkColor method 
      * User can choose parking zone color from here
      * THEN this method call the relevant parking zone color method
      */ 
    public final void chooseParkColor()
    {
        parkColor = JOptionPane.showInputDialog("Enter your parking Zone color (green, red or visitor): ");

        if(parkColor.equalsIgnoreCase("green"))
        {
            green = new CarParkGreen();
        } 
        else if(parkColor.equalsIgnoreCase("red"))
        {
            red = new CarParkRed();
        } 
        else if(parkColor.equalsIgnoreCase("visitor"))
        {
            visitor = new ParkingForVisitors();
        } 
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid park color.\nPark color should be Green, Red OR Visitor", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            chooseParkColor();
        }         
          
    }//end of choose park color
    
  
   
    /**
      * This is date method 
      * It extract the time of parking by the driver with date
      * AND output the RESULT
      */ 
    public void date()
    {
        String pattern = "HH:mm:ss";
        // Create an instance of SimpleDateFormat used for formatting 
        // the string representation of date according to the chosen pattern
        DateFormat df = new SimpleDateFormat(pattern);

        // Get the today date using Calendar object.
        Date today = Calendar.getInstance().getTime();        
        // Using DateFormat format method we can create a string 
        // representation of a date with the defined format.
        todayAsString = df.format(today); 
               
//        JOptionPane.showMessageDialog (null, "You've parked your car at: " + todayAsString,  "Parking TIME", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     *
     */
    public void printOutput()
    {
        date();
        equal();
               
        JOptionPane.showMessageDialog(null, "Your parking zone color is:  " + parkColor + 
                "\nYour Car number is:  " + carNumber +  
                "\nYour parking number is:  " + displayBay +
                "\nYour ID number is:  " + idNumber +
                "\nLeft Balance:  " + this.pay.getLeftBalance() +           
                "\nParking TIME:  "+ todayAsString + 
                "", "Your Inputs", JOptionPane.INFORMATION_MESSAGE);       
    }//end of print output
    /**
      * This is printOutput method 
      * It prints the User Inputs
      */   
    public final void equal()
    {
        if(parkColor.equalsIgnoreCase("visitor"))
        {
            visitor.nameOutput();
        }
        
        if(parkColor.equalsIgnoreCase("green"))
        {
            if(green.getParkNum() == 1)
                displayBay = "GP " + Integer.toString(green.getCountPark1()); 
            if(green.getParkNum() == 2)
                displayBay = "GP " + Integer.toString(green.getCountPark2()); 
        }
        if(parkColor.equalsIgnoreCase("red"))
        {
            if(red.getParkNum() == 1)
                displayBay = "RP " + Integer.toString(red.getCountPark1()); 
            if(red.getParkNum() == 2)
                displayBay = "RP " + Integer.toString(red.getCountPark2());        
        }
        if(parkColor.equalsIgnoreCase("visitor"))
        {
            if(visitor.getParkNum() == 1)
                displayBay = "VP " + Integer.toString(visitor.getCountPark1()); 
            if(green.getParkNum() == 2)
                displayBay = "VP " + Integer.toString(visitor.getCountPark2());        
        }
    }//end of printOutput
    /**
      * This is quit method 
      * It ask user either they wish to continue or quite
      */     
    public void quit()
    {
        quit = JOptionPane.showInputDialog("Press any key to quite and  YES/yes  to continue");
    }
     /**
      * This is thankYou method 
      * It greets user by thank you.
      */
    public void thankYou()
    {
        JOptionPane.showMessageDialog(null, "***THANK YOU, have a good time***", "Thank you", JOptionPane.PLAIN_MESSAGE); 
    }
    /**
     * This is getter
     * @return quite
     */
    public String getQuit()
    {
        return quit;
    }
     /**
     * This is getter
     * @return carNumber
     */
    public String getCarNumber()
    {
        return carNumber;
    }
     /**
     * This is getter
     * @return parkColor
     */ 
    public String getParkColor()
    {
        return parkColor;
    }
     /**
     * This is getter
     * @return carParkNum
     */ 
    public int getCarParkNum()
    {
        return carParkNum;
    }
     
    /**
     *This is setCarNUmber method.
     * @param newCarNumber
     * It SET carNumber equal to NewCarNumber.
     */
    public void setCarNumber(String newCarNumber)
    {
        carNumber = newCarNumber; 
    }
    
    /**
     *
     * @param newName
     */
    public void setName(String newName)
    {
        visitorName = newName; 
    }
    /**
     * This is getter
     * @return visitorName
     */
    public String getName()
    {
        return visitorName; 
    }
    
    /**
     *
     * @param newId
     */
    public void setId(int newId)
    {
        idNum = newId; 
    }
    /**
     * This is getter
     * @param newIdNum
     */
   
    public void setIdNum(int newIdNum)
    {
        idNum = newIdNum; 
    }
    /**
     * This is getter
     * @return idNum
     */
    public String getIdNumber()
    {
        return idNumber; 
    }
    /**
     * This is getter
     * @return todayAsString
     */
    public String getTodayAsString()
    {
        return todayAsString; 
    }   
    /**
     *This is getIdNum method
     * @return idNum
     */
    public int getIdNum()
    {
        return idNum; 
    }    
    /**
     *This is setTodayAsString method
     * @param newTime
     */
    public void setTodayAsString(String newTime)
    {
        todayAsString = newTime; 
    } 
}//end of class
