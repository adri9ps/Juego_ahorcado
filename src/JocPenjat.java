
import java.util.Scanner;

public class JocPenjat {

	public static void main(String[] args) {
		String paraulaEndevinar;
		String lletresErronies="";
		final int NUM_MAX_INTENTS=10;
		int numIntents=0;
		String paraulaAmbRatlles;
		
		paraulaEndevinar=demanaParaula();
		paraulaAmbRatlles=posaRatlles(paraulaEndevinar);
		joc(paraulaEndevinar,paraulaAmbRatlles,numIntents,NUM_MAX_INTENTS,lletresErronies);

	}
	
	public static String demanaParaula(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Escriu la paraula a endevinar");
		
		String palabraSecreta = sc.next();
		
		return palabraSecreta; 
	}

	public static String posaRatlles(String unaParaula){
		String pAmbRatlles=new String();
		for(int i=0;i<unaParaula.length();i++){
			pAmbRatlles+="-";
		}
		return pAmbRatlles; 
	}

	public static void joc(String pEndevinar, String pRatlles,int numIntents,  int TOTAL, String lletresErr){
		char lletraIntroduida;
		boolean lletraEnParaula=false;
		int numLletresPerDestapar=pEndevinar.length();
		
		Scanner sc=new Scanner(System.in);
		do{
			System.out.println("Escriu una lletra:");
			lletraIntroduida = sc.next().charAt(0);   // llegirem el primer caracter de la cadena introduïda
			lletraEnParaula = conteLaLletra(lletraIntroduida,pEndevinar);
			if(lletraEnParaula){
				// Destaparem de pRatlles les lletres iguals a lletraIntroduida
				pRatlles = destapaLletra(lletraIntroduida,pRatlles,pEndevinar);
				numLletresPerDestapar=comptaGuionets(pRatlles);
			}else{
				// Llevarem una vida
				numIntents++;
				//Afegirem la lletra a LLetres erronies
				lletresErr +=lletraIntroduida+",";
				dibuixarFigura(numIntents, lletresErr);
			}	
		}while((numIntents<TOTAL)&&(numLletresPerDestapar>0));
	
	}
	
	
	public static boolean conteLaLletra(char l,String paraula){
		// true si la lletra l esta en  paraula
		// false en cas contrari
		return ((paraula.indexOf(l)==-1)?false:true);
		/*
		if(paraula.indexOf(l)==-1){
			return false;
		}else{
			return true;
		}
		*/
	}
	
	
	public static String destapaLletra(char l,String ratlles,String original){
		// Recorreguem tots els caracters de la paraula original
		// Reconstruim de nou l'String ratlles
		String reconstruit="";
		
		for(int i=0;i<original.length();i++){
			if(original.charAt(i)==l){
				reconstruit+=l;
			}else{
				reconstruit += ratlles.charAt(i);
			}
		}
		return reconstruit;
	}
	
	public static int comptaGuionets(String paraulaAmbGuionets){
		int compta=0;
		for(int i=0;i<paraulaAmbGuionets.length();i++){
			if(paraulaAmbGuionets.charAt(i)=='-'){
				compta++;
			}
		}
		return compta;
	}
	
	public static void dibuixarFigura(int numIntents, String lletresErr){
		switch(numIntents){
		
		case 1:
			System.out.println(" ________________");
			System.out.println(" |              |                             Letras erroneas: "+lletresErr);			
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("/ \\");
			break;
		case 2:
			System.out.println(" ________________");
			System.out.println(" |              |                             Letras erroneas: "+lletresErr);			
			System.out.println(" |              O");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("/ \\");
			break;
		case 3:
			System.out.println(" ________________");
			System.out.println(" |              |                             Letras erroneas: "+lletresErr);			
			System.out.println(" |              O");
			System.out.println(" |              |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("/ \\");
			break;
		case 4:
			System.out.println(" ________________");
			System.out.println(" |              |                             Letras erroneas: "+lletresErr);			
			System.out.println(" |              O");
			System.out.println(" |              |");
			System.out.println(" |              |");
			System.out.println(" |");
			System.out.println("/ \\");
			break;
		case 5:
			System.out.println(" ________________");
			System.out.println(" |              |                             Letras erroneas: "+lletresErr);			
			System.out.println(" |              O");
			System.out.println(" |              |");
			System.out.println(" |             /|");
			System.out.println(" |");
			System.out.println("/ \\");
			break;
		case 6:
			System.out.println(" ________________");
			System.out.println(" |              |                             Letras erroneas: "+lletresErr);			
			System.out.println(" |              O");
			System.out.println(" |              |");
			System.out.println(" |             /|\\");
			System.out.println(" |");
			System.out.println("/ \\");
			break;
		case 7:
			System.out.println(" ________________");
			System.out.println(" |              |                             Letras erroneas: "+lletresErr);
			System.out.println(" |              O");
			System.out.println(" |              |");
			System.out.println(" |             /|\\");
			System.out.println(" |             /");
			System.out.println("/ \\");
			break;
		case 8:
			System.out.println(" ________________");
			System.out.println(" |              |                             Letras erroneas: "+lletresErr);			
			System.out.println(" |              O");
			System.out.println(" |              |");
			System.out.println(" |             /|\\");
			System.out.println(" |             / \\");
			System.out.println("/ \\");
			break;
		case 9:
			System.out.println(" ________________");
			System.out.println(" |              |                             Letras erroneas: "+lletresErr);			
			System.out.println(" |              O");
			System.out.println(" |              |");
			System.out.println(" |             /|\\");
			System.out.println(" |            _/ \\");
			System.out.println("/ \\");
			break;
		case 10:
			System.out.println(" ________________");
			System.out.println(" |              |                             Letras erroneas: "+lletresErr);			
			System.out.println(" |              O");
			System.out.println(" |              |");
			System.out.println(" |             /|\\");
			System.out.println(" |            _/ \\_");
			System.out.println(" |      HAS PERDIDO");
			System.out.println("/ \\");
			break;
	}
	}
}