
package ParkingManagementSystem;

import javax.swing.JOptionPane;

public class PaymentSystem extends Drivers
{
    private static int cost = 0;
    private static int amount = 0;
    private static int leftBalance = 0;
    private static String conformation = "";
    private static String amountStr = "";
    
    Drivers pay = new Drivers();
    /**
     * This is an constructor
     * It calls the checkIDnum and leftAmount methods of the same class
     */
    
    PaymentSystem()
    {
        
    }
    
    /**
      * This is checkIdN method.
      * IT let user to confirm their ID number.
      * IF the user input is yes then it will call the recharge method.
      */
     public void checkIdN()
    {
//        JOptionPane.showMessageDialog(null, "Are you sure your id number is " + pay.getId(), "CHECK", JOptionPane.WARNING_MESSAGE);
        conformation = JOptionPane.showInputDialog("Are you sure your id number is " + pay.getIdNum() + "\nTYPE YES/yes if true");      
        if(conformation.equalsIgnoreCase("yes"))
        {
            recharge();
        }        
    }//end of check id
     /**
      * This is a recharge method.
      * IT takes user inputs in String and convert it into the integer.
      * And calculate the total Amount in the given ID number.
      * DISPLAY the total balance in the account.
      */
    public void recharge()
    {
        amountStr = JOptionPane.showInputDialog("Enter your amount to recharge."); 
        amount = Integer.parseInt(amountStr); 
        
        int tAmount = amount + leftBalance;
        JOptionPane.showMessageDialog(null, "Your total balance is " + tAmount, "Total Amount", JOptionPane.WARNING_MESSAGE);
    }//end of recharge
    /**
     * This is leftAmount method.
     * IT calculate the left balance after the parking charge which is $2.
     */
    public void leftAmount()
    {
        leftBalance = amount - 2;
//        JOptionPane.showMessageDialog(null, "Left Amount " + getLeftBalance(), "AMOUNT", JOptionPane.WARNING_MESSAGE);
    }
    /**
     * This is getAmount method.
     *@return amount
     */
    public int getAmount()
    {
      return amount;  
    }
    /**
     * This is setAmount method.
     * @param newAmount 
     * SET newAmount equal to amount
     */
    public void setAmount(int newAmount)
    {
      newAmount = amount;  
    }
    /**
     * This is getLeftBalance method.
     * @return leftAmount.
     */
    public int getLeftBalance()
    {
      return leftBalance;  
    }
    /**
     * This is setLeftBalance method.
     * @param newLeftBalance 
     * SET newLeftBalance equal to leftBalance
     */
    public void setLeftBalance(int newLeftBalance)
    {
      newLeftBalance = leftBalance;  
    }

}//end of class
