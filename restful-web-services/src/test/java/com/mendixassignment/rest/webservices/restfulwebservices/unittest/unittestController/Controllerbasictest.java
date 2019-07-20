package com.mendixassignment.rest.webservices.restfulwebservices.unittest.unittestController;


import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class Controllerbasictest {


	
	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	public void contextLoads() throws JSONException
	
	{
		String response =
				this.restTemplate.getForObject("/dummy-recipes",
				String.class);
		JSONAssert.assertEquals("[{head:{title:\"Amaretto Cake\"}}]",response, false);
				}
		
		
}
		
	



