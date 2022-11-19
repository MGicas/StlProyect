package edu.uco.stl.crosscutting.helper;

import java.sql.Date;
import java.time.LocalDate;

public class DateHelper {
	
	 private static final LocalDate defaultDate = LocalDate.of(0001, 1, 1);

	    private DateHelper() {
	    	super();
	    }
	
	 public static final Date getDeafultDate() { 
	        return Date.valueOf(defaultDate);
	    }

}
