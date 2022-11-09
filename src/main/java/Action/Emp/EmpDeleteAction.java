package Action.Emp;

import Config.MainPanel;
import Config.MinorFrame;
import Config.Neo_Button;
import lan.service.DeptService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpDeleteAction implements ActionListener{


    public static JFrame menuFrame;
    private DeptService deptService = new DeptService();

    @Override
    public void actionPerformed(ActionEvent e){

        menuFrame = new MinorFrame("删除部门信息");

        JPanel menuPanel = new MainPanel();
        menuPanel.setSize(300,200);

        JTextField deleteID = new JTextField("请输入要删除的部门的id");
        deleteID.setBounds(75,20,150,25);
        Neo_Button btn = new Neo_Button("提交",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.out.println("start dept deleting");
                    deptService.deleteById(deleteID.getText());
                    System.out.println("close dept deleting");
                    menuFrame.dispose();
                }catch (Exception E){}

            }
        });
        btn.setBounds(100,70,100,50);
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
