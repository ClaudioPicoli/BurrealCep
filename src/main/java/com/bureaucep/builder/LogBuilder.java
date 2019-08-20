package com.bureaucep.builder;

import java.time.LocalDate;

import com.bureaucep.entify.Log;

public class LogBuilder {

	public static Log buildLog(String request, String response) {

		return Log.builder().request(request).response(response).dtIncl(LocalDate.now()).build();
	}

}
