package ParkingManagementSystem;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class CarParkRed 
{
    private static int parkNum = 0;
    private static int studentNum = 0;
    private static int idRed;
    private static int countPark1 = 5;
    private static int countPark2 = 5;
    //private static int countpark1 = 200;
    private static int numberOfParking = 10;
    
    Scanner input = new Scanner(System.in);
    Drivers parkZone = new Drivers();
     /**
      * This is a constructor
      * It creates allocation for a memory
      */
    public CarParkRed()//Constructor always have same name as the class                           
    {
        welcomeRed();
        calc(); 
    }
     /**
      * This is welcomeRed method
      * It welcome the user to the car park Red by welcome message
      */
    public final void welcomeRed()
    {
        JOptionPane.showMessageDialog(null, "Hello It's Car Park " + parkZone.getParkColor(), "Welcome",JOptionPane.INFORMATION_MESSAGE);
    }
    /**
      * This is calc method
      * It calculate the number of parking,in Red zone
      * including park1 and park2
      * ALSO check the available parking bays
      */
    public final void calc()
    {
        if (idRed >= numberOfParking)
        {
            JOptionPane.showMessageDialog(null, "Sorry parking NOT Available in Red Zone\nTRY in visitor Zone OR Green Zone!!!",
                    "PARKING NOT AVAILABLE!!", JOptionPane.ERROR_MESSAGE);
            
            parkZone.chooseParkColor();
        }
        
        if(idRed <= numberOfParking)
        {
            chooseParkingNum();
            
            if(parkNum == 1)
            {
                park1();
            }
                    
            if(parkNum == 2)
            {
                park2();   
            }
        numberOfParking--;            
        }    
    }
    /**
      * This is chooseParkingNum method
      * IT let user to choose parking number 
      * AND check if user input is correct or wrong
      * IF wrong THEN it will it will throw an exception
      */
    public final void chooseParkingNum()
    {
        try
        {
            while(parkNum != 1 && parkNum != 2)
            {
            String parkNumber = JOptionPane.showInputDialog("Choose a parking number 1 & 2.");      
            parkNum = Integer.parseInt(parkNumber);
            
            if(parkNum != 1 && parkNum != 2)
            {
                throw new Exception("Park number should be Either 1 or 2.");                
            }
            }
        }      
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR!!", JOptionPane.ERROR_MESSAGE);
        }     
    }
     /**
      * This is park1 method
      * IT gives the information about the available bays in this parking number
      * IF there is no any parking available in this number THEN it will call other method to choose other parking number.
      */
    public final void park1()
    {
        JOptionPane.showMessageDialog(null,countPark1 + " parking available here!!", " Available parking", JOptionPane.INFORMATION_MESSAGE);

        countPark1--;
            if(countPark1 <= 1)
            {
            JOptionPane.showMessageDialog(null, "Sorry parking not available in this area", "Try Again", JOptionPane.WARNING_MESSAGE);
            System.out.println();
            chooseParkingNum();
            }           
    }
    /**
      * This is park2 method
      * IT gives the information about the available bays in this parking number.
      * IF there is no any parking available in this number THEN it will call other method to choose other parking number.
      */
    public final void park2()
    {
//        System.out.println("You have got " + countPark2 + " parking here.");
        JOptionPane.showMessageDialog(null, countPark2 + "You have got ", "Available parking",JOptionPane.INFORMATION_MESSAGE);

        countPark2--;
            if(countPark2 <= 1)
            {
                JOptionPane.showMessageDialog(null, "Sorry parking not available in cark park" + parkNum, "\nTRY other spot", JOptionPane.WARNING_MESSAGE);
                //System.out.println("Sorry parking not available in cark park" + parkNum + "\nTRY other spot");
                System.out.println();
                chooseParkingNum();
            }
    }//end of park 2
    
    /**
     * This is getParkNum method.
     * IT returns the leftAmount.
     */
    public int getParkNum()
    {
        return parkNum;
    }  
    /**
     * This is setParkNum method
     * @param newParkNum 
     * SET parkNum equal to newParkNum
     */
    public void setParkNum(int newParkNum)
    {
        newParkNum = parkNum;
    }  
     /**
     * This is getCountPark1 method.
     * IT returns the countPark1.
     */
     public int getCountPark1()
    {
        return countPark1;
    }
     /**
     * This is setCountPark1 method
     * @param newCountPark1 
     * SET newCountPark1 equal to countPark1
     */
     public void setCountPark1(int newCountPark1)
    {
        newCountPark1 = countPark1;
    }
      /**
     * This is getCountPark2 method.
     * IT returns the countPark2.
     */
    public int getCountPark2()
    {
        return countPark2;
    }
     /**
     * This is setCountPark2 method
     * @param newCountPark2 
     * SET newCountPark2 equal to countPark2
     */
     public void setCountPark2(int newCountPark2)
    {
        newCountPark2 = countPark2;
    }
}//end of class
