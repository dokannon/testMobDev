package com.movdeb.test.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movdeb.test.jsonmap.Root;

@Component
public class UtilApiImpl implements IUtilApi{

	@Value("${apiexterna}")
	private String apiUrl;

	public Root getExternalApiValues(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(apiUrl + id, String.class);
		ObjectMapper om = new ObjectMapper();
		Root character = null;
		try {
			character = om.readValue(result, Root.class);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return character;
	}

}
