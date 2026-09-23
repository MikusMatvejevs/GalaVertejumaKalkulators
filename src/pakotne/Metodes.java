package pakotne;

import java.text.DecimalFormat;

public class Metodes {

	 static void SkIevade(int studSk) {
		// Audzēkņu skaita ievade
			do {
				System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
				while(!GalvenaKlase.scan.hasNextInt()) {
					System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
					GalvenaKlase.scan.next();
				}
				studSk = GalvenaKlase.scan.nextInt();
			}while(studSk<1);
			String[] studenti = new String[studSk];
	 }
	 
	 static void KritIevade(int kritSk, int studSk) {
	// Vērtēšanas kritēriju skaita ievade
			do {
				System.out.println("Kāds būs kritēriju skaits?");
				while(!GalvenaKlase.scan.hasNextInt()) {
					System.out.println("Kāds būs kritēriju skaits?");
					GalvenaKlase.scan.next();
				}
				kritSk = GalvenaKlase.scan.nextInt();
			}while(kritSk<1);
			String[] kriteriji = new String[kritSk];
			int[] kriterijaSvars = new int[kritSk];
			int[][] kriterijaVertejums = new int[studSk][kritSk];
			double[] semestraVertejums = new double[studSk];
			
			GalvenaKlase.scan.nextLine();
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
	 
	 static void KritDefine(String kriteriji[], int kriterijaSvars[]) {
	// Definē kritērijus
			int maxSvars = 100, sk = 1;
			double atlSvars;
			for(int i=0; i<kriteriji.length; i++) {
				do {
					System.out.println("Ievadi "+(i+1)+". kritēriju");
					kriteriji[i] = GalvenaKlase.scan.nextLine().trim();
				} while(!kriteriji[i].matches("^[\\p{L} ]+$"));
				
				// Norāda katra kritērija svaru
				do {
					System.out.println("Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")");
					while(!GalvenaKlase.scan.hasNextInt()) {
						System.out.println("Ievadi "+(i+1)+". kritērija svaru");
						GalvenaKlase.scan.next();
					}
					kriterijaSvars[i] = GalvenaKlase.scan.nextInt();
					/* Minimālā KATRA ATLIKUŠĀ kritērija svars ir 5
					 * kopējai svaru vērtībai ir jābūt 100 (ne mazāk, ne vairāk)
					*/
					atlSvars = (maxSvars - kriterijaSvars[i]) / (double)(kriteriji.length - sk);
				} while(kriterijaSvars[i]>maxSvars || kriterijaSvars[i]<5 || 
					  (i != kriteriji.length-1 && kriterijaSvars[i] == maxSvars) ||
					  (i == kriteriji.length-1 && (maxSvars - kriterijaSvars[i])  > 0) 
					  || atlSvars < 5);
				maxSvars -= kriterijaSvars[i];
				sk++;
				GalvenaKlase.scan.nextLine();
			}
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
	 }
	 
	 static void GalaVert (int semestraVertejums[], String studenti[], String kriteriji[], int kriterijaSvars[], int kriterijaVertejums[][]) {
	// Gala vērtējuma aprēķināšana
			double rezultats;
			for(int i=0; i<studenti.length; i++) {
				rezultats=0;
				for(int j=0; j<kriteriji.length; j++) {
					rezultats += ((double) kriterijaSvars[j]/100)*kriterijaVertejums[i][j];
				}
				semestraVertejums[i] = (int) rezultats;
			}
	 }
	 
	 static void VertIzvad (int studenti[], String kriteriji[], int kriterijaVertejums[][], int semestraVertejums[], int kriterijaSvars[]) {
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
}
