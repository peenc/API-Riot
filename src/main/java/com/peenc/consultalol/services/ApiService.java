package com.peenc.consultalol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
	
	@Autowired
    private RestTemplate restTemplate;

    public String getJsonFromExternalApi(String url) {
        String jsonResponse = restTemplate.getForObject(url, String.class);
        return jsonResponse;
    }
    
    public String getKey() {
    	
    	return "?api_key=RGAPI-15f352b2-4954-464a-979f-10f4f28e85c4";
    }
}

