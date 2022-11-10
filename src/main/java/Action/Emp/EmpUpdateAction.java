package Action.Emp;

import Config.MainPanel;
import Config.MinorFrame;
import Config.Neo_Button;
import Config.RemaindLabel;
import lan.pojo.Dept;
import lan.pojo.Emp;
import lan.service.DeptService;
import lan.service.EmpService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class EmpUpdateAction implements ActionListener {

    public static JFrame menuFrame;
    private EmpService empService = new EmpService();

    @Override
    public void actionPerformed(ActionEvent e){

        System.out.println("update dept info");
        menuFrame = new MinorFrame("职工信息更新界面");
        JPanel menuPanel = new MainPanel();
        menuPanel.setSize(300,200);

        JTextField SearchID = new JTextField("请输入要修改的职工的id");
        SearchID.setBounds(75,20,150,25);
        Neo_Button btn = new Neo_Button("提交",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.out.println("start updating");

                    Emp SearchObject = empService.selectById(SearchID.getText());

                    if(empService.selectById(SearchID.getText()) != null){

                        menuFrame.dispose();
                        menuFrame = new MinorFrame("查询信息显示");
                        JPanel menuPanel = new MainPanel();
                        menuPanel.setSize(300,200);

                        JTextField empName = new JTextField("请输入新姓名");
                        empName.setBounds(50,20,100,25);
                        JTextField post = new JTextField("请输入新住址");
                        post.setBounds(50,50,100,25);
                        JTextField phoneNumber = new JTextField("请输入新联系方式");
                        phoneNumber.setBounds(50,80,100,25);
                        JTextField salary = new JTextField("请输入新工资");
                        salary.setBounds(50,110,100,25);

                        Neo_Button btn = new Neo_Button("提交", new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    Emp neo_emp = new Emp(SearchObject.getEmpId(), empName.getText(), post.getText(), phoneNumber.getText(), new BigDecimal(salary.getText()), SearchObject.getDeptId());
                                    empService.update(neo_emp);
                                    menuFrame.dispose();
                                }catch (Exception E){}
                            }
                        });
                        btn.setBounds(100,70,100,50);
                        btn.setFocusPainted(false);

                        menuPanel.add(empName);
                        menuPanel.add(post);
                        menuPanel.add(phoneNumber);
                        menuPanel.add(salary);
                        menuPanel.add(btn);
                        menuFrame.setContentPane(menuPanel);


                    }
                    else{
                        menuFrame.dispose();
                        menuFrame = new MinorFrame("查询结果显示");
                        JPanel menuPanel = new MainPanel();
                        menuPanel.setSize(300,200);
                        RemaindLabel errorMessage = new RemaindLabel("该职工不存在");
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
