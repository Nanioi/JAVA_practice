package Num1;

class Circle{
	private int id,x,y;
	private double r,PI;
	
	Circle(){
		id=(int)((Math.random()*100));
		PI=3.14159;
	}
	Circle(int x,int y,double r){
		id=(int)((Math.random()*100));
		PI=3.14159;
		this.x=x;
		this.y=y;
		this.r=r;
	}
	public double Circlewid() {
		double wid;
		
		wid=r*r*PI;
		
		return wid;
	}
	public void show() {
		System.out.println("id : "+id);
		System.out.println("중심점 좌표 : ("+x+"."+y+")");
		System.out.println("반지름 : "+r);
		System.out.println("면적 : "+Circlewid());
	}

	public boolean equals(Object obj) {
		Circle p=(Circle)obj;
		if(r*r*PI==p.r*p.r*PI)
			return true;
		else
			return false;
	}
}

public class JC18012628E1 {
	public static void main(String[] args) {
		Circle a=new Circle(10,10,8.0);
		Circle b=new Circle(15,20,12.0);
		Circle c=new Circle(20,20,8.0);
		
		System.out.println("<1번째 원>");
		a.show();
		System.out.println("<2번째 원>");
		b.show();
		System.out.println("<3번째 원>");
		c.show();
		
		if(a.equals(b))System.out.println("a==b");
		if(a.equals(c))System.out.println("a==c");
		if(b.equals(c))System.out.println("b==c");
		
		
		System.out.println("18012628 곽나연");
	
	}
}
