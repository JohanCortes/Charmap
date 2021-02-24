/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charmap;

import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.math.BigInteger;

import javax.swing.JOptionPane;

/**
 *
 * @author Johan
 */
public class tc implements TextListener {

	@Override
	public void textValueChanged(TextEvent e) {
		if (CharMap.v != null) {
			PanelC panel = CharMap.v.pc;

			if (e.getSource().equals(panel.texcod)) {
				if (panel.texcod.getText().length() >= 1) {
					if (panel.texcod.getText().charAt(panel.texcod.getText().length() - 1) != "\n".charAt(0)) {
						CharMap.textc = panel.texcod.getText().replace("\n", "");
						String w = Character.toString((char) 13);
						CharMap.textc = CharMap.textc.replace(w, "");
					}
				} else {
					panel.texchar.setText("");
				}
				// CharMap.textc = CharMap.textc.replace("\n", "");
				if (CharMap.di && panel.texcod.getText().length() >= 1) {
					if (panel.texcod.getText().charAt(panel.texcod.getText().length() - 1) == ' ') {
						// try {
						int t = CharMap.textc.length() / 5;
						String[] a = new String[t];
						a = CharMap.textc.split(" ");
						panel.texchar.setText(CharMap.textc + "\n");
						// panel.texchar.setText(panel.texchar.getText() + "\n");
						int[] g = new int[t];
						char[] qwe = CharMap.textc.toCharArray();
						for (int x = 0; x < qwe.length; x++) {
							// System.out.print((int)qwe[x]+" ");
						}
						// System.out.println("");
						panel.texchar.setText("");
						for (int x = 0; x < t; x++) {
							// g[x] = int.Parse(a[x], System.Globalization.NumberStyles.HexNumber);
							g[x] = Integer.parseInt(a[x], 16);
							char c = (char) g[x];
							String s = c + "";
							panel.texchar.setText(panel.texchar.getText() + s);
						}

						// } catch (Exception k) {
						// }
					}
				}
				panel.lpr.setText(CharMap.textc.length() + "");
			}
			// String hexadecimal = Integer.toHexString(númeroDecimal); dec-hex
			// int decimal = Integer.parseInt(hexadecimal, 16); hex-dec

			if (e.getSource().equals(panel.texchar)) {
				CharMap.textl = panel.texchar.getText();
				if (CharMap.di == false) {
					char[] c = panel.texchar.getText().toCharArray();
					int[] a = new int[c.length];
					panel.texcod.setText("");
					for (int x = 0; x < c.length; x++) {
						a[x] = c[x];
						String sn = "", s = Integer.toHexString(a[x]);
						while (s.length() < 4) {
							s = "0" + s;
						}
						if ((x + 1) % 8 == 0) {
							sn = "\n";
						}
						s = s.replace("a", "A");
						s = s.replace("b", "B");
						s = s.replace("c", "C");
						s = s.replace("d", "D");
						s = s.replace("e", "E");
						s = s.replace("f", "F");
						panel.texcod.setText(panel.texcod.getText() + s + " " + sn);
					}
				}
				panel.lpr.setText(CharMap.textc.length() + "");
			}
		}

		if (CharMap.V != null) {
			PaneletC panel = CharMap.V.pc;
			if (e.getSource().equals(panel.ini)) {
				if (panel.ini.getText().length() > 0) {
					if (panel.ini.getText().charAt(panel.ini.getText().length() - 1) == 43) {
						String s = panel.ini.getText().replace("+", "");

						try {
							int i = Integer.parseInt(s, 16);
							if (i >= 0 && i < 0xFF50) {
								i = i - (i % 16);
								System.out.println(i);
								panel.z = i;
								panel.act();
							}
						} catch (Exception k) {
						}
						panel.ini.setText("");
					}
				}
			}
			if (e.getSource().equals(panel.tex)) {
				if (panel.tex.getText().length() > 0) {
					if (panel.tex.getText().charAt(panel.tex.getText().length() - 1) == 43) {
						String s = panel.tex.getText().replace("+", "");
						panel.tex.setText(s);
						s = Character.toString(s.charAt(s.length() - 1));
						char c = s.charAt(0);
						try {
							String h = Integer.toHexString((int) c);
							h = h.replace("a", "A");
							h = h.replace("b", "B");
							h = h.replace("c", "C");
							h = h.replace("d", "D");
							h = h.replace("e", "E");
							h = h.replace("f", "F");
							String info = s + "\n\nNombre: " + Character.getName((int) c) + "\nHexadecimal: " + h
									+ "\nDecimal: " + (int) c;
							if (Character.isISOControl((int) c)) {
								info += "\nEs un simbolo de control";
							} else {
								if (Character.isLetter((int) c)) {
									info += "\nEs una letra";
								}
								if (Character.isDigit((int) c)) {
									info += "\nEs un digito";
								}
								if (Character.isIdeographic((int) c)) {
									info += "\nEs un ideograma";
								}
								if (Character.isLetterOrDigit((int) c) == false) {
									info += "\nEs un simbolo";
								}
							}
							JOptionPane.showMessageDialog(CharMap.V, info);
							//System.out.println(info);
						} catch (Exception k) {
						}
					}
				}
			}
			if (e.getSource().equals(panel.bus)) {
				if (panel.bus.getText().length() > 0) {
					if (panel.bus.getText().charAt(panel.bus.getText().length() - 1) == 43) {
						String s = panel.bus.getText().replace("+", "");
						panel.bus.setText(s);
						System.out.println(s);
						panel.lista(CharMap.consulta(s));
					}
				}
			}
		}
	}
}
