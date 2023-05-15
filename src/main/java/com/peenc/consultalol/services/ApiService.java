package com.peenc.consultalol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
	
	@Autowired
    private RestTemplate restTemplate;
    private final String  API_KEY = "RGAPI-46207d88-ea1e-467f-a8ae-7f16bd28194e";

    public String getJsonFromExternalApi(String url) {
        String jsonResponse = restTemplate.getForObject(url, String.class);
        return jsonResponse;
    }
    
    public String getKey() {
    	return API_KEY;
    }
}

