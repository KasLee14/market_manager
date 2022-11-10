import javax.swing.*;

import Action.Department.DeptInfoAction;
import Action.Emp.EmpInfoAction;
import Action.SuperMarket.SuperMarketInfoAction;
import Config.*;
import Action.*;

public class main {

    static public JFrame jFrame;
    public static JPanel jPanel_MainGUI;

    public static void initializeGUI(){
        jFrame = new MainFrame("主界面");
        jPanel_MainGUI = new MainPanel();

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //

        InitAction.initAction(jFrame);

        Neo_Button b1 = new Neo_Button("商城管理", new SuperMarketInfoAction());
        b1.setBounds(490,280,100,50);
        b1.setFocusPainted(false);

        Neo_Button b2 = new Neo_Button("部门管理", new DeptInfoAction());
        b2.setBounds(490,480,100,50);
        b2.setFocusPainted(false);

        Neo_Button b3 = new Neo_Button("职工管理", new EmpInfoAction());
        b3.setBounds(490,680,100,50);
        b3.setFocusPainted(false);

        jPanel_MainGUI.add(b1);
        jPanel_MainGUI.add(b2);
        jPanel_MainGUI.add(b3);

//        background&title picture
//        ImageIcon title_img = new ImageIcon("G:\\code\\programm_exercising\\market_manager\\src\\main\\java\\pic_source\\title.png");
//        JLabel title = new JLabel(title_img);
//        title.setBounds(0,0,title_img.getIconWidth(), title_img.getIconHeight());
//        jPanel_MainGUI.add(title);
//
//        ImageIcon bg_img = new ImageIcon("G:\\code\\programm_exercising\\market_manager\\src\\main\\java\\pic_source\\background.jpg");
//        JLabel bg = new JLabel(bg_img);
//        bg.setBounds(0,0,bg_img.getIconWidth(), bg_img.getIconHeight());
//        jPanel_MainGUI.add(bg);

        jFrame.setContentPane(jPanel_MainGUI);

    }

    public static void main(String[] args){
        initializeGUI();


    }
}
