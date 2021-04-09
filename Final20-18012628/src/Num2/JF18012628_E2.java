package Num2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JF18012628_E2 extends JFrame {
	private JPanel Nbtn = new JPanel();
	private JPanel Sbtn = new JPanel();
	private JPanel Cbtn = new JPanel();
	
	public JF18012628_E2() {
		setSize(500, 300);
		setTitle("기말고사 2번문제,18012628");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(new JButton("North"),BorderLayout.NORTH);
		c.add(new JButton("North"),BorderLayout.NORTH);
		c.add(new JButton("North"),BorderLayout.NORTH);
		
		JButton north=new JButton("North");
		JButton south=new JButton("South");
		JButton center = new JButton("CENTER");
		
		Nbtn.setBackground(Color.YELLOW);
		Nbtn.add(north);
	
		Cbtn.setBackground(Color.GRAY);
		Cbtn.add(center);
		
		Sbtn.setBackground(Color.YELLOW);
		Sbtn.add(south);
		
		c.add(Nbtn,BorderLayout.NORTH);
		c.add(Cbtn,BorderLayout.CENTER);
		c.add(Sbtn,BorderLayout.SOUTH);
		north.addMouseListener(new btnMouseListener());
		center.addMouseListener(new btnMouseListener());
		south.addMouseListener(new btnMouseListener());
		setVisible(true);
	}
	class btnMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			JButton b=(JButton)e.getSource();
			if(b.getText().equals("North")) {
				Nbtn.setBackground(Color.MAGENTA);
				Cbtn.setBackground(Color.GRAY);
				Sbtn.setBackground(Color.YELLOW);
			}
			if(b.getText().equals("CENTER")) {
				Cbtn.setBackground(Color.PINK);
				Nbtn.setBackground(Color.YELLOW);
				Sbtn.setBackground(Color.YELLOW);
			}
			if(b.getText().equals("South")) {
				Sbtn.setBackground(Color.GREEN);
				Cbtn.setBackground(Color.GRAY);
				Nbtn.setBackground(Color.YELLOW);
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("18012628 곽나연 ");
		new JF18012628_E2();
	}
}
