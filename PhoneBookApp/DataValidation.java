package presentation;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.math.BigInteger;


public class DataValidation
{
    public boolean isPresent(JTextComponent c, String title)
    {
        if (c.getText().length() == 0)
        {
            showMessage(c, title + " is a required field.\n");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }
    
    public void showMessage(JTextComponent c, String message)
    {
            JOptionPane.showMessageDialog(c, message, "Invalid Entry",
                JOptionPane.ERROR_MESSAGE);
    }
}