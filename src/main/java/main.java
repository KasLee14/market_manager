import javax.swing.*;
import Config.*;
import Action.*;

import java.awt.event.ActionListener;

public class main {

    static public JFrame jFrame;
    public static JPanel jPanel_MainGUI;

    public static void initializeGUI(){
        jFrame = new MainFrame("商场管理系统", 960, 400);
        jPanel_MainGUI = new MainPanel(1600,900);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //点击×后直接退出运行

        AllAction.getJFrame(jFrame);
        ManageAction.getJFrame(jFrame);

        Neo_Button b1 = new Neo_Button("商场信息", new AllAction());
        b1.setBounds(200,100,100,50);
        b1.setFocusPainted(false);  //去掉按钮上的焦圈

        Neo_Button b2 = new Neo_Button("后台管理", new ManageAction());
        b2.setBounds(200,200,100,50);
        b2.setFocusPainted(false);

        jPanel_MainGUI.add(b1);
        jPanel_MainGUI.add(b2);

        jFrame.setContentPane(jPanel_MainGUI);

    }

    public static void main(String[] args){
        initializeGUI();


    }
}
