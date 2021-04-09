import java.util.Scanner;

public class Grading {
	public static void main(String args[]) {
		char grade;
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("이름:곽나연 , 학번:18012628 ");
		System.out.println("점수를 입력하요(0~100): ");
		int score = scanner.nextInt();//점수 입력받기 
		
		if(score >=95)
			grade='A';
		else if(score >=75)
			grade='B';
		else if(score >=60)
			grade='C';
		else if(score >=45)
			grade='D';
		else
			grade='F';
		
		
		
		System.out.println("학점은 "+grade+"입니다. ");
	    
		scanner.close();
	}
}
