package pakotne;

import java.text.DecimalFormat;
import java.io.*;
import java.util.*;
public class Metodes {

	 static int SkIevade(int studSk) {
		// Audzēkņu skaita ievade
			do {
				System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
				while(!GalvenaKlase.scan.hasNextInt()) {
					System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
					GalvenaKlase.scan.next();
				}
				studSk = GalvenaKlase.scan.nextInt();
			}while(studSk<1);
			
			GalvenaKlase.scan.nextLine();
			return studSk;
	 }
	 
	 static int KritSkIevade(int kritSk, int studSk) {
	// Vērtēšanas kritēriju skaita ievade
			do {
				System.out.println("Kāds būs kritēriju skaits?");
				while(!GalvenaKlase.scan.hasNextInt()) {
					System.out.println("Kāds būs kritēriju skaits?");
					GalvenaKlase.scan.next();
				}
				kritSk = GalvenaKlase.scan.nextInt();
			}while(kritSk<1);
			
			GalvenaKlase.scan.nextLine();
			
			return kritSk;
			
	}
	 
	 static void VardIevade(String studenti[]) {
	// Ievada audzēkņu vārdus, uzvārdus
			for(int i=0; i<studenti.length; i++) {
				do {
					System.out.println("Ievadi "+(i+1)+". studentu");
					studenti[i] = GalvenaKlase.scan.nextLine().trim();
				} while(!studenti[i].matches("^[\\p{L} ]+$"));
			}
	 }
	 
	 static void KritIevade(String[] kriteriji) {
	// Definē kritērijus
			int maxSvars = 100, sk = 1;
			double atlSvars;
			for(int i=0; i<kriteriji.length; i++) {
				do {
					System.out.println("Ievadi "+(i+1)+". kritēriju");
					kriteriji[i] = GalvenaKlase.scan.nextLine().trim();
				} while(!kriteriji[i].matches("^[\\p{L} ]+$"));
	 }
			
	 static void SvaruIevade(int kriterijaSvars[], int maxSvars, int kriteriji[], double atlSvars) {
				// Norāda katra kritērija svaru
				GalvenaKlase.scan.nextLine();
			}
	 
	 static void VertKrit (int kriterijaVertejums[][], String studenti[], String kriteriji[]) {
	// Norāda vērtējumu kādu ieguvis katrs audzēknis par katru kritēriju
			for(int i=0; i<kriterijaVertejums.length; i++) {
				for(int j=0; j<kriterijaVertejums[i].length; j++) {
					do {
						System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
						while(!GalvenaKlase.scan.hasNextInt()) {
							System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
							GalvenaKlase.scan.next();
						}
						kriterijaVertejums[i][j] = GalvenaKlase.scan.nextInt();
					}while(kriterijaVertejums[i][j]<0 || kriterijaVertejums[i][j]>10);
				}
			}
			GalvenaKlase.scan.nextLine();
	 }
	 
	 static void LabotKriteriju(String [] kriteriji) {
		 System.out.println("Kritēriji:");
		 
		 for(int i=0; i<kriteriji.length; i++) {
			 System.out.println((i+1) + "-" + kriteriji[i]);
		 }
		 int nr;
		 
		 do {
			 System.out.println("Kuru kritēriju vēlies labot?");
			 
			 while(!GalvenaKlase.scan.hasNextInt()) {
				 GalvenaKlase.scan.next();
				 System.out.println("Ievadi kritērija numuru!");
			 }
			 nr = GalvenaKlase.scan.nextInt();
		 }while(nr<1 || nr>kriteriji.length);
		 
		 GalvenaKlase.scan.nextLine();
		 String jaunais;
		 
		 do {
			 System.out.println("Ievadi jauno kritērija nosaukumu: ");
			 jaunais = GalvenaKlase.scan.nextLine().trim();
		 }while(!jaunais.matches("^[\\p{L} ]+$"));
		 
		 kriteriji[nr-1] = jaunais;
		 
		 System.out.println("Kritērijs salabots!");
	 }
	 
	 static void LabotSvaru (int[] KriterijaSvars) {
		 System.out.println("Mainot svarus tie ir jāievada no jauna, lai kopējais svars paliktu 100%");
		 SvaruIevade(KriterijaSvars);
	 }
	 
	 static void LabotVertejumu(String[]studenti, String[] kriteriji, int[][]kriterijaVertejums) {
		 System.out.println("Studenti:");for (int i=0; i<studenti.length; i++) {
			 System.out.println((i+1) + "-" + studenti[i]);
		 }
		 
		 int studentaNr;
		 
		 do {
			 System.out.println("Izvēlies studentu:");
			 while(!GalvenaKlase.scan.hasNextInt()) {
				 GalvenaKlase.scan.next();
				 System.out.println("Ievadi studenta numuru!");
			 }
			 
			 studentaNr=GalvenaKlase.scan.nextInt();
		 }while(studentaNr<1 || studentaNr>studenti.length);
		 
		 System.out.println("Kritēriji:");
		 for(int i=0; i<kriteriji.length; i++) {
			 System.out.println((i+1) + "-" + kriteriji[i]);
		 }
		 
		 int kriterijaNr;
		 
		 do {
			 System.out.println("Izvēlies kritēriju:");
			 
			 while(!GalvenaKlase.scan.hasNextInt()) {
				 GalvenaKlase.scan.next();
				 System.out.println("Ievadi kritērija numuru!");
			 }
			 
			 kriterijaNr = GalvenaKlase.scan.nextInt();
		 }while(kriterijaNr<1 || kriterijaNr>kriteriji.length);
		 
		 int jaunaisVertejums;
		 
		 do {
			 System.out.println("Ievadi jauno vērtējumu (0-10)");
			 while(!GalvenaKlase.scan.hasNextInt()) {
				 GalvenaKlase.scan.next();
				 System.out.println("Ievadi skaitli no 0 līdz 10!");
			 }
			 
			 jaunaisVertejums=GalvenaKlase.scan.nextInt();
		 }while(jaunaisVertejums<0 || jaunaisVertejums>10);
		 GalvenaKlase.scan.nextLine();
		 
		 kriterijaVertejums[studentaNr-1][kriterijaNr-1]=jaunaisVertejums;
		 
		 System.out.println("Vērtējums izlabots!");
	 }
	 
	 static void GalaVert (double[] semestraVertejums, String studenti[], String kriteriji[], int kriterijaSvars[], int kriterijaVertejums[][]) {
	// Gala vērtējuma aprēķināšana
			double rezultats = 0;
			for(int i=0; i<studenti.length; i++) {
				rezultats=0;
				for(int j=0; j<kriteriji.length; j++) {
					rezultats += ((double) kriterijaSvars[j]/100)*kriterijaVertejums[i][j];
				}
				semestraVertejums[i] = (int) rezultats;
			}
	 }
	 
	 static void VertIzvad (String[] studenti, String kriteriji[], int[][] kriterijaVertejums, double[] semestraVertejums, int[] kriterijaSvars) {
	// Gala vērtējumu izvadīšana
		 DecimalFormat df = new DecimalFormat("0.#");
			for(int i=0; i<studenti.length; i++) {	
				for(int j=0; j<kriteriji.length; j++) {
					System.out.println("Studenta "+studenti[i]+" vērtējums par kritēriju "+kriteriji[j]+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+kriterijaSvars[j]);
				}
				System.out.println("Semestra vērtējums ir "+df.format(semestraVertejums[i])+" balles"
						+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
			}
	 }
	 
	 static void SaglabatFaila(String[] studenti, String[] kriteriji, int[] kriterijaSvars,
                              int[][] kriterijaVertejums, double[] semestraVertejums) {

        DecimalFormat df = new DecimalFormat("0.#");

        try {
            FileWriter writer = new FileWriter("rezultati.txt");

            for (int i = 0; i < studenti.length; i++) {
                writer.write("Students: " + studenti[i] + "\n");

                for (int j = 0; j < kriteriji.length; j++) {
                    writer.write("Kritērijs: " + kriteriji[j]
                            + " | Vērtējums: " + kriterijaVertejums[i][j]
                            + " | Svars: " + kriterijaSvars[j] + "%\n");
                }

                writer.write("Semestra vērtējums: " + df.format(semestraVertejums[i]) + "\n");
                writer.write("----------------------------------------\n");
            }

            writer.close();
            System.out.println("Rezultāti saglabāti failā rezultati.txt!");

        } catch (IOException e) {
            System.out.println("Kļūda saglabājot failu: " + e.getMessage());
        }
    }

    static void NolasitFailu() {
        try {
            File fails = new File("rezultati.txt");
            Scanner failaScan = new Scanner(fails);

            System.out.println("\n========== FAILA SATURS ==========");

            while (failaScan.hasNextLine()) {
                System.out.println(failaScan.nextLine());
            }

            System.out.println("==================================");
            failaScan.close();

        } catch (IOException e) {
            System.out.println("Neizdevās nolasīt failu. Iespējams, rezultāti vēl nav saglabāti.");
        }
    }
}
