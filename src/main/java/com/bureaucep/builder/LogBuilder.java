package com.bureaucep.builder;

import java.time.LocalDateTime;

import com.bureaucep.entify.Log;

public class LogBuilder {

	public static Log build(String request, String response) {

		return Log.builder()
				.request(request)
				.response(response)
				.dtIncl(LocalDateTime.now())
				.build();
	}

}
