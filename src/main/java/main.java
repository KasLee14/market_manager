import javax.swing.*;
import Config.*;
import Action.*;

import java.awt.event.ActionListener;

public class main {

    public static JFrame jFrame;
    public static JPanel jPanel;

    public static void main(String[] args){

        jFrame = new MainFrame("主界面", 1600, 900);
        AllAction.getJFrame(jFrame);

        JButton b1 = new Button("test", new AllAction());
        jFrame.add(b1);


    }
}
