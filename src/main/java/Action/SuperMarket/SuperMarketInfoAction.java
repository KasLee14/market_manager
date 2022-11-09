package Action.SuperMarket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Config.*;
import lan.pojo.Supermarket;
import lan.service.SupermarketService;

public class SuperMarketInfoAction implements ActionListener{

    public static JFrame menuFrame;
    private JTable show_info;

    private SupermarketService supermarketService = new SupermarketService();//想了想还是不要用静态类，先实例化再用
    @Override
    public void actionPerformed(ActionEvent e){

        System.out.println("market info");
        menuFrame = new MainFrame("商场管理界面");
        JPanel menuPanel = new MainPanel();

        List<Supermarket> supermarkets = supermarketService.selectAll();


        // 表格所有行数据
        Object[][] rowData = new Object[supermarkets.size()][];
        for(int i = 0; i < supermarkets.size(); i++){
            Object[]temp = new Object[4];
            Supermarket supermarket = supermarkets.get(i);
            temp[0] = supermarket.getSupermarketId();
            temp[1] = supermarket.getSupermarketName();
            temp[2] = supermarket.getAddress();
            temp[3] = supermarket.getContactNumber();
            rowData[i] = temp;
        }
        Object[] columnNames = {"SupermarketId", "SupermarketName", "Address", "ContactNumber"};
        show_info = new JTable(rowData,columnNames);

//        show_info.setBackground(Color.white);
        JScrollPane scroll = new JScrollPane(show_info);
        scroll.setBounds(0, 200, 1080, 400);
        menuPanel.add(scroll);
//        menuPanel.add(show_info.getTableHeader(), BorderLayout.NORTH);
//        menuPanel.add(show_info, BorderLayout.CENTER);

        //background&title picture
//        ImageIcon bg_img = new ImageIcon("G:\\code\\programm_exercising\\market_manager\\src\\main\\java\\pic_source\\background.jpg");
//        JLabel bg = new JLabel(bg_img);
//        bg.setBounds(0,0,bg_img.getIconWidth(), bg_img.getIconHeight());
//        menuPanel.add(bg);

        Neo_Button b1 = new Neo_Button("增加商场信息", new SuperMarketInsertAction());
        b1.setBounds(25,100,150,50);
        b1.setFocusPainted(false);
        menuPanel.add(b1);

        Neo_Button b2 = new Neo_Button("删除商场信息", new SuperMarketDeleteAction());
        b2.setBounds(200,100,150,50);
        b2.setFocusPainted(false);
        menuPanel.add(b2);

        //刷新界面
        Neo_Button b3 = new Neo_Button("刷新", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel.remove(show_info);
                menuPanel.remove(scroll);
                List<Supermarket> supermarkets = supermarketService.selectAll();


                // 表格所有行数据
                Object[][] rowData = new Object[supermarkets.size()][];
                for(int i = 0; i < supermarkets.size(); i++){
                    Object[]temp = new Object[4];
                    Supermarket supermarket = supermarkets.get(i);
                    temp[0] = supermarket.getSupermarketId();
                    temp[1] = supermarket.getSupermarketName();
                    temp[2] = supermarket.getAddress();
                    temp[3] = supermarket.getContactNumber();
                    rowData[i] = temp;
                }
                Object[] columnNames = {"SupermarketId", "SupermarketName", "Address", "ContactNumber"};
                show_info = new JTable(rowData,columnNames);

//        show_info.setBackground(Color.white);
                JScrollPane scroll = new JScrollPane(show_info);
                scroll.setBounds(0, 200, 1080, 400);
                menuPanel.add(scroll);

            }
        });
        b3.setBounds(375,100,150,50);
        b3.setFocusPainted(false);
        menuPanel.add(b3);

        Neo_Button b4 = new Neo_Button("查找商场信息", new SuperMarketSearchAction());
        b4.setBounds(550,100,150,50);
        b4.setFocusPainted(false);
        menuPanel.add(b4);

        Neo_Button b5 = new Neo_Button("修改商场信息", new SuperMarketUpdateAction());
        b5.setBounds(725,100,150,50);
        b5.setFocusPainted(false);
        menuPanel.add(b5);

        Neo_Button b6 = new Neo_Button("返回", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose();
            }

        });
        b6.setBounds(900,100,150,50);
        b6.setFocusPainted(false);
        menuPanel.add(b6);

        Neo_Button b7 = new Neo_Button("退出程序", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        b7.setBounds(900, 800,150,50);
        b7.setFocusPainted(false);
        menuPanel.add(b7);

        menuFrame.setContentPane(menuPanel);

    }

    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }
}
