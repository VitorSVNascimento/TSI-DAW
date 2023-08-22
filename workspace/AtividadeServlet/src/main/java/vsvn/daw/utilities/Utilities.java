package vsvn.daw.utilities;

public class Utilities {

	public static int fatorial(int number) {
		  int i,fact=1;  
		  for(i=1;i<=number;i++){    
		      fact=fact*i;    
		  }    
		  return fact;
	}
	
	public static float imcCalc(float altura,float peso) {
		return peso / (altura * altura);
	}
	
	public static String imcMsg(float imc) {
		if(imc < 18.5)
			return "Cuidado! Você está muito abaixo do peso!";
		if(imc < 25)
			return "Parabéns! Você está em seu peso ideal!";
		if(imc < 30)
			return "Atenção! Você está acima de seu peso ideal!";
		if(imc < 35)
			return "Atenção! Obesidade grau 1!";
		if(imc < 40)
			return "Cuidado! Obesidade grau 2!";
		return "Cuidado! Obesidade grau 3!";
		
	}
	
}
