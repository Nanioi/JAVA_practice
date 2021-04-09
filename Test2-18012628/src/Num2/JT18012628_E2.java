package Num2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Runnable;

public class JT18012628_E2 extends JFrame {
	private JPanel phello = new JPanel();
	private JPanel ptimer = new JPanel();
	
	public JT18012628_E2() {
		setSize(300, 500);
		setTitle("퀴즈 10_2번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(2,1,12,12);
		
		Container c=getContentPane();
		c.setLayout(grid);
		
		c.add(phello);
		c.add(ptimer);
		
		JLabel hello = new JLabel("hello");
		hello.setSize(50,20);
		hello.setLocation(30,30);
		phello.add(hello);
		phello.setBackground(Color.PINK);
		
		JLabel timer = new JLabel();
		timer.setFont(new Font("Gothic",Font.ITALIC,80));
		ptimer.add(timer);
		ptimer.setBackground(Color.GRAY);
	
	
		helloRunnable hrunnable = new helloRunnable(hello);
		TimerRunnable trunnable = new TimerRunnable(timer);
		
		Thread t1 = new Thread(hrunnable);
		Thread t2 = new Thread(trunnable);
		
		t1.start();
		t2.start();
		
		setVisible(true);
	}
	class helloRunnable implements Runnable{
		private JLabel helloLabel;

		public helloRunnable(JLabel helloLabel) {
			this.helloLabel=helloLabel;
		}
		public void run() {
			while (true) {
				addMouseListener(new MouseAdapter(){
					public void mousePressed(MouseEvent e) {
						int x=e.getX();
						int y=e.getY();
						helloLabel.setLocation(x, y);
					}
				});
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}
	class TimerRunnable implements Runnable{
		private JLabel timerLabel;
		public TimerRunnable(JLabel timerLabel) {
			this.timerLabel=timerLabel;
		}
		public void run() {
			int n=0;
			while(true) {
				timerLabel.setText(Integer.toString(n));
				n++;
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					return;
				}
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("18012628 곽나연 ");
		new JT18012628_E2();
	}
}
