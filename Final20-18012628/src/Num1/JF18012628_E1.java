package Num1;

import java.util.Vector;

class Rectangle{
	private int x,y;
	public Rectangle(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void Print() {
		System.out.println("점:("+x+","+y+"), 면적:"+x*y);
	}
}
public class JF18012628_E1 {
	public static void main(String[] args) {
		System.out.println("18012628 곽나연");
		Vector <Rectangle> v = new Vector <Rectangle>();
	
		v.add(new Rectangle(3,4));
		v.add(new Rectangle(5,10));
		v.add(new Rectangle(30,7));
		
		for(int i=0;i<v.size();i++) {
			Rectangle R=v.get(i);
			R.Print();
		}
	}
	
}
