import javax.swing.JOptionPane;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Baraja {
	public static void main (String[] args) {
		
		String[] suits= {"Spades", "Hearts", "Diamonds", "Clubs"};
		String[] ranks= {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q"};
		
		int[] manojn = new int[5]; //Mnao del jugador con rango
		String[] manojs = new String[5]; //Mano de jugador con suites
		
		int[] manocn = new int[5]; //Mano de la casa
		String[] manocs = new String[5];
		
		String apuesta;
		int apuestaactual = 0;
		int apuestacasa = 0;
		
		int reservac = 100000;
		int reservaj = 500;
		
		String op = "0"; //Decisión jugador
		int counter = 0;
		int ganar = 0;
		int sumaactual = 0;
		int sumadecasa = 0;
		
		String carta1 = null;
		String carta2 = null;
		String carta3 = null;
		String carta4 = null;
		String carta5 = null;
		
		while(ganar==0) {
		int deck[] = new int[52];
		int decknum[] = new int[52];
		String deckstr[] = new String[52];
		//System.out.println("Baraja en orden");
		for(int i = 0; i <52; i++) {
			deck[i]=i;
		}
		
		//Revolver baraja//
		Random rnd = new Random();
		for (int i = 51; i>0; i--) {
			int index = rnd.nextInt(i+1);
			int tmp = deck[index];
			deck[index]=deck[i];
			deck[i]=tmp;
		}
		System.out.println("\n\nBaraja Revuelta\n\n");
		
		for(int i = 0; i<52; i++) {
			String carta = ranks[deck[i]%(int)13];
			String cartasuit = suits[deck[i]/(int)13];
			
			switch(carta) {
				case "ACE":
					carta = "0";
					break;
				case "J": 
					carta = "11";
					break;
				case "K":
					carta = "12";
					break;
				case "Q":
					carta = "13";
					break;
			}
			int cartanum = Integer.parseInt(carta);
			
			decknum[i] = cartanum;
			deckstr[i] = cartasuit;

			System.out.println(cartanum + " " + cartasuit);
		}
		//Baraja Revuelta//
		
		
		//Hora de apotar//
		apuesta = JOptionPane.showInputDialog("Presione 1 para apostar 50, 2 para 100");
		if(apuesta.equals("1")) {
			if(reservaj>=50) {
			reservaj =reservaj-50;
			apuestaactual = 50;
			}
			else {
				JOptionPane.showMessageDialog(null, "No puedes hacer esa apuesta"); //Nos quedmaos sin dinero
				ganar = 1;
			}
		}
		if(apuesta.equals("2")){
			if(reservaj >= 100) {
				apuestaactual = 100;
			}
			else {
				if(reservaj>50) {
					JOptionPane.showMessageDialog(null, "No puedes hacer esa apuesta, hemos apostado 50 por tí");
					apuestaactual = 50;
				}
				else {
					JOptionPane.showMessageDialog(null, "No puedes hacer esa apuesta"); //Nos quedmaos sin dinero
					ganar = 1;
				}
			}
			}
		
		//Apuestas casa
		int apuestcasa = ThreadLocalRandom.current().nextInt(1, 3); 
		if(apuestcasa == 1) {
			 apuestacasa = 50;
		}
		else {
			apuestacasa = 100;
		}
		//Apuestas casa
		
		System.out.println(reservaj);
		//Hora de apostar//
		
		for(int i = 0; i<2; i++) {
			manojn[i] = decknum[i];
			manojs[i] = deckstr[i];
			
			manocn[i] = decknum[i+1];
			manocs[i] = deckstr[i+1];
			
		}
		
		sumaactual = manojn[0] + manojn[1];
		carta1 =String.valueOf(manojn[0] + " " + manojs[0]);
		carta2 =String.valueOf(manojn[1] + " " + manojs[1]);
		
		sumadecasa = manocn[0]+manocn[1];
		
		JOptionPane.showMessageDialog(null,"Tus cartas son: "+carta1 + " "+carta2+" la suma es de "+ sumaactual);
		
		while(!op.equals(null)) {
			if(sumaactual>21) {
				JOptionPane.showMessageDialog(null, "Perdiste el juego");
				reservaj = reservaj - apuestaactual;
				break;
			}
		op = JOptionPane.showInputDialog("Ingrese 1 para tomar una carta o 2 para pasar ");
		if(op.equals(null)) {
			break;
		}
		else {
			int turnos = 0;
			turnos =turnos+1; 
			System.out.println(turnos);
		
		if(op.equals("1")) {
			
			for (int i = 0; i < manojn.length; i ++) { //Contar la cantidad de cartas en la mano
			    if (manojn[i] >0) {
			        counter ++;
			   }
			   
			}
				if(counter<5 && sumaactual<21) {
					switch(counter) {
					case 2:
						manojn[counter] = decknum[counter+4];
						manojs[counter] = deckstr[counter+4];
						sumaactual = manojn[0] + manojn[1]+manojn[2];
						if(sumaactual>21) {
							carta3 =String.valueOf(manojn[counter] + " " + manojs[counter]);
							JOptionPane.showMessageDialog(null,"Tus cartas son: "+carta1 + " "+carta2+" "+carta3+ "| La suma es de "+ sumaactual);
							JOptionPane.showMessageDialog(null, "Perdiste el juego");
							reservaj =reservaj-apuestaactual;
							break;
							
						}
						else {
						carta3 =String.valueOf(manojn[counter] + " " + manojs[counter]);
						JOptionPane.showMessageDialog(null,"Tus cartas son: "+carta1 + " "+carta2+" "+carta3+ "| La suma es de "+ sumaactual);
						}
						break;
					case 3:
						manojn[counter] = decknum[counter+4];
						manojs[counter] = deckstr[counter+4];
						sumaactual = manojn[0] + manojn[1]+manojn[2]+manojn[3];
						if(sumaactual>21) {
							carta4 = String.valueOf(manojn[counter] + " " + manojs[counter]);
							JOptionPane.showMessageDialog(null,"Tus cartas son: "+carta1 + " "+carta2+" "+carta3+ " "+ carta4+ "| La suma es de "+ sumaactual);
							JOptionPane.showMessageDialog(null, "Perdiste el juego");
							reservaj =reservaj-apuestaactual;
							break;
							
						}
						else {
						carta4 = String.valueOf(manojn[counter] + " " + manojs[counter]);
						JOptionPane.showMessageDialog(null,"Tus cartas son: "+carta1 + " "+carta2+" "+carta3+ " "+ carta4+ "| La suma es de "+ sumaactual);
						}
						break;
					case 4:
						manojn[counter] = decknum[counter+4];
						manojs[counter] = deckstr[counter+4];
						sumaactual = manojn[0] + manojn[1]+manojn[2]+manojn[3]+manojn[4];
						if(sumaactual<21) {
							carta5 = String.valueOf(manojn[counter] + " " + manojs[counter]);
							JOptionPane.showMessageDialog(null,"Tus cartas son: "+carta1 + " "+carta2+" "+carta3+ " "+ carta4+" " +carta5+"| La suma es de "+ sumaactual);
							JOptionPane.showMessageDialog(null, "¡Ganaste el juego!");
							break;
						}
						if(sumaactual>21) {
							carta5 = String.valueOf(manojn[counter] + " " + manojs[counter]);
							JOptionPane.showMessageDialog(null,"Tus cartas son: "+carta1 + " "+carta2+" "+carta3+ " "+ carta4+" " +carta5+"| La suma es de "+ sumaactual);
							JOptionPane.showMessageDialog(null, "Perdiste el juego");
							reservaj =reservaj-apuestaactual;
							break;
						}
						else {
						carta5 = String.valueOf(manojn[counter] + " " + manojs[counter]);
						JOptionPane.showMessageDialog(null,"Tus cartas son: "+carta1 + " "+carta2+" "+carta3+ " "+ carta4+" " +carta5+"| La suma es de "+ sumaactual);
						}
						break;
						
				}
			}
				else {
					JOptionPane.showMessageDialog(null,"Tus cartas son: "+carta1 + " "+carta2+" "+carta3+ " "+ carta4+" " +carta5+"| La suma es de "+ sumaactual);
					JOptionPane.showMessageDialog(null, "No puedes tomar más cartas");
				}
			 
		}
		
		if(op.equals("2")){
			while(sumadecasa < 21){
				int countercasa = 1;
			if(sumadecasa<=15) {
				countercasa++;
				switch(countercasa) {
				case 2:
					manocn[countercasa] = decknum[countercasa+9];
					sumadecasa = manocn[0] + manocn[1]+manocn[2];
					if(sumadecasa>21) {
						JOptionPane.showMessageDialog(null, "Ganas el juego");
						reservaj =reservaj+apuestacasa;
						reservac= reservac - apuestacasa; 
						break;				
					}
				case 3:
					manocn[countercasa] = decknum[countercasa+9];
					sumadecasa = manocn[0] + manocn[1]+manocn[2]+manocn[3];
					if(sumadecasa>21) {
						carta4 = String.valueOf(manocn[countercasa] + " " + manojs[countercasa]);
						JOptionPane.showMessageDialog(null, "Ganaste el juego");
						reservaj =reservaj+apuestacasa;
						reservac= reservac - apuestacasa;
						break;						
					}
					break;
				case 4:
					manocn[countercasa] = decknum[counter+9];
					sumadecasa = manocn[0] + manocn[1]+manocn[2]+manocn[3]+manocn[4];
					if(sumadecasa<21) {
						JOptionPane.showMessageDialog(null, "¡La casa gana!");
						reservac = reservac + apuestaactual;
						reservac= reservac - apuestacasa;
						break;					}
			}
			}
			else{
				break;
			}
		}
		if(sumadecasa ==21) {
			reservaj = reservaj + apuestacasa;
			reservac = reservac-apuestacasa;
		}
		System.out.println(reservaj);
	}
		}
	}
		}
}
}