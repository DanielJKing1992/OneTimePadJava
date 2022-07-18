package onetimepad;
import javax.swing.JOptionPane;
import java.io.*;




public class OneTimePad {
    
    public static void main(String[] args) throws IOException
    {
        
        //ask user to choose between encode and decode
        
        int userChoice;
        do
        {
            userChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of the operation"
                    + " you want to execute:"
                    + "\n     1 - Encode a message"
                    + "\n     2 - Decode a message"
                    + "\n     3 - Quit"));
            while (userChoice != 1 && userChoice != 2 && userChoice != 3)
            {
                JOptionPane.showMessageDialog(null, "You must enter a number "
                        + "between 1 and 3.");
                userChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of the operation"
                    + " you want to execute:"
                    + "\n     1 - Encode a message"
                    + "\n     2 - Decode a message"
                    + "\n     3 - Quit"));
            }
            if (userChoice != 3)
            {
                if (userChoice == 1)
                {
                    cryptMethod.crypt(true);
                }
                
                if (userChoice == 2)
                {
                    cryptMethod.crypt(false);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Thank you for using the program."
                        + "\nPlease remember to secure all data used and produced by"
                        + "\nthis program, and have a nice day.");
            }
        }while (userChoice != 3);
        
    }
}