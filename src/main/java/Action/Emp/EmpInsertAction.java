package Action.Emp;

import Config.MainPanel;
import Config.MinorFrame;
import Config.Neo_Button;
import Config.RemaindLabel;
import lan.pojo.Dept;
import lan.pojo.Emp;
import lan.service.DeptService;
import lan.service.EmpService;
import lan.service.SupermarketService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class EmpInsertAction implements ActionListener {

    public static JFrame menuFrame;

    private DeptService deptService = new DeptService();
    private EmpService empService = new EmpService();

    @Override
    public void actionPerformed(ActionEvent e){

        System.out.println("insert emp info");
        menuFrame = new MinorFrame("添加职工信息");
        JPanel menuPanel = new MainPanel();
        menuPanel.setSize(300,200);

        JTextField deptId = new JTextField("请输入所要添加的部门的id");
        deptId.setBounds(75,20,150,25);

        Neo_Button btn = new Neo_Button("提交",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.out.println("start searching");

                    menuFrame.dispose();
                    menuFrame = new MinorFrame("查询信息显示");
                    JPanel menuPanel = new MainPanel();
                    menuPanel.setSize(300,200);

                    if(deptService.selectById(deptId.getText()) != null){

                        System.out.println("start inserting");

                        JTextField empId = new JTextField("请输入id");
                        empId.setBounds(50,10,100,25);
                        JTextField empName = new JTextField("请输入职工姓名");
                        empName.setBounds(50,40,100,25);
                        JTextField post = new JTextField("请输入住址");
                        post.setBounds(50,70,100,25);
                        JTextField phoneNumber = new JTextField("请输入联系方式");
                        phoneNumber.setBounds(50,100,100,25);
                        JTextField salary = new JTextField("请输入工资");
                        salary.setBounds(50,130,100,25);

                        Neo_Button btn = new Neo_Button("提交", new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    Emp neo_emp = new Emp(empId.getText(), empName.getText(), post.getText(), phoneNumber.getText(), new BigDecimal(salary.getText()), deptId.getText());
                                    neo_emp.setDept(deptService.selectById(deptId.getText()));
                                    empService.insert(neo_emp);
                                    menuFrame.dispose();
                                    System.out.println("end inserting");
                                }catch (Exception E){
                                    System.out.println("error inserting");
                                }
                            }
                        });
                        btn.setBounds(170,70,100,50);
                        btn.setFocusPainted(false);

                        menuPanel.add(empId);
                        menuPanel.add(empName);
                        menuPanel.add(post);
                        menuPanel.add(phoneNumber);
                        menuPanel.add(salary);
                        menuPanel.add(btn);
                        menuFrame.setContentPane(menuPanel);

                    }
                    else{

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

        menuPanel.add(deptId);
        menuPanel.add(btn);

        menuFrame.setContentPane(menuPanel);
        menuFrame.setLocationRelativeTo(null);


    }

    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }

}
