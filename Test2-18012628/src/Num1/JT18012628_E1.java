package Num1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JT18012628_E1 extends JFrame {
	private JLabel hello = new JLabel("hello");
	private JPanel phello = new JPanel();
	private JButton btn=new JButton("Mouse Event 테스트 버튼");
	private JPanel pbtn = new JPanel();
	
	public JT18012628_E1() {
		setSize(500, 400);
		setTitle("퀴즈 10_1번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pbtn.setBackground(Color.yellow);
		pbtn.add(btn);
		hello.setSize(50,20);
		hello.setLocation(30, 30);
		phello.add(hello);
		
		add(pbtn,BorderLayout.NORTH);
		add(phello,BorderLayout.CENTER);
		
		btn.addMouseListener(new btnMouseListener());
		phello.addMouseListener(new helloMouseListener());
	
		setVisible(true);
	}
	class btnMouseListener extends MouseAdapter{
		public void mouseEntered(MouseEvent e) {
			pbtn.setBackground(Color.red);
		}
		public void mouseExited(MouseEvent e) {
			pbtn.setBackground(Color.yellow);
		}
	}
	class helloMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x=e.getX();
			int y=e.getY();
			hello.setLocation(x, y);
		}
	}
	public static void main(String[] args) {
		System.out.println("18012628 곽나연 ");
		new JT18012628_E1();
	}

}
