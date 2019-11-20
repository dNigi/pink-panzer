import java.util.Scanner;
import java.util.HashMap;

public class LoveCalculator {
	
	static Scanner skender = new Scanner(System.in);
	static boolean killSwitch = true;
	static String prvoIme = "";
	static String drugoIme = "";
	
    public static void main(String args[]) throws InterruptedException{
    /* MAIN */
	
	//TITLE graphic print-out:
	int timer1 = 100;
	int timer2 = 200;
	System.out.println("\n\n <3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3"); dly(timer1);
	System.out.println(" <3                            <3"); dly(timer1);
	System.out.println(" <3          L O V E           <3"); dly(timer1);
	System.out.println(" <3    C A L C U L A T O R     <3"); dly(timer1);
	System.out.println(" <3                            <3");
	System.out.println(" <3<3<3<3<3<3<3<3<3<3<3<3<3<3<3<3\n"); dly(timer2);  
		
	//First name processing:
	double avgPrvo = 0.0;
	System.out.print("   * Insert your name:  ");					
	while(killSwitch == true){
		String str = skender.nextLine(); 					
		prvoIme = str.toUpperCase();					
		int[] prvoImeArrInt = toAscii(prvoIme);				
		avgPrvo = avg(prvoImeArrInt);
	}
	
	killSwitch = true;
	System.out.println("");

	//Second name processing:			
	double avgDrugo = 0.0;
	System.out.print(" ~ Insert the second name: ");
	while(killSwitch == true){
		String str = skender.nextLine(); 					
		drugoIme = str.toUpperCase();					
		int[] drugoImeArrInt = toAscii(drugoIme);				
		avgDrugo = avg(drugoImeArrInt);
	}
	
	//Rezultat mora biti: (manjsi avg / vecji avg) * 100
	//if priredi tako da je manjsi deljeno vecji:
	double avgRez;
	int rez;
	
	//Nardi rezultat (rez): ki hrani procente.
	if(avgPrvo >= avgDrugo){
		avgRez = (avgDrugo/avgPrvo)*100;
		rez = (int) avgRez;
	}else{
		avgRez = (avgPrvo/avgDrugo)*100;
		rez = (int) avgRez;
	}
	
	/*PROBLEM:
	  vrednost rez bo vedno od 73 do 100, manjše vrednosti ne more dat.
	  Hocemo nardit program, ki lahko vrne tudi match, ki je manjsi od 73.

	  (ce damo 'A' in 'Z' - torej 65 in 90, bi hoteli, da je match cim nizji).
	  
	  Pseudo koda: niz stevil od 73 do 100 (28 stevil) bi "razsirili" 
	  na niz od 1 do 100. Dobimo neko konstanto, ce delimo 100 z 28 = 3,571428periodical
	  Ce nardimo HashMap, ki ima key= od 72 do 100 in value= od 1 do 28.
	  Z for loop gremo skozi kljuce - ko je enak 'rez', njegov value pomnozi s KONS.
	*/
	
	final double KONS = 3.571428;
	
	HashMap<Integer, Integer> hasis = new HashMap<Integer, Integer>();
		
	int j = 1;
	for(int i = 72; i < 101; i++){
		hasis.put(i, j);
		j++;
	}
			
	int match = (int) (hasis.get(rez)*KONS);
	
	/*
	pogoj, ki 'match' spusti iz 103 na 100. 
	Če pride perfect match (tipo 'a' in 'a' => 65/65 = 1 => 100%)
	ga KONS dvigne nad 100% (na 103%). Da je vse skupaj malo bolj "realno"
	top match spustimo na 100.
	*/
	if(match == 103){
		match -= 3;
	}
	
	//RESULT graphic print-out:
	
	System.out.print("\n      CALCULATING: "); srcki(400);
		
	System.out.print("         T");
	dly(75);System.out.print("h");
	dly(75);System.out.print("e");
	dly(75);System.out.print(" ");
	dly(75);System.out.print("m");
	dly(75);System.out.print("a");
	dly(75);System.out.print("t");
	dly(75);System.out.print("c");
	dly(75);System.out.print("h");
	dly(75);System.out.print(" ");
	dly(75);System.out.print("i");
	dly(75);System.out.print("s: ");
	dly(2000); System.out.println(match+"\n");
	    
	    	//SRCIC
	
	System.out.println("        @@@@@@           @@@@@@\r\n" + 
			"      @@@@@@@@@@       @@@@@@@@@@\r\n" + 
			"    @@@@@@@@@@@@@@   @@@@@@@@@@@@@@\r\n" + 
			"  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n" + 
			" @@@@\t\t\t\t  @@@@\r\n" + 
			"@@@@@\t    "+prvoIme+" && "+drugoIme+"\t  @@@@@\r\n" + 
			"@@@@@\t\t"+match+" %	\t  @@@@@\r\n" + 
			"@@@@@\t\t\t\t  @@@@\r\n" + 
			" @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n" + 
			"  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n" + 
			"   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n" + 
			"    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n" + 
			"      @@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n" + 
			"        @@@@@@@@@@@@@@@@@@@@@@@\r\n" + 
			"          @@@@@@@@@@@@@@@@@@@\r\n" + 
			"            @@@@@@@@@@@@@@@\r\n" + 
			"              @@@@@@@@@@@\r\n" + 
			"                @@@@@@@\r\n" + 
			"                  @@@\r\n" + 
			"                   @");

	
	
	
	//END
	

	
	/* END MAIN */
    }	
	/* METODE */
	
	//Delay:
	public static void dly(int x) throws InterruptedException{
		Thread.sleep(x);
	}
	
	//NOVA toAscii METODA:
	public static int[] toAscii(String s){
		int[] TomArraya = new int[s.length()];
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
				killSwitch = false;
				
			}else{
				System.out.println("\n       ! Error - wrong inout !");
				System.out.println(" Looks like there's a typo in the name.");
				System.out.println("    Be careful when writing names.");
				System.out.println("  If you have multiple first names");
				System.out.println("    type the names wihout spaces. \n");
				System.out.print  (" Please type the name again: ");
				
				killSwitch = true;
				break;
			}
			TomArraya[i] = s.charAt(i);
		}
		return TomArraya;
	}
	
	//avg: izracuna povprecno vrednost stevilk v tabeli:
	public static double avg (int[] tab){
		int sum = 0;
		for(int i=0;i<tab.length;i++){
			sum = sum+tab[i];
		}
		return sum/tab.length;
	}
	
	public static void srcki(int timer) throws InterruptedException{
		dly(timer);
		System.out.print(" <3"); dly(timer);
		System.out.print(" <3"); dly(timer);
		System.out.print(" <3"); dly(timer);
		System.out.println("\n");
	}
	
	
	
	
	
	
}
