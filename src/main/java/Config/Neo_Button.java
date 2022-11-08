package Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Neo_Button extends JButton {

    public Neo_Button(String name, ActionListener action){
        super(name);
//        setPreferredSize(new Dimension(100,30));
        setBorderPainted(false);
        addActionListener(action);
        setBackground(Color.LIGHT_GRAY);
    }

}
