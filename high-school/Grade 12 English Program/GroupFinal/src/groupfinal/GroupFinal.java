
package groupfinal;
import javax.swing.JFrame;
/**
 * @authors WangMan, SourMilkInABagWhoFeelsSunlightInHisPores, DWhatDScharff, TinyYimms, Ctrl-AltHouse, DowntownGageBrown, TwoSecondFinish
 */
public class GroupFinal {

    public static void main(String[] args) {
        Window gui = new Window();
        gui.setTitle("Tic-Tac-Toe");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setResizable(false);
        gui.setSize(640,480);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
}
