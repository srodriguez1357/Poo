import java.util.Arrays;
import java.util.Scanner;

public class Arreglocuatro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de calificaciones a acapturar: ");
		int cal = input.nextInt();
		int suma = 0;
		int[] A = new int[cal];
		
		for(int i = 0; i<cal;i++) {
			System.out.println("Ingrese la Calificación: ");
			int cal2 = input.nextInt();
			suma = cal2+suma;
			Arrays.fill(A,  cal2);;
		}
		double prom = suma/A.length;
		
		System.out.println("El promedio es: "+ prom);
	}

}
