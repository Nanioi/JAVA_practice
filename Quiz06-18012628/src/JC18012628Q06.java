import java.util.*;

class Point {
	private int x,y;
	
	public Point (int x, int y) { 
	 this.x = x;
	 this.y = y;
	}
	
	public String toString() {
	 return "("+x+","+y+")";
	}
	public int sum() {
	 return x+y;
	}
}

public class JC18012628Q06 {
	public static void main(String[] args) {
		Vector<Point>v=new Vector<Point>();
		
		v.add(new Point(-10,-10));
		v.add(new Point(10,10));
		v.add(new Point(20,20));
		v.add(new Point(30,30));
		
		Iterator<Point> iterator=v.iterator();
		while(iterator.hasNext()) {
			Point p=iterator.next();
			System.out.println(p.toString());
		}
	}
}