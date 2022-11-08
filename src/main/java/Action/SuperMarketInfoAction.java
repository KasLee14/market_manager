package Action;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import java.awt.*;
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
        b1.setBounds(0,0,150,50);
        b1.setFocusPainted(false);

        menuPanel.add(b1);

        menuFrame.setContentPane(menuPanel);

    }

    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }
}
