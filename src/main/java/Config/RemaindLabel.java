package Config;

import javax.swing.*;
import java.awt.Font;

public class RemaindLabel extends JLabel {

    public RemaindLabel(String Message){
        setText(Message);
        setBounds(50,0,200,100);
        Font fnt = new Font("Serief", Font.BOLD, 30);
        setFont(fnt);
    }

}
