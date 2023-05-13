package com.peenc.consultalol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
	
	@Autowired
    private RestTemplate restTemplate;
    private final String  API_KEY = "RGAPI-ee15b9ae-42eb-4a21-a066-bf4a02683ba8";

    public String getJsonFromExternalApi(String url) {
        String jsonResponse = restTemplate.getForObject(url, String.class);
        return jsonResponse;
    }
    
    public String getKey() {
    	return API_KEY;
    }
}

