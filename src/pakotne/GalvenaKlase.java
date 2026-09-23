package pakotne;

import java.util.Scanner;

public class GalvenaKlase {
	
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		int izvele;
		int kritSk=0, studSk=0;

		String[] kriteriji = new String[kritSk];
		int[] kriterijaSvars = new int[kritSk];
		int[][] kriterijaVertejums = new int[studSk][kritSk];
		double[] semestraVertejums = new double[studSk];
		String[] studenti = new String[studSk];
		
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
            	studSk = Metodes.SkIevade(studSk);
            	studenti = new String[studSk];
            	semestraVertejums = new double[studSk];
            	
                Metodes.VardIevade(studenti);
                
                if(kritSk>0) {
                	kriterijaVertejums = new int [studSk][kritSk];
                }
                break;

            case 2:
            	kritSk = Metodes.KritSkIevade(kritSk);
            	kriteriji = new String [kritSk];
            	kriterijaSvars = new int[kritSk];
            	
            	Metodes.KritIevade(kriteriji);
            	if(studSk>0) {
                	kriterijaVertejums = new int [studSk];
                }
                break;

            case 3:
            	if(kriteriji==null) {
            		System.out.println("Vispirms ievadi kritērijus!");
            	}else {
            		Metodes.SvaruIevade(kriterijaSvars);
            	}
                break;

            case 4:
                if (studenti==null || kriteriji == null) {
                	System.out.println("Vispirms ievadi studentus un kritērijus!");
                }else {
                	if(kriterijaVertejums==null) {
                		kriterijaVertejums = new int [studSk][kritSk];
                	}
                Metodes.VertKrit(kriterijaVertejums, studenti, kriteriji);
                }
                break;
                
            case 5:
            	if(kriteriji == null) {
            		System.out.println("Nav ievadītu kritēriju!");
            	}else {
            		Metodes.LabotKriteriju(kriteriji);
            	}
            	break;
            	
            case 6:
            	if(kriterijaSvars==null) {
            		System.out.println("Nav ievadīti kritēriju svari!");
            	}else {
            		Metodes.LabotSvaru(kriterijaSvars)
            	}
            	break;
            	
            case 7:
            	if(kriterijaVertejums == null) {
            		System.out.println("Nav ievadītu vērtējumu!");
            	}else {
            		Metodes.LabotVertejumu(studenti, kriteriji, kriterijaVertejums);
            	}
            	break;
            	
            case 8:
            	if(studenti==null || kriteriji == null || kriterijaSvars == null || kriterijaVertejums ==null) {
            		System.out.println("Vispirms ievadi visus nepieciešamos datus!");
            	}else {
            		Metodes.GalaVert(semestraVertejums, studenti, kriteriji, kriterijaSvars, kriterijaVertejums);
            		Metodes.VertIzvad(studenti, kriteriji, kriterijaVertejums, semestraVertejums, kriterijaSvars);
            	}
            	break;
            
            case 9:
            	if(studenti==null || kriteriji == null || kriterijaSvars == null || kriterijaVertejums ==null) {
            		System.out.println("Nav datu ko saglabāt!");
            	}else {
            		Metodes.GalaVert(semestraVertejums, studenti, kriteriji, kriterijaSvars, kriterijaVertejums);
            		Metodes.VertIzvad(studenti, kriteriji, kriterijaSvars, kriterijaVertejums, semestraVertejums);
            	}
            case 10:
            	Metodes.NolasitFailu();
            	break;
            	
            case 0: System.out.println("Programma apturēta!"); break;
            default:
                System.out.println("Tāda darbība neeksistē!");
                break;
            }
            
        } while (izvele != 0);
       scan.close();
	}
}