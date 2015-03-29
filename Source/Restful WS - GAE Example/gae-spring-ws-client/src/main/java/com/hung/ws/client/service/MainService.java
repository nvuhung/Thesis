package com.hung.ws.client.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.hung.ws.client.model.User;

public class MainService {
	public static void main(String[] args) {
		//callGetUser();
		callGetListUser();
		//showInfoUser();
		//getAddress();
	}
	
	public static void callGetUser() {
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("http://localhost:8080/gae-spring-ws/user/getuser", User.class);
		System.out.println(user);
	}
	
	public static void callGetListUser() {
		String urlLocal = "http://localhost:8080/gae-spring-ws/user/getlistuser";
		String urlCloud = "http://nvuhung-ws.appspot.com/user/getlistuser";
		RestTemplate restTemplate = new RestTemplate();
		User[] arrayUser = restTemplate.getForObject(urlCloud, User[].class);
		List<User> listUser = Arrays.asList(arrayUser);
		for (User user : listUser) {
			System.out.println(user);
		}
	}
	
	public static void showInfoUser() { 
		User user = new User("nvuhungit", "123456", 350);
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject("http://localhost:8080/gae-spring-ws/user/showuser", user, String.class);
		System.out.println(result);
	}
	
	public static void getAddress() {
		RestTemplate restTemplate = new RestTemplate();
		// 1: Hard code url
		/*String url = "http://localhost:8080/gae-spring-ws/user/address?";
		String param1 = "district=" + "Thu Duc";
		String param2 = "&city=" + "Ho Chi Minh";
		url += param1 + param2;
		String result = restTemplate.getForObject(url, String.class);
		System.out.println(result);*/
		
		// 2: Using Uri
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/gae-spring-ws/user/address/")
		        .queryParam("district", "Thu Duc")
		        .queryParam("city", "Ho Chi Minh");

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<String> response = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, entity, String.class);
		System.out.println("--->Header: " + response.getHeaders());
		System.out.println("--->Body: " + response.getBody());
	}
 	
}
