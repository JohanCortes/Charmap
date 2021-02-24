/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charmap;

import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Johan
 */
public class PanelC extends JPanel {
    JButton b1;
    Label lpr;
    TextArea texcod, texchar;

    public PanelC() {
        this.setLayout(null);
        
        Font f = new Font("Dialog", Font.PLAIN, 16);
        texcod = new TextArea();
        texcod.addTextListener(CharMap.t);
        texcod.setBounds(50, 50, 360, 500);
        texcod.setFont(f);
        this.add(texcod);
        
        texchar = new TextArea();
        texchar.addTextListener(CharMap.t);
        texchar.setBounds(500, 50, 350, 500);
        texchar.setFont(f);
        this.add(texchar);
        
        lpr = new Label();
        lpr.setBounds(0, 560, 40, 20);
        lpr.setFont(f);
        lpr.setText("0");
        lpr.setVisible(false);
        this.add(lpr);
        
        b1 = new JButton("→");//←
        b1.addActionListener(CharMap.b);
        b1.setBounds(425, 250, 60, 30);
        b1.setFont(new Font("Dialog", Font.BOLD, 20));
        this.add(b1);
    }
    
}
