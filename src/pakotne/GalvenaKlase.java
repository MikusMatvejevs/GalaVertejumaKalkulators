package pakotne;

import java.text.DecimalFormat;
import java.util.Scanner;

import Pakotne.Kalkulators;
import Pakotne.kartosana;
import Pakotne.nolasitd;

public class GalvenaKlase {
	
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		int izvele;
		int kritSk=0, studSk=0;

        do {
            System.out.println("1 - Ievadīt audzēkņus");
            System.out.println("2 - Ievadīt kritērijus");
            System.out.println("3 - Ievadīt kritēriju svarus");
            System.out.println("4 - Ievadīt vērtējumus");
            System.out.println("5 - Labot kritēriju");
            System.out.println("6 - Labot kritērija svaru");
            System.out.println("7 - Labot iegūto vērtējumu");
            System.out.println("8 - Aprēķināt gala vērtējumu");
            System.out.println("9 - Saglabāt rezultātus failā");
            System.out.println("7 - Nolasīt rezultātus no faila");
            System.out.println("0 - Beigt darbu");

            izvele = scan.nextInt();

            switch (izvele) {

            case 1:
                Metodes.SkIevade(studSk);
                break;

            case 2:
            	Metodes.KritIevade(kritSk, studSk);
                break;

            case 3:
               Metodes.KritDefine(args, null);
                break;

            case 4:
                Metodes.VertKrit(null, args, args);
                break;
                
            case 5:
            	
            default:
                System.out.println("Tāda darbība neeksistē!");
                break;
            }
            
        } while (izvele != 4);
       scan.close();
	}
}