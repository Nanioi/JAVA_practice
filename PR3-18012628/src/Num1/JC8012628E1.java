package Num1;

import javax.swing.*;
import java.awt.*;

public class JC8012628E1 extends JFrame {
	public JC8012628E1() {
			
		setSize(300, 300);
		setTitle("Random Labels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container C = getContentPane();
		C.setLayout(null);
	
			
		for(int i = 0; i < 20; i++) {
			
			int x = (int)(Math.random() * 200) + 50;
			int y = (int)(Math.random() * 200) + 50;
			
			JLabel label = new JLabel("");
			
			label.setLocation(x, y);
			label.setSize(10,10);
			label.setOpaque(true);
			label.setBackground(Color.BLUE);
			C.add(label);
		
		}
		setVisible(true);
	}
	public static void main(String[] args) {
		new JC8012628E1();
	}
}
