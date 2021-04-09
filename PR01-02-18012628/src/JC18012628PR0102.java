import java.util.Scanner;

class Phone {
	String name;
	String tel;
	
	Phone(String name, String tel) {
		this.name = name;
	    this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
}
public class JC18012628PR0102 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
			
		System.out.print("인원수 >> ");
		int num = scanner.nextInt();
			
		Phone[] A = new Phone[num];
			
		for(int i = 0; i < num; i++) {
			System.out.print("이름과 전화번호(번호는 연속적으로 입력) >> ");
			A[i] = new Phone(scanner.next(),scanner.next());
		}
			
		System.out.println("저장되었습니다...");
			
		while(true) {
			System.out.print("검색할 이름  >> ");
			String searchName = scanner.next();
				
			for(int i = 0; i < num; i++) {
				if(searchName.equals("그만")) {
					System.out.println("프로그램을 종료합니다...");
					return;
				}
				else if(searchName.equals(A[i].getName())){
					System.out.println(A[i].getName() + "의 번호는 " + A[i].getTel() + " 입니다.");
					break;
				}
				else if(!searchName.equals(A[i].getName())&& i==(num-1)){
					System.out.println(searchName + "이(가) 없습니다.");
				}
			}
		}
	}
}
