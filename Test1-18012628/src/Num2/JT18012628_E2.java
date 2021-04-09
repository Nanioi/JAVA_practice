package Num2;

class Point {
	
	private int x, y;
	
	public Point(int x, int y) { this.x = x; this.y = y; }
	public int getX() { return x; }
	public int getY() { return y; }
	protected void move(int x, int y) { this.x = x; this.y = y; }
}

class ColorPoint extends Point{
	String s;
	
	public ColorPoint(String a,int x,int y){
		super(x,y);
		this.s=a;
	}
	
}

public class JT18012628_E2 {
	public static void main(String[] args) {
	
		ColorPoint B = new ColorPoint("Black",0,0);
		ColorPoint R = new ColorPoint("Red",5,5);
		
		System.out.println("18012628 곽나연");
		
		System.out.println(B.s+"색의 ("+B.getX()+"."+B.getY() +")의 점입니다.");
		System.out.println(R.s+"색의 ("+R.getX()+"."+R.getY() +")의 점입니다.");
		
	}
}
