/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charmap;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Johan
 */
public class Ventana extends JFrame {
    PanelC pc;
    
    public Ventana() throws HeadlessException {
        super("Convert");
        pc = new PanelC();
        this.add(pc, BorderLayout.CENTER);
        this.setBounds(200, 50, 900, 650);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
