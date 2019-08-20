package com.bureaucep;

import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public abstract class AbstractRestTest {

	protected <T> String toJson(T t) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(t);
	}
	
	protected <T> T toObject(JSONObject json, Class<T> _class) throws Exception {
		return new ObjectMapper().readValue(json.toString(), _class); 
	}

	protected String buildApiPath(String path) {
		return path;
	}

}
