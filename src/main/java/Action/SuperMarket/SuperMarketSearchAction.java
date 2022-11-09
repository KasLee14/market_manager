package Action.SuperMarket;

import Config.*;
import lan.pojo.Supermarket;
import lan.service.SupermarketService;
import org.apache.ibatis.jdbc.Null;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperMarketSearchAction implements ActionListener {

    public static JFrame menuFrame;
    private SupermarketService supermarketService = new SupermarketService();
    private JTable show_info;

    @Override
    public void actionPerformed(ActionEvent e){

        System.out.println("search market info");
        menuFrame = new MinorFrame("商场查询界面");
        JPanel menuPanel = new MainPanel();
        menuPanel.setSize(300,200);

        JTextField SearchID = new JTextField("请输入要查找的商场的id");
        SearchID.setBounds(75,20,150,25);
        Neo_Button btn = new Neo_Button("提交",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.out.println("start searching");

                    menuFrame.dispose();
                    menuFrame = new MinorFrame("查询信息显示");
                    JPanel menuPanel = new MainPanel();
                    menuPanel.setSize(600,200);

                    Supermarket SearchObject = supermarketService.selectById(SearchID.getText());

                    if(supermarketService.selectById(SearchID.getText()) != null){

                        menuFrame.setSize(600,300);
                        Object[][] rowData = new Object[1][4];
                        rowData[0][0] = SearchObject.getSupermarketId();
                        rowData[0][1] = SearchObject.getSupermarketName();
                        rowData[0][2] = SearchObject.getAddress();
                        rowData[0][3] = SearchObject.getContactNumber();
                        Object[] columnNames = {"SupermarketId", "SupermarketName", "Address", "ContactNumber"};
                        show_info = new JTable(rowData,columnNames);

//        show_info.setBackground(Color.white);
                        JScrollPane scroll = new JScrollPane(show_info);
                        scroll.setBounds(0, 0, 600, 200);

                        System.out.println("close searching");

                        menuPanel.add(scroll);
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

        menuPanel.add(SearchID);
        menuPanel.add(btn);

        menuFrame.setContentPane(menuPanel);
        menuFrame.setLocationRelativeTo(null);

    }

    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }

}
