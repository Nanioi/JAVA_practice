package Num2;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JC18012628E2 extends JFrame  {
	private MyThread th;
	private MyPanel p = new MyPanel();

	public JC18012628E2() {
		setSize(500, 500);
		setTitle("Make Drawing to start");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(p);
		th = new MyThread(p);
		th.start();

		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				th.setFlag(true);
				th.play();
			}

			public void mouseExited(MouseEvent e) {
				th.setFlag(false);
			}
		});
		
		setVisible(true);
	}
	class MyThread extends Thread {
		MyPanel p;
		private boolean flag;

		public MyThread(MyPanel p) {
			this.p = p;
		}
		public void setFlag(boolean flag) {
			this.flag = flag;
		}
		synchronized public void play() {
			notify();
		}
		public void run() {
			try { 
				synchronized (this) {
					wait();
				}
			} catch (InterruptedException ex) {
				return;
			}
			while (true) {
				try {
					if (flag) {
						p.repaint();
						p.randomOval();
					}
					Thread.sleep(300);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}
	class MyPanel extends JPanel {
		private int x, y, width, height;

		public void randomOval() {
			x = (int) (Math.random() * (getWidth() - getWidth() / 2));
			y = (int) (Math.random() * (getHeight() - getHeight() / 2));
			width = (int) (Math.random() * 200);
			height = (int) (Math.random() * 200);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			randomOval();
			g.fillOval(x, y, width, height);
		}
	}
	public static void main(String[] args) {
		new JC18012628E2();
	}
}