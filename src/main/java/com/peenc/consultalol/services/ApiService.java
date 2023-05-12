package com.peenc.consultalol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
	
	@Autowired
    private RestTemplate restTemplate;
    private final String  API_KEY = "RGAPI-f3b89bdf-56a3-4ad4-bed7-dc60f5762b8a";

    public String getJsonFromExternalApi(String url) {
        String jsonResponse = restTemplate.getForObject(url, String.class);
        return jsonResponse;
    }
    
    public String getKey() {
    	return API_KEY;
    }
}

