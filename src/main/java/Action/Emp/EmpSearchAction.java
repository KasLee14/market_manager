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

public class EmpSearchAction implements ActionListener {

    public static JFrame menuFrame;
    private EmpService empService = new EmpService();
    private JTable show_info;

    @Override
    public void actionPerformed(ActionEvent e){

        System.out.println("search emp info");
        menuFrame = new MinorFrame("职工查询界面");
        JPanel menuPanel = new MainPanel();
        menuPanel.setSize(300,200);

        JTextField SearchID = new JTextField("请输入要查找的职工的id");
        SearchID.setBounds(75,20,150,25);
        Neo_Button btn = new Neo_Button("提交",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.out.println("start searching");

                    menuFrame.dispose();
                    menuFrame = new MinorFrame("查询信息显示");;
                    JPanel menuPanel = new MainPanel();
                    menuPanel.setSize(600,300);

                    Emp SearchObject = empService.selectById(SearchID.getText());

                    if(empService.selectById(SearchID.getText()) != null){

                        menuFrame.setSize(600,300);
                        Object[][] rowData = new Object[1][6];
                        rowData[0][0] = SearchObject.getEmpId();
                        rowData[0][1] = SearchObject.getEmpName();
                        rowData[0][2] = SearchObject.getPost();
                        rowData[0][3] = SearchObject.getPhoneNumber();
                        rowData[0][4] = SearchObject.getSalary();
                        rowData[0][5] = SearchObject.getDeptId();
                        Object[] columnNames = {"EmpId", "EmpName", "Post", "PhoneNumber", "Salary", "DeptID"};
                        show_info = new JTable(rowData,columnNames);

//        show_info.setBackground(Color.white);
                        JScrollPane scroll = new JScrollPane(show_info);
                        scroll.setBounds(0, 0, 600, 200);

                        System.out.println("close searching");

                        menuPanel.add(scroll);
                        menuFrame.setContentPane(menuPanel);
                    }
                    else{
                        RemaindLabel errorMessage = new RemaindLabel("该职工不存在");
                        menuPanel.add(errorMessage);
                        menuFrame.setContentPane(menuPanel);
                        System.out.println("error searching");
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
