import java.util.Scanner;
import java.lang.Math;

public class RockPaperScissors {
	
	static Scanner skender = new Scanner(System.in);
	static boolean repetitor = true;
	static boolean killSwitch = false;
	static int scorePlayer = 0;
	static int scoreCpu = 0;
	
    public static void main(String args[]) throws InterruptedException{
     
	//TITLE print-out:
	System.out.println("");
	System.out.println("    ************************************");
	System.out.println("    * ROCK, PAPER, SCISSORS - The game *");
	System.out.println("    ************************************\n");
	
	/*UBER WHILE(repetitor) LOOP - if it's a tie, the input repeats:
	  This 'while' was added later on so the program can 
	  count player's and CPU's score (the first one to 
	  reach 3 points wins). It also repeats itself in 
	  case of a 'tie' outcome. Because of that the code
	  looka a little bit weird regarding the indentations.*/
	while(repetitor){
		
	System.out.println("*** Please choose ROCK, PAPER or SCISSORS. ***");
	System.out.println("      (Type \"quit\" to end the game.)\n");
	System.out.print("Your choice: ");
	
	//Checks if input is correct (equals to "rock" or "paper" or "scissors".):
	boolean loopSwitch = true;
	String myInput = "";
	String urInput = rnd();
	while(loopSwitch){
		myInput = skender.nextLine();
			if(myInput.equalsIgnoreCase("rock")||myInput.equalsIgnoreCase("paper")||myInput.equalsIgnoreCase("scissors") ){
				myInput = myInput.toUpperCase();
				loopSwitch=false;}
			//Type 'quit' to exit the program:
			else if (myInput.equalsIgnoreCase("quit") ){killSwitch = true; break;}	
			else{
				//When the input is incorrect - goes back to beginning:
				System.out.println("\nWRONG INPUT! The input is not case sensitive but be careful of the SPELLING.\n");
				System.out.println("Choose from: rock, paper, scissors");
				loopSwitch=true;				
			}		
		}	
	
	//Exits the program:
	if(killSwitch == true ){
		break;
	}
	
	//RPS - graphic:
	System.out.println(""); ropesi("ROCK");	ropesi("PAPER"); ropesi("SCISSORS");
	System.out.println("");
	dly(500);
		
	//OUTPUT:
	System.out.print(" "+myInput);
	dotdotdot();
	System.out.print("vs");
	dotdotdot();
	System.out.print(urInput);
	System.out.println("\n");
	versus(myInput, urInput);
	System.out.println("");
		
	//Score print-out:
	System.out.println("########################");
	System.out.println("# Current score is:    #");
	System.out.println("# Player:........... " + scorePlayer +" #");
	System.out.println("# Computer:......... " + scoreCpu +" #");
	System.out.println("########################\n");
	
	//Ends the program when one of the two reaches the score of 3:
	if(scorePlayer == 3 || scoreCpu == 3){
		repetitor = false;
		if(scorePlayer > scoreCpu){System.out.println("\n CONGRATULATIONS! YOU ARE THE WINNER!");}
		else{System.out.println("\n SORRY, LOSER! BETTER LUCK NEXT TIME.");}
		}
	
	}//END OF UBER WHILE LOOP!
	
	
	/* END MAIN */
    }
	
	/* METHODS */	
	
	//Delay (1000 = 1 sec):
	public static void dly(int x) throws InterruptedException{
		Thread.sleep(x);
	}
		
	//Score comparator - compares player's input to the CPU's random value: 
	public static void versus(String my, String ur) throws InterruptedException{
		
		String r = "rock"; String p = "paper"; String s = "scissors";
		
		if	   (my.equalsIgnoreCase(r)&&ur.equalsIgnoreCase(p) )
			{defeat(); scoreCpu++;}
		else if(my.equalsIgnoreCase(r)&&ur.equalsIgnoreCase(s) )
			{victory(); scorePlayer++;}
		else if(my.equalsIgnoreCase(p)&&ur.equalsIgnoreCase(r) )
			{victory(); scorePlayer++;}
		else if(my.equalsIgnoreCase(p)&&ur.equalsIgnoreCase(s) )
			{defeat(); scoreCpu++;}
		else if(my.equalsIgnoreCase(s)&&ur.equalsIgnoreCase(r) )
			{defeat(); scoreCpu++;}
		else if(my.equalsIgnoreCase(s)&&ur.equalsIgnoreCase(p) )
			{victory(); scorePlayer++;}
		else{System.out.println(" IT'S a TIE\n TRY AGAIN"); repetitor=true;}
	}
	
	//Randomizator - chooses a random value as CPU's input:
	public static String rnd (){
		String[] znakci = {"ROCK","PAPER","SCISSORS"};
		int x = (int) (Math.random()*3);
		return znakci[x];
	}
	
	//Graphic print-out between input and output:
	public static void ropesi(String str) throws InterruptedException{
		int t = 100;
		System.out.println(" "+str); dly(t);
		System.out.println(" ."); dly(t);
		System.out.println("  ."); dly(t);
		System.out.println("   ."); dly(t);
		System.out.println("    ."); dly(t);
		System.out.println("   ."); dly(t);
		System.out.println("  ."); dly(t);
		System.out.println(" ."); dly(t);
	}
	
	//Graphic print-out of the outcome:
	public static void dotdotdot() throws InterruptedException{
		int t = 70;
		for(int i=1;i<4;i++){
			dly(t); System.out.print(" . "); dly(t);			
		}
	}

	//VICTORY graphic print-out of the outcome:
	public static void victory() throws InterruptedException{
		int x = 200;
		System.out.println("");
		System.out.println("***********************");
		System.out.print("*      ");
		System.out.print("Y"); dly(x);
		System.out.print("O"); dly(x);
		System.out.print("U"); dly(x);
		System.out.print(" "); dly(x);
		System.out.print(" "); dly(x);
		System.out.print("W"); dly(x);
		System.out.print("O"); dly(x);
		System.out.print("N"); dly(x);
		System.out.print("!"); dly(x);
		System.out.println("      *");
		System.out.println("***********************\n");
		System.out.print("           ");
		System.out.print("="); dly(x);
		System.out.print(")"); dly(x);
		System.out.print("          \n");
	}
	
	//DEFEAT graphic print-out of the outcome:
	public static void defeat() throws InterruptedException{
		int x = 200;
		System.out.println("");
		System.out.println("***********************");
		System.out.print("*      ");
		System.out.print("Y"); dly(x);
		System.out.print("O"); dly(x);
		System.out.print("U"); dly(x);
		System.out.print(" "); dly(x);
		System.out.print("L"); dly(x);
		System.out.print("O"); dly(x);
		System.out.print("S"); dly(x);
		System.out.print("T"); dly(x);
		System.out.print("!"); dly(x);
		System.out.println("      *");
		System.out.println("***********************\n");
		System.out.print("           ");
		System.out.print("="); dly(x);
		System.out.print("("); dly(x);
		System.out.print("          \n");
	}	
}