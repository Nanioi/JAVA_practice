package Num3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JF18012628_E3 extends JFrame {
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	JLabel la=new JLabel("HELLO");
	
	public JF18012628_E3() {
		setSize(720, 720);
		setTitle("기말고사 3번문제,18012628");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		GridLayout grid = new GridLayout(2,2,12,12);
		
		Container c=getContentPane();
		c.setLayout(grid);
		
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.addKeyListener(new MyKeyListener());
		
		la.setLocation(50, 50);
		la.setSize(100,20);
		p2.add(la);
		
		setVisible(true);
	}
	class MyKeyListener extends KeyAdapter{
		public void KeyPressed(KeyEvent e) {
			JPanel p=(JPanel)e.getSource();
			if(e.getKeyChar()=='1')
				p1.setBackground(Color.RED);
			if(e.getKeyChar()=='2')
				p1.setBackground(Color.BLUE);
			if(e.getKeyChar()=='3')
				p1.setBackground(Color.YELLOW);
			if(e.getKeyCode()==KeyEvent.VK_F1)
				p1.setBackground(Color.GREEN);
			if(e.getKeyCode()==KeyEvent.VK_F2) {
				if(p==p1)
					p2.requestFocus();
				else
					p1.requestFocus();
			}
			if()
		}
	}
	public static void main(String[] args) {
		System.out.println("18012628 곽나연 ");
		new JF18012628_E3();
	}
}
