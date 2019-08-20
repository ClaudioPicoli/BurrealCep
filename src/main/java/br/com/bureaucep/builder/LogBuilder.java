package br.com.bureaucep.builder;

import java.time.LocalDate;

import br.com.bureaucep.model.Log;

public class LogBuilder {

	public static Log buildLog(String request, String response) {

		return Log.builder().request(request).response(response).dtIncl(LocalDate.now()).build();
	}

}
