import java.util.Scanner;

public class ScannerEx {
	public static void main(String args[]) {
		
		System.out.println("이름:곽나연 , 학번:18012628 ");
		int cnt=0;
		
		System.out.println("이름,도시,나이,체중,독신 여부를 빈칸으로 분리하여 입력하세요 ");
	    Scanner scanner=new Scanner(System.in);
		
	    String name = scanner.next();//문자열읽기
	    cnt++;
	    System.out.println("이름은 "+name+",");
	    
	    String city = scanner.next();//문자열읽기 
	    cnt++;
	    System.out.println("도시는 "+city+",");
	    
	    int age = scanner.nextInt();//정수 읽기 
	    cnt++;
	    System.out.println("나이는 "+age+"살,");
	    
	    double weight = scanner.nextDouble();//실수 읽기 
	    cnt++;
	    System.out.println("체중은 "+weight+"kg,");
	    
	    boolean isSingle = scanner.nextBoolean();//논리값읽기 
	    cnt++;
	    System.out.println("독신여부는 "+isSingle+"입니다.");
	    System.out.println("총 입력된 데이터의 갯수는 "+cnt+"입니다. ");
	    scanner.close();
	}
}
