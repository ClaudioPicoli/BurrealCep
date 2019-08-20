package com.bureaucep.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	public static String DataAtualFormata() {
		return localDateTimeToString(LocalDateTime.now(), "dd/MM/yyyy HH:mm:ss");
	}
	
	private static String localDateTimeToString(LocalDateTime localDateTime, String pattern) {
		return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
	}

}
