package br.com.bureauCepTest;

import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public abstract class AbstractRestTest {

	@Autowired
	protected MockMvc mvc;

	protected <T> String toJson(T t) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(t);
	}
	
	protected <T> T toObject(JSONObject json, Class<T> _class) throws Exception {
		return new ObjectMapper().readValue(json.toString(), _class); 
	}

	protected MockMvc getMockMvc() {
		return this.mvc;
	}

	protected String buildApiPath(String path) {
		return path;
	}

}
