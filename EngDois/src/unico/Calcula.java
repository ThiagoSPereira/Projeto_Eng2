package unico;

import java.util.Calendar;
import java.util.Date;

public class Calcula {
	
	public static float preco;
	
	public Calcula(){
		preco = (float) 2.5;
	}
	
	public String ValorPagar(Date entrada, Date saida){
		Calendar ent = Calendar.getInstance();
		ent.setTime(entrada);
		Calendar sai = Calendar.getInstance();
		sai.setTime(saida);
		
		
		float pagar;
		pagar = (preco*(sai.getTimeInMillis()/60*1000) - (ent.getTimeInMillis()/60*1000)); 
		String valor;
		valor = pagar+"";
		
		return valor;
	}
	
	public void Preco(String reais, String centavos){
		float re;
		float cents;
		re = Float.parseFloat(reais);
		cents = Float.parseFloat(centavos);	
		preco = (re + (cents/100));
	}
}
