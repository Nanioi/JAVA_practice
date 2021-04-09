public class JC18012628PR0101 {
	public static void main(String[] args) {
		int A[][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		int cnt=0;
		int i,j;
		
		while(cnt < 10) {
			i = (int) Math.round(Math.random() * 3);
			j = (int) Math.round(Math.random() * 3);
			
			if(A[i][j] == 0) {
				A[i][j] = (int) Math.round(Math.random() * 9 + 1);
				cnt++;
			}
		}
		// 10개의 랜덤 값 배정
		
		for(i=0; i<4; i++) {
			for(j=0; j<4; j++)
				System.out.printf("%2d ", A[i][j]);
			System.out.println();
		}
	}
}