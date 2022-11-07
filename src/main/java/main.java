import javax.swing.*;
import Config.*;
import Action.*;

import java.awt.event.ActionListener;

public class main {

    public static JFrame jFrame;
    public static JPanel jPanel_MainGUI;

    public static void initializeGUI(){
        jFrame = new MainFrame("商场管理系统", 1600, 900);
        jPanel_MainGUI = new MainPanel(1600,900);

        JButton b1 = new Button("test", new AllAction());
        jPanel_MainGUI.add(b1);
        jFrame.add(jPanel_MainGUI);
    }

    public static void main(String[] args){
        initializeGUI();


    }
}
