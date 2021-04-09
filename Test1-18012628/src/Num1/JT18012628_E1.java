package Num1;

class PrintShop{
	char c;
	int n;
	
	
	public PrintShop(){
		c='#';
		n=5;
	}
	public PrintShop(char c){
		this.c=c;
		n=5;
	}
	public PrintShop(char c,int n){
		this.c=c;
		this.n=n;
	}
	
	public void print(){
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	public void print(int num){
		int cnt=0;
		
		while(cnt<num) {
			if(cnt%2!=0) {
				for(int i=n;i>0;i--) {
					for(int j=i;j>0;j--) {
						System.out.print(c);
					}
					System.out.println();
				}
			}
			else {
				for(int i=0;i<n;i++) {
					for(int j=0;j<=i;j++) {
						System.out.print(c);
					}
					System.out.println();
				}
			}
			cnt++;
		}
	}
	public void printReverse(int num) {
		int cnt=0;
		
		while(cnt<num) {
			if(cnt%2==0) {
				for(int i=n;i>0;i--) {
					for(int j=i;j>0;j--) {
						System.out.print(c);
					}
					System.out.println();
				}
			}
			else {
				for(int i=0;i<n;i++) {
					for(int j=0;j<=i;j++) {
						System.out.print(c);
					}
					System.out.println();
				}
			}
			cnt++;
		}
	}
}
public class JT18012628_E1 {
	public static void main(String[] args) {
		PrintShop ps1 = new PrintShop();
		PrintShop ps2 = new PrintShop('@');
		PrintShop ps3 = new PrintShop('$',10);
		
		System.out.println("18012628 곽나연");
		
		ps1.print();
		ps2.print(3);
		ps3.printReverse(2);
	}
}
