/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charmap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Johan
 */
public class bListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (CharMap.v != null) {
			if (e.getSource().equals(CharMap.v.pc.b1)) {
				if (CharMap.di) {
					CharMap.di = false;
					CharMap.v.pc.b1.setText("←");
				} else {
					CharMap.di = true;
					CharMap.v.pc.b1.setText("→");
				}

			}
		}
		if (CharMap.V != null) {
			PaneletC p = CharMap.V.pc;
			if (e.getSource().equals(CharMap.V.pc.bc)) {
				CharMap.v = new Ventana();
			}
			else if (e.getSource().equals(CharMap.V.pc.bf)) {
				p.fo();
			}
			else if (e.getSource().equals(CharMap.V.pc.brr)) {
				if(p.z>192) {
					p.z-=192;
					p.act();
				}
			}
			else if (e.getSource().equals(CharMap.V.pc.br)) {
				if(p.z>16) {
					p.z-=16;
					p.act();
				}
			}
			else if (e.getSource().equals(CharMap.V.pc.bs)) {
				if(p.z<65344) {
					p.z+=16;
					p.act();
				}
			}
			else if (e.getSource().equals(CharMap.V.pc.bss)) {
				if(p.z<65168) {
					p.z+=192;
					p.act();
				}
			}
			else {
				for(int x=0;x<12;x++) {
					for(int y=0;y<16;y++) {
						if(e.getSource().equals(CharMap.V.pc.mb[x][y])) {
							CharMap.V.pc.tex.setText(CharMap.V.pc.tex.getText()+CharMap.V.pc.mb[x][y].getText());
						}
					}
				}
			}
			
		}
	}

}
