package unico;

import java.util.Calendar;
import java.util.Date;

public class Calcula {
	
	public float preco; 
	
	public float ValorPagar(Date entrada, Date saida){
		Calendar ent = Calendar.getInstance();
		ent.setTime(entrada);
		preco = (float) 2.5;
		Calendar sai = Calendar.getInstance();
		sai.setTime(saida);
		
		float pagar;
		pagar = (preco*(sai.getTimeInMillis()/60*1000) - (ent.getTimeInMillis()/60*1000)); 
		
		return pagar;
	}
	
	public void Preco(String reais, String centavos){
		float re;
		float cents;
		re = Float.parseFloat(reais);
		cents = Float.parseFloat(centavos);	
		preco = (re + (cents/100));
	}
}
