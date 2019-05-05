/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParkingManagementSystem;

import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ParkingForVisitors extends Drivers{
    
    private static String name = "";
    private static int parkNum = 0;
    private static int idVisitor;
    private static int countPark1 = 5;
    private static int countPark2 = 5;
//    private static int countpark1 = 200;
    private static int numberOfParking = 10;
    
    Drivers vParkZone = new Drivers();
    
    ParkingForVisitors()                           
    {
        nameInput();
        calc(); 
    }
     
    /**
     *
     */
    public void v1()
    {
        JOptionPane.showMessageDialog(null, "Hello It's Car Park " + vParkZone.getParkColor(), "Welcome", JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     *
     * @param vName
     */
    public ParkingForVisitors(String vName)
    {
        super();
        super.setName(vName);//Super Always should be at the top in constructor.
        //takeInput();
        // printOutput();      
    }
    
    /**
     * This is idInput method 
     * It takes idNum input from user
     */       
    public void nameInput()
    {
        name = JOptionPane.showInputDialog("Enter your name: ");
    }//end of idInput
    
    /**
     *
     */
    public void nameOutput()
    {      
        JOptionPane.showMessageDialog(null, "Your name is  " + name + "\nClick OK to get your inputs.", "Your Name", JOptionPane.INFORMATION_MESSAGE);
    }//end of nameOutput
    
    /**
     *
     */
    public final void calc()
    {
        if (idVisitor >= numberOfParking)
        {
//            System.out.println("Sorry parking NOT Available in Green Zone\nTRY in visitor Zone OR red Zone!!!");
            JOptionPane.showMessageDialog(null, "Sorry parking NOT Available in Visitor Zone\nTRY in Green Zone OR red Zone!!!","PARKING NOT AVAILABLE!!", JOptionPane.ERROR_MESSAGE);
            
            vParkZone.chooseParkColor();
        }
        
        if(idVisitor <= numberOfParking)
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
    }//end of calc
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
    }//end of chooseParkingNum
     /**
      * This is park1 method
      * IT gives the information about the available bays in this parking number
      * IF there is no any parking available in this number THEN it will call other method to choose other parking number.
      */
    public final void park1()
    {
        JOptionPane.showMessageDialog(null,countPark1 + "  Bays here!!", " Available parking", JOptionPane.INFORMATION_MESSAGE);

        countPark1--;
            if(countPark1 <= 1)
            {
            JOptionPane.showMessageDialog(null, "Sorry parking not available in this area", "Try Again", JOptionPane.WARNING_MESSAGE);
            chooseParkingNum();
            }
    }//end of park1
    /**
      * This is park2 method
      * IT gives the information about the available bays in this parking number.
      * IF there is no any parking available in this number THEN it will call other method to choose other parking number.
      */
    public final void park2()
    {
        JOptionPane.showMessageDialog(null, countPark2 + "  Bays available here!!", "Available parking",JOptionPane.INFORMATION_MESSAGE);

        countPark2--;
            if(countPark2 <= 1)
            {
                JOptionPane.showMessageDialog(null, "Sorry parking not available in cark park!!" + parkNum, "\nTRY other spot", JOptionPane.WARNING_MESSAGE);
                chooseParkingNum();
            }
    }//end of method park2
   
     /**
     * This is getName method.
     * IT returns the name.
     * @return 
     */
    public String getName()
    {
        return name;
    }  
    /**
     * This is setNewName method
     * @param newName 
     * SET name equal to newName
     */
    public void setName(String newName)
    {
        newName = name;
    } 
      /**
     * This is getParkNum method.
     * IT returns the leftAmount.
     * @return parkNum
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
     * @return countPark1
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
     * @return countPark2
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
