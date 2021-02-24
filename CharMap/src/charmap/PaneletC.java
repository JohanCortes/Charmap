package charmap;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;

public class PaneletC extends JPanel {
	JButton bc, bf, brr, br, bs, bss;
	JButton[][] mb;
	Label[] lu, ld;
	JComboBox com;
	TextField tex, bus, ini;
	int z = 0x0000;
	Font f;
	String[][] le;
	boolean w = false;

	public PaneletC() {
		this.setLayout(null);

		f = new Font("Dialog", Font.PLAIN, 16);

		ini = new TextField();
		ini.addTextListener(CharMap.t);
		ini.setBounds(8, 85, 50, 25);
		this.add(ini);

		bus = new TextField();
		bus.addTextListener(CharMap.t);
		bus.setBounds(971, 85, 350, 25);
		this.add(bus);

		tex = new TextField();
		tex.addTextListener(CharMap.t);
		tex.setBounds(285, 645, 416, 35);
		tex.setFont(new Font("Dialog", Font.PLAIN, 18));
		this.add(tex);

		com = new JComboBox();
		com.setBounds(971, 120, 350, 25);
		com.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (w) {
					int i = com.getSelectedIndex();
					char c = (char) Integer.parseInt(le[i][1]);
					String hex=Integer.toHexString(c)+"+";
					ini.setText(hex);
					tex.setText(tex.getText() + c + "+");
				}
			}
		});
		this.add(com);

		JList li = new JList();
		li.setBounds(971, 120, 350, 480);
		li.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(li);

		bc = new JButton("convert");
		bc.addActionListener(CharMap.b);
		bc.setBounds(1280, 700, 80, 25);
		this.add(bc);

		bf = new JButton();
		bf.addActionListener(CharMap.b);
		bf.setBounds(0, 0, 10, 10);
		this.add(bf);

		brr = new JButton("<<");
		brr.addActionListener(CharMap.b);
		brr.setBounds(70, 645, 60, 35);
		brr.setFont(new Font("Dialog", Font.BOLD, 18));
		this.add(brr);

		br = new JButton("<");
		br.addActionListener(CharMap.b);
		br.setBounds(170, 645, 55, 35);
		br.setFont(new Font("Dialog", Font.BOLD, 18));
		this.add(br);

		bs = new JButton(">");
		bs.addActionListener(CharMap.b);
		bs.setBounds(761, 645, 55, 35);
		bs.setFont(new Font("Dialog", Font.BOLD, 18));
		this.add(bs);

		bss = new JButton(">>");
		bss.addActionListener(CharMap.b);
		bss.setBounds(861, 645, 60, 35);
		bss.setFont(new Font("Dialog", Font.BOLD, 18));
		this.add(bss);

		mb = new JButton[12][16];
		lu = new Label[12];
		ld = new Label[16];
		int w = z;
		for (int x = 0; x < 16; x++) {
			ld[x] = new Label();
			ld[x].setBounds(90 + (x * 53), 85, 30, 30);
			String u = Integer.toHexString(x);
			u = u.replace("a", "A");
			u = u.replace("b", "B");
			u = u.replace("c", "C");
			u = u.replace("d", "D");
			u = u.replace("e", "E");
			u = u.replace("f", "F");
			ld[x].setFont(new Font("Dialog", Font.PLAIN, 14));
			ld[x].setText(u);
			this.add(ld[x]);
		}
		for (int x = 0; x < 12; x++) {
			lu[x] = new Label();
			lu[x].setBounds(8, 127 + (x * 40), 60, 30);
			lu[x].setFont(new Font("Dialog", Font.PLAIN, 14));
			String u = Integer.toHexString(w);
			while (u.length() < 4) {
				u = "0" + u;
			}
			u = u.replace("a", "A");
			u = u.replace("b", "B");
			u = u.replace("c", "C");
			u = u.replace("d", "D");
			u = u.replace("e", "E");
			u = u.replace("f", "F");
			lu[x].setText("U+" + u);
			this.add(lu[x]);
			for (int y = 0; y < 16; y++) {
				mb[x][y] = new JButton();
				mb[x][y].addActionListener(CharMap.b);
				mb[x][y].setBounds(70 + (y * 53), 120 + (x * 40), 53, 40);
				mb[x][y].setFont(f);
				char ch = (char) w;
				mb[x][y].setText(Character.toString(ch));
				this.add(mb[x][y]);
				w++;
			}
		}

	}

	public void act() {
		int w = z;
		for (int x = 0; x < 12; x++) {
			String u = Integer.toHexString(w);
			while (u.length() < 4) {
				u = "0" + u;
			}
			u = u.replace("a", "A");
			u = u.replace("b", "B");
			u = u.replace("c", "C");
			u = u.replace("d", "D");
			u = u.replace("e", "E");
			u = u.replace("f", "F");
			lu[x].setText("U+" + u);
			this.add(lu[x]);
			for (int y = 0; y < 16; y++) {
				char ch = (char) w;
				mb[x][y].setText(Character.toString(ch));
				mb[x][y].setFont(f);
				w++;
			}
		}
	}

	public void fo() {
		if (f.isBold()) {
			f = new Font("Dialog", Font.PLAIN, 16);
			tex.setFont(new Font("Dialog", Font.PLAIN, 18));
		} else {
			f = new Font("Dialog", Font.BOLD, 16);
			tex.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		z = mb[0][0].getText().charAt(0);
		act();
	}

	public void lista(String[][] r) {
		w=false;
		le = r;
		com.removeAllItems();
		String[] items = new String[r.length];
		for (int x = 0; x < r.length; x++) {
			com.addItem(r[x][0]);
			// System.out.println(items[x]);
		}
		w=true;
	}
}
