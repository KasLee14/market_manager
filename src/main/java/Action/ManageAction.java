package Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageAction implements ActionListener {

    public static JFrame menuFrame;

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("management");
    }

    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }
}
