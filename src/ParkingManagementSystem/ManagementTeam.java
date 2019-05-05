package ParkingManagementSystem;

// import javax.swing.JOptionPane;

import javax.swing.JOptionPane;


/**
 *
 * @author Rijan Chapagain
 * @date start at 06.03.2019
 * @date End at 03.05.2019
 * @version 1.1.1
 * 
 */

public class ManagementTeam {
    private static int space = 30;

    public ManagementTeam ()//constructor
    {
    }
    
//    public ManagementTeam (space)//constructor
//    {
//        int space = 0;
//    }
    

    public static void main(String[] args)
    {
        Drivers parking = new Drivers();// create object
        
        parking.WelcomeMsg();
        do
        {
            parking.idInput();            
                while(parking.getIdNumber().length() <4 )//|| parking.getIdNumber() == parking.getIdList()
                {
                    JOptionPane.showMessageDialog(null, "ID number should be 4 Integer Number.","ERROR!!",JOptionPane.WARNING_MESSAGE);
                    parking.idInput();                    
                } 
                int id = parking.getSpace();
                id--;
                
            parking.paymentInp(); 
            parking.takeInput();
                while(parking.getCarNumber().length() < 3)
                {
                    JOptionPane.showMessageDialog(null, "Car number should be more than 3 String.", "ERROR!!",JOptionPane.WARNING_MESSAGE);
                    parking.takeInput();
                } 
                space = parking.getSpace();
                space--;
            //parking.    
            parking.chooseParkColor();
            parking.printOutput();
//            parking.date();
            parking.quit();              
        }while(parking.getQuit().equalsIgnoreCase ("yes"));
        
        parking.thankYou();
    }//end of main  
    
    public int getSpace()
    {
      return space;  
    }
}//end of class 