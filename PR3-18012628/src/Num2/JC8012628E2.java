package Num2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JC8012628E2 extends JFrame {
	JLabel label;
	JC8012628E2() {
		setSize(500,500);
		setTitle("클릭 연습 용 응용프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container C = getContentPane();
		C.setLayout(null);
		C.addMouseListener(new MouseClick());
		
		label = new JLabel("C");
		
		label.setSize(50,50);
		label.setLocation(100,100);
		label.addMouseListener(new MouseClick());
		
		C.add(label);
		setVisible(true);
	}
	class MouseClick implements MouseListener{
		public void mousePressed(MouseEvent e) {
			int x,y;
			x=(int)(Math.random()*400);
			y=(int)(Math.random()*400);
			label.setLocation(x, y);
		}
		public void mouseReleased(MouseEvent e){}
		public void mouseClicked(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
	}
	public static void main(String[] args) {
		new JC8012628E2();
	}
}
