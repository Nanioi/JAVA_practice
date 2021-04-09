package Num2;
class Money{
	private int money;
	private String name;
	
	
	Money(int money,String name){
		this.money=money;
		this.name=name;
	}
	public void setMoney(int money) {
		this.money=money;
	}
	public int getMoney() {
		return money;
	}
	public void won() {
		System.out.println(" 현재 돈 액수 :" +money);
	}
	public void mKind(int money,int unit[]) {
		int won;
		
		for (int i = 0; i < 8; i++) {
	        won= money / unit[i];
	        money = money % unit[i];
	        System.out.println(unit[i] + "원 권 " + won + "개");
	    }
	}
}
public class JC18012628E2 {
	public static void main(String[] args) {
		int [] unit = {50000, 10000, 5000, 100, 500, 50, 10, 1};
		int bigger;
		
		Money a=new Money(108377,"박일수");
		Money b=new Money(69537,"박이수");
		Money c=new Money(10337,"김길동");
		
		System.out.println("박일수 >> ");
		a.won();
		a.mKind(a.getMoney(), unit);
		System.out.println("박이수 >> ");
		b.won();
		b.mKind(b.getMoney(), unit);
		System.out.println("김길동 >> ");
		c.won();
		c.mKind(c.getMoney(), unit);
		
		System.out.println("박일수가 박이수에게 27000원을 주었을때 : ");
		a.setMoney((a.getMoney()-27000));
		b.setMoney((b.getMoney()+27000));
		
		System.out.println("박일수 >> ");
		a.won();
		a.mKind(a.getMoney(), unit);
		System.out.println("박이수 >> ");
		b.won();
		b.mKind(b.getMoney(), unit);
		
		bigger=a.getMoney()-b.getMoney();
		if(bigger<0) {
			System.out.println("박이수돈이 더 많음 (큰 액수) : "+b.getMoney());
			bigger*=-1;
		}else
		{
			System.out.println("박일수돈이 더 많음 (큰 액수) : "+a.getMoney());
		}
			
		System.out.println("박일수와 박이수 돈의 차이 : " + bigger);
	
	}
}