import java.util.Arrays;

public class Arreglosuno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = {{2, 0, 1}, {3, 0, 0}, {5, 1, 1}};
		int [][] B = {{1, 0, 1}, {1, 2, 1}, {1, 1, 0}};
		int [][] C = new int [3][3];
		
		for(int i = 0; i<3;i++) {
			for(int j = 0; j<3;j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
			
			System.out.println(Arrays.toString(C));
		}
	}

}
