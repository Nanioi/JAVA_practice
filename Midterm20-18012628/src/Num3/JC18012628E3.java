package Num3;

class Triangle{
	private int width, height;
	
	public Triangle(int width, int height) { this.width = width; this.height = height; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public void show() {
		System.out.println("Triangle은 밑변이 "+width+"이고 높이가 "+height+"인 삼각형이다.");
	}
}

class ColorTriangle extends Triangle{
	String color;
	
	public ColorTriangle(String color,int width,int height){
		super(width,height);
		this.color=color;
	}
	public void show() {
		System.out.println("ColorTriangle은 밑변이 "+getWidth()+"이고 높이가 "+getHeight()+"인 "+color+ " 삼각형이다.");
	}
}

public class JC18012628E3 {
	public static void main(String[] args) {
	
	Triangle T= new Triangle(10,20);
	ColorTriangle R = new ColorTriangle("빨간색",20,40);
	
	System.out.println("18012628 곽나연");
	
	T.show();
	R.show();
	}
}
