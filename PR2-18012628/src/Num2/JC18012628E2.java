package Num2;

import java.util.*;

abstract class Shape {
	private Shape S;
	
	public Shape(){ 
		S = null; 
	}
	public void set(Shape obj){
		S = obj;
	}
	public Shape get(){ 
		return S; 
	}
	public abstract void draw();
}

class Line extends Shape {
	public void draw() {
		System.out.println("Line");
	}
}

class Rect extends Shape {
	public void draw() {
		System.out.println("Rect");
	}
}

class Circle extends Shape {
	public void draw() {
		System.out.println("Circle");
	}
}

public class JC18012628E2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Vector<Shape> v = new Vector<Shape>();
		
		Shape shape = null;
		System.out.println("그래픽 에디터 beauty을 실행합니다.");
		
		while(true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
			
			int n = scanner.nextInt();
			
			if(n==1) {
					System.out.print("Line(1), Rect(2), Circle(3) >> ");
					int m = scanner.nextInt();
					
					if(m==1)
						shape = new Line();
					if(m==2)
						shape = new Rect();
					if(m==3)
						shape = new Circle();
					
					v.add(shape);
			}
			if(n==2) {
					System.out.print("삭제할 도형의 위치 >> " );
					int x = scanner.nextInt();
					
					if(v.size() == 0 || v.size() <= x)
						System.out.println("삭제할 수 없습니다.");
					else 
						v.remove(x);
			}
			if(n==3) {
					for(int i=0; i<v.size(); i++)
						v.get(i).draw();
			}
			if(n==4) {
					System.out.println("beauty을 종료합니다.");
					scanner.close();
					return;
			}		
		}
	}
}
