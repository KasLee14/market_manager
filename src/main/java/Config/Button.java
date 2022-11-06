package Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Button extends JButton {

    public Button(String name, ActionListener action){
        super(name);
//        setPreferredSize(new Dimension(100,30));
        setBorderPainted(false);
        setBackground(Color.LIGHT_GRAY);
        setBounds(50,100,100,50);
    }

}
