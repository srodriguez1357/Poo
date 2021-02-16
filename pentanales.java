import javax.swing.JOptionPane;

public class pentanales {

	public static void main(String[] args) {
		int x = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número "));
		
		for(int i =0;i<x;i++) {
			System.out.println(i*(3*i-1)/2);
			
		}
	}

}
