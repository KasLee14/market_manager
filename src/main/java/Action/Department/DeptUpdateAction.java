package Action.Department;

import Config.MainPanel;
import Config.MinorFrame;
import Config.Neo_Button;
import Config.RemaindLabel;
import lan.pojo.Dept;
import lan.pojo.Supermarket;
import lan.service.DeptService;
import lan.service.SupermarketService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeptUpdateAction implements ActionListener {

    public static JFrame menuFrame;
    private DeptService deptService = new DeptService();

    @Override
    public void actionPerformed(ActionEvent e){

        System.out.println("update dept info");
        menuFrame = new MinorFrame("部门信息更新界面");
        JPanel menuPanel = new MainPanel();
        menuPanel.setSize(300,200);

        JTextField SearchID = new JTextField("请输入要修改的部门的id");
        SearchID.setBounds(75,20,150,25);
        Neo_Button btn = new Neo_Button("提交",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.out.println("start updating");

                    Dept SearchObject = deptService.selectById(SearchID.getText());

                    if(deptService.selectById(SearchID.getText()) != null){

                        menuFrame.dispose();
                        menuFrame = new MinorFrame("查询信息显示");
                        JPanel menuPanel = new MainPanel();
                        menuPanel.setSize(300,200);

                        JTextField supermarketName = new JTextField("请输入新部门名");
                        supermarketName.setBounds(50,50,100,25);
                        JTextField address = new JTextField("请输入新地点");
                        address.setBounds(50,80,100,25);
                        JTextField contactNumber = new JTextField("请输入新联系方式");
                        contactNumber.setBounds(50,110,100,25);

                        Neo_Button btn = new Neo_Button("提交", new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    Dept neo_dept = new Dept(SearchObject.getDeptId(), supermarketName.getText(), address.getText(), contactNumber.getText(),SearchObject.getSupermarketId());
                                    deptService.update(neo_dept);
                                    menuFrame.dispose();
                                }catch (Exception E){}
                            }
                        });
                        btn.setBounds(170,70,100,50);
                        btn.setFocusPainted(false);

                        menuPanel.add(supermarketName);
                        menuPanel.add(address);
                        menuPanel.add(contactNumber);
                        menuPanel.add(btn);
                        menuFrame.setContentPane(menuPanel);


                    }
                    else{
                        RemaindLabel errorMessage = new RemaindLabel("该商场不存在");
                        menuPanel.add(errorMessage);
                        menuFrame.setContentPane(menuPanel);
                        System.out.println("error updating");
                    }

                }catch (Exception E){}

            }
        });
        btn.setBounds(100,70,100,50);
        btn.setFocusPainted(false);

        menuPanel.add(SearchID);
        menuPanel.add(btn);

        menuFrame.setContentPane(menuPanel);
        menuFrame.setLocationRelativeTo(null);

    }

    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }


}
