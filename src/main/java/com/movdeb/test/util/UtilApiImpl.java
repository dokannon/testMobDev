package com.movdeb.test.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movdeb.test.jsonmap.Character;

@Component
public class UtilApiImpl implements IUtilApi {

	@Value("${apiexterna}")
	private String apiUrl;

	public Character getExternalApiValues(Integer id) {

		String result = getRestTemplate().getForObject(apiUrl + id, String.class);
		ObjectMapper om = new ObjectMapper();
		Character character = null;

		try {
			character = om.readValue(result, Character.class);
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}

		return character;
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
