package charmap;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Vindu extends JFrame {
    PaneletC pc;
    
    public Vindu() throws HeadlessException {
        super("CharMap");
        pc = new PaneletC();
        this.add(pc, BorderLayout.CENTER);
        this.setBounds(0, 0, 1500, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
