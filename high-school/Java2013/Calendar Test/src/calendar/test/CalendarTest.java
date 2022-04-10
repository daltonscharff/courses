/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar.test;
import java.util.*;
import javax.swing.*;
import java.text.*;

/**
 *
 * @author 14dscharff
 */
public class CalendarTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String timeStamp = new SimpleDateFormat("yyyy MM dd_HHmmss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
    }
}
