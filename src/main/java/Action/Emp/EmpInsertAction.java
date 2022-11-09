package Action.Emp;

import Config.MainPanel;
import Config.MinorFrame;
import Config.Neo_Button;
import Config.RemaindLabel;
import lan.pojo.Dept;
import lan.service.DeptService;
import lan.service.SupermarketService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpInsertAction implements ActionListener {

    public static JFrame menuFrame;

    private SupermarketService supermarketService = new SupermarketService();
    private DeptService deptService = new DeptService();

    @Override
    public void actionPerformed(ActionEvent e){

        System.out.println("insert dept info");
        menuFrame = new MinorFrame("添加部门信息");
        JPanel menuPanel = new MainPanel();
        menuPanel.setSize(300,200);

        JTextField supermarketId = new JTextField("请输入所要添加的商场的id");
        supermarketId.setBounds(75,20,150,25);

        Neo_Button btn = new Neo_Button("提交",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.out.println("start searching");

                    menuFrame.dispose();
                    menuFrame = new MinorFrame("查询信息显示");
                    JPanel menuPanel = new MainPanel();
                    menuPanel.setSize(300,200);

                    if(supermarketService.selectById(supermarketId.getText()) != null){

                        System.out.println("start inserting");

                        JTextField deptId = new JTextField("请输入id");
                        deptId.setBounds(50,20,100,25);
                        JTextField deptName = new JTextField("请输入部门名");
                        deptName.setBounds(50,50,100,25);
                        JTextField address = new JTextField("请输入位置");
                        address.setBounds(50,80,100,25);
                        JTextField contactNumber = new JTextField("请输入联系方式");
                        contactNumber.setBounds(50,110,100,25);

                        Neo_Button btn = new Neo_Button("提交", new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    Dept neo_dept = new Dept(deptId.getText(), deptName.getText(), address.getText(), contactNumber.getText(), supermarketId.getText());
                                    neo_dept.setSupermarket(supermarketService.selectById(supermarketId.getText()));
                                    deptService.insert(neo_dept);
                                    menuFrame.dispose();
                                    System.out.println("end inserting");
                                }catch (Exception E){
                                    System.out.println("error inserting");
                                }
                            }
                        });
                        btn.setBounds(170,70,100,50);
                        btn.setFocusPainted(false);

                        menuPanel.add(deptId);
                        menuPanel.add(deptName);
                        menuPanel.add(address);
                        menuPanel.add(contactNumber);
                        menuPanel.add(btn);
                        menuFrame.setContentPane(menuPanel);

                    }
                    else{

                        RemaindLabel errorMessage = new RemaindLabel("该商场不存在");
                        menuPanel.add(errorMessage);
                        menuFrame.setContentPane(menuPanel);
                        System.out.println("error searching");
                    }
                }catch (Exception E){}

            }
        });

        btn.setBounds(100,70,100,50);
        btn.setFocusPainted(false);

        menuPanel.add(supermarketId);
        menuPanel.add(btn);

        menuFrame.setContentPane(menuPanel);
        menuFrame.setLocationRelativeTo(null);


    }

    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }

}
