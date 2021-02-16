import java.util.concurrent.ThreadLocalRandom;

public class Arreglosdos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int filas = ThreadLocalRandom.current().nextInt(2, 21);
		System.out.println(filas);
		int[] A = new int[filas];
		
		for(int i=1;i<filas;i++) {
			for(int k = 1;k<i;k++) {
				int[] B = new int[k];
				for(int j = 1; j<k;j++) {
					B[k] = k;
				}
			}
		}
		
	}

}
