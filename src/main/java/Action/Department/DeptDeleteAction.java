package Action.Department;

import Config.MainPanel;
import Config.MinorFrame;
import Config.Neo_Button;
import Config.RemaindLabel;
import lan.service.DeptService;
import lan.service.SupermarketService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeptDeleteAction implements ActionListener{


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
                    if(deptService.selectById(deleteID.getText())!= null){
                        System.out.println("start dept deleting");
                        deptService.deleteById(deleteID.getText());
                        System.out.println("close dept deleting");
                        menuFrame.dispose();
                    }
                    else{
                        menuFrame.dispose();
                        menuFrame = new MinorFrame("查询结果显示");
                        JPanel menuPanel = new MainPanel();
                        menuPanel.setSize(300,200);
                        RemaindLabel errorMessage = new RemaindLabel("该部门不存在");
                        menuPanel.add(errorMessage);
                        menuFrame.setContentPane(menuPanel);
                        System.out.println("error searching");
                    }

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
