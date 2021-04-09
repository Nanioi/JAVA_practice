public class JC18012628Q0201 {
	public static void main(String[] args) {
		int intArray[][]=new int[4][];
		intArray[0]=new int[5];
		intArray[1]=new int[4];
		intArray[2]=new int[3];
		intArray[3]=new int[2];
		int sum=0;
		
		System.out.print(" 학번 : 18012628, 이름 : 곽나연 ");
		System.out.println();
		
		for(int i=0;i<intArray.length;i++) {
			for(int j=0;j<intArray[i].length;j++) {
				intArray[i][j]=(int)(Math.random()*100+1);
			}
		}
		for(int i=0;i<intArray.length;i++) {
			sum=0;
			for(int j=0;j<intArray[i].length;j++) {
				sum+=intArray[i][j];
				System.out.print(intArray[i][j]+" ");
			}
			System.out.print("=> Sum of this row = "+ sum);
			System.out.println();
		}
	}

}
