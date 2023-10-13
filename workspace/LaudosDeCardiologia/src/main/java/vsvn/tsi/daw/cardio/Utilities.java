package vsvn.tsi.daw.cardio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilities {
	
	  public static String ConverteDataHora(Calendar data_Hora) {
	        long timestamp = data_Hora.getTimeInMillis(); 

	        Date date = new Date(timestamp); 

	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	        String formattedDate = dateFormat.format(date);

	        return formattedDate;
	    }
	  public static String ConverteData(Calendar data) {
		  long timestamp = data.getTimeInMillis(); 
		  
		  Date date = new Date(timestamp); 
		  
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		  String formattedDate = dateFormat.format(date);
		  
		  return formattedDate;
	  }

}
