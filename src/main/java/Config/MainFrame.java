package Config;
import javax.swing.*;

import Config.*;

import java.awt.*;


public class MainFrame extends JFrame{

    public MainFrame(String name, int width, int height){
        setTitle(name);
        setPreferredSize(new Dimension(width,height));
        pack();
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);

    }
}
