package sesion_1;
import java.util.Scanner;

public class Leibniz {

	public static double main(String[] args) {
		// TODO Auto-generated method stub
		double value = 0;
		double div = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Ingresa la presición deseada: ");
        int pres = input.nextInt();
        input.close();
        
		for (int i = 0; i < pres; i++) {
			 
	         if (i % 2 == 0) {
	            value = value + (1 / div);
	         } else {
	            value = value - (1 / div);
	         }
	         div = div + 2;
	      }
	      value = value * 4;
	      return value;
	}

}
