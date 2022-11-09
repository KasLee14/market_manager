package Config;

import javax.swing.*;
import java.awt.*;

public class MinorFrame extends JFrame {

    public MinorFrame(String name){
        setTitle(name);
        setPreferredSize(new Dimension(300,200));
        pack();
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
