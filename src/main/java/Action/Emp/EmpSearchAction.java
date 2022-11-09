package Action.Emp;

import Config.MainPanel;
import Config.MinorFrame;
import Config.Neo_Button;
import Config.RemaindLabel;
import lan.pojo.Dept;
import lan.service.DeptService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpSearchAction implements ActionListener {

    public static JFrame menuFrame;
    private DeptService deptService = new DeptService();
    private JTable show_info;

    @Override
    public void actionPerformed(ActionEvent e){

        System.out.println("search dept info");
        menuFrame = new MinorFrame("部门查询界面");
        JPanel menuPanel = new MainPanel();
        menuPanel.setSize(300,200);

        JTextField SearchID = new JTextField("请输入要查找的部门的id");
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

                    Dept SearchObject = deptService.selectById(SearchID.getText());

                    if(deptService.selectById(SearchID.getText()) != null){

                        menuFrame.setSize(600,300);
                        Object[][] rowData = new Object[1][5];
                        rowData[0][0] = SearchObject.getDeptId();
                        rowData[0][1] = SearchObject.getDeptName();
                        rowData[0][2] = SearchObject.getAddress();
                        rowData[0][3] = SearchObject.getContactNumber();
                        rowData[0][4] = SearchObject.getSupermarketId();
                        Object[] columnNames = {"DeptId", "DepttName", "Address", "ContactNumber", "SupermarketId"};
                        show_info = new JTable(rowData,columnNames);

//        show_info.setBackground(Color.white);
                        JScrollPane scroll = new JScrollPane(show_info);
                        scroll.setBounds(0, 0, 600, 200);

                        System.out.println("close searching");

                        menuPanel.add(scroll);
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

        menuPanel.add(SearchID);
        menuPanel.add(btn);

        menuFrame.setContentPane(menuPanel);
        menuFrame.setLocationRelativeTo(null);

    }

    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }

}
