package com.example.api;

import com.example.api.model.*;
import com.example.api.*;
import com.example.api.logservices.LogController;
import com.example.api.logservices.LogRepository;

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.api.model.Log;
import com.google.gson.Gson;

 @RunWith(SpringRunner.class)
 @SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT, classes=Log.class)
public class SpringBootApplicationTests {
	 
	 @LocalServerPort
	 private int port;
	
	@Autowired
	private LogRepository logrepository;
	
	@Autowired
	private LogController logcontroller;
	

	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	
//	@Test
//	public void testAddLogSuccess() throws URISyntaxException{
//		final String baseUrl = "http://localhost:8080/log";
//		URI uri = new URI(baseUrl);
//		
//		String json = "{\"userId\":\"ABC123XYZ\",\"sessionId\":\"XYZ456ABC\",\"actions\":[{\"time\":\"2018-10-18T21:37:28-06:00\",\"type\":\"CLICK\",\"properties\":{\"locationX\":52,\"locationY\":11}},{\"time\":\"2018-10-18T21:37:30-06:00\",\"type\":\"VIEW\",\"properties\":{\"viewedId\":\"FDJKLHSLD\"}},{\"time\":\"2018-10-18T21:37:30-06:00\",\"type\":\"NAVIGATE\",\"properties\":{\"pageFrom\":\"communities\",\"pageTo\":\"inventory\"}}]}";
//
//		headers.set("X-COM-PERSIST", "true");
//		HttpEntity<String> request = new HttpEntity<>(json, headers);
//		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
//		
//		Assert.assertEquals(201,result.getStatusCodeValue());
//
//	}
	
	@Test
	public void testAddLog() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:8080/log", HttpMethod.POST, entity, String.class);
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		assertTrue(actual.contains("log"));
	}
}
