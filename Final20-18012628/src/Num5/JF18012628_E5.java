package Num5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Runnable;

public class JF18012628_E5 extends JFrame {
	private JPanel pjava = new JPanel();
	private JPanel ptimer = new JPanel();
	
	public JF18012628_E5() {
		setSize(312, 624);
		setTitle("기말 5번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(2,1,12,12);
		
		Container c=getContentPane();
		c.setLayout(grid);
		
		c.add(pjava);
		c.add(ptimer);
		
		JLabel java = new JLabel("java");
		java.setSize(50,20);
		java.setLocation(30,30);
		pjava.add(java);
		pjava.setBackground(Color.PINK);
		pjava.setSize(300,300);
		
		JLabel timer = new JLabel();
		timer.setFont(new Font("Gothic",Font.ITALIC,80));
		ptimer.add(timer);
		ptimer.setBackground(Color.GRAY);
		ptimer.setSize(300,300);
	
		javaRunnable jrunnable = new javaRunnable(pjava);
		TimerRunnable trunnable = new TimerRunnable(timer);
		
		Thread t1 = new Thread(trunnable);
		Thread t2 = new Thread(jrunnable);
		
		
		t1.start();
		t2.start();
		
		setVisible(true);
	}
	class TimerRunnable implements Runnable{
		private JLabel timerLabel;
		private boolean flag=false;
		
		public TimerRunnable(JLabel timerLabel) {
			this.timerLabel=timerLabel;
		}
		public void finish() {
			flag=true;
		}
		public void run() {
			int n=0;
			while(true) {
				timerLabel.setText(Integer.toString(n));
				n++;
				try {
					Thread.sleep(1000);
					if(flag==true)
						return;
				}catch(InterruptedException e) {
					return;
				}
			}
		}
	}
	class javaRunnable implements Runnable{
		private JPanel jp;
		private boolean flag=false;
		
		public javaRunnable(JPanel jp) {
			this.jp=jp;
		}
		public void finish() {
			flag=true;
		}
		public void run() {
			while (true) {
				int x=((int )(Math.random()*jp.getWidth()));
				int y=((int )(Math.random()*jp.getWidth()));
				JLabel l=new JLabel("java");
				l.setSize(80,30);
				l.setLocation(x,y);
				jp.add(l);
				jp.repaint();
				try {
					Thread.sleep(200);
					if(flag==true) {
						jp.removeAll();
						l=new JLabel("finish");
						l.setSize(80,30);
						l.setLocation(100,100);
						l.setForeground(Color.RED);
						jp.add(l);
						jp.repaint();
						return;
					}
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("18012628 곽나연 ");
		new JF18012628_E5();
	}
}
