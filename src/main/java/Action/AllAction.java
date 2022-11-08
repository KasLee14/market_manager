package Action;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Config.*;

public class AllAction implements ActionListener{

    public static JFrame menuFrame;
    private JTable show_info;

    @Override
    public void actionPerformed(ActionEvent e){

        System.out.println("market info");
        menuFrame = new MainFrame("商场管理界面",1600,900);
        JPanel menuPanel = new MainPanel(1600,900);
//        menuFrame = new JFrame();
//        menuPanel = new JPanel();


        Object[] columnNames = {"姓名", "语文", "数学", "英语", "总分"};

        // 表格所有行数据
        Object[][] rowData = {
                {"张三", 80, 80, 80, 240},
                {"John", 70, 80, 90, 240},
                {"Sue", 70, 70, 70, 210},
                {"Jane", 80, 70, 60, 210},
                {"Joe", 80, 70, 60, 210}
        };

        show_info = new JTable(rowData, columnNames);
//        show_info.setBackground(Color.white);
        JScrollPane scroll = new JScrollPane(show_info);
        scroll.setBounds(100, 100, 1100, 800);
        menuPanel.add(scroll);
//        menuPanel.add(show_info.getTableHeader(), BorderLayout.NORTH);
//        menuPanel.add(show_info, BorderLayout.CENTER);

        menuFrame.setContentPane(menuPanel);
        menuFrame.pack();
        menuFrame.setVisible(true);
        menuFrame.setLocationRelativeTo(null);



    }

    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }
}
