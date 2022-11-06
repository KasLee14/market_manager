package Config.main.java;

import Config.main.java.Action.AllAction;
import Config.main.java.Config.Button;
import Config.main.java.Config.MainFrame;

import javax.swing.*;

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
