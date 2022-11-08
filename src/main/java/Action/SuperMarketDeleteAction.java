package Action;

import Config.MainFrame;
import Config.MainPanel;
import Config.Neo_Button;
import lan.pojo.Supermarket;
import lan.service.SupermarketService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperMarketDeleteAction implements ActionListener{


    public static JFrame menuFrame;

    @Override
    public void actionPerformed(ActionEvent e){

        menuFrame = new MainFrame("删除商场信息");
        menuFrame.setSize(300,200);
        JPanel menuPanel = new MainPanel();
        menuPanel.setSize(300,200);

        JTextField deleteID = new JTextField("请输入要删除的商场的id");
        deleteID.setBounds(50,20,100,25);
        Neo_Button btn = new Neo_Button("提交",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.out.println("start insert");
                    SupermarketService.deleteById(deleteID.getText());
                    System.out.println("close insert");
                    menuFrame.dispose();
                }catch (Exception E){}

            }
        });
        btn.setBounds(180,50,100,50);
        btn.setFocusPainted(false);

        menuPanel.add(deleteID);
        menuPanel.add(btn);

        menuFrame.setContentPane(menuPanel);
        menuFrame.setLocationRelativeTo(null);


    }

    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }

}
