/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charmap;

/**
 *
 * @author Johan
 */
public class CharMap {

	static tc t = new tc();
	static bListener b = new bListener();
	static Ventana v;
	static Vindu V;
	static String textl = "", textc = "";
	static boolean di = true;
	static String[][] list = new String[3366][2];

	public static void main(String[] args) {
		int n=0;
		for (int x = 0; x < 4096;x++) {
			String s = Character.getName(x);
			if(s==null) {
				//System.out.println("N "+Integer.toHexString(x));
			}
			else {
				list[n][0]=s;
				list[n][1]=x+"";
				n++;
			}
		}
		System.out.println(n);
		for(int x=0;x<3366;x++) {
			//System.out.println(list[x][0]+"\t"+Integer.toHexString((Integer.parseInt(list[x][1]))));
		}
		V = new Vindu();

	}
	
	public static String[][] consulta(String s) {
		String[][] r;
		int c=0;
		for(int x=0;x<3366;x++) {
			if(list[x][0].contains(s)) {
				c++;
			}
		}
		System.out.println(c);
		r=new String[c][2];
		c=0;
		for(int x=0;x<3366;x++) {
			if(list[x][0].contains(s)) {
				r[c][0]=list[x][0];
				r[c][1]=list[x][1];
				//System.out.println(r[c][0]+"\t"+r[c][1]);
				c++;
			}
		}
		return r;
	}

}
