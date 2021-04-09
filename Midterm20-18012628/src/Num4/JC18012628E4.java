package Num4;

class Person{
	private String name;
	private int age;
	
	Person(String name,int age){
		this.name =name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void show() {
		System.out.println("[이름 : "+name+", 나이 : " + age+"]");
	}
	
}
class Researcher extends Person{
	private int id;
	
	Researcher(String name,int age,int id){
		super(name,age);
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void show() {
		System.out.println("[이름 : "+getName()+", 나이 : " + getAge()+", 직번 : "+id+"]");
	}
	
}
class Professor extends Researcher{
	String c;
	
	Professor(String name,int age,int id,String c){
		super(name,age,id);
		this.c=c;
	}
	public void show() {
		System.out.println("[이름 : "+getName()+", 나이 : " + getAge()+", 직번 : "+getId()+", 전공 : "+c+"]");
	}
}
public class JC18012628E4 {
	public static void main(String[] args) {
		Person p=new Person("심청",28);
		Researcher r=new Researcher("심학규",36,2877570);
		Professor f=new Professor("Stevn Seguel",43,4877570,"Computer");
		
		System.out.println("18012628 곽나연");
		
		p.show();
		r.show();
		f.show();
	}
}
