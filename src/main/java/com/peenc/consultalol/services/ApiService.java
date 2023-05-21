package com.peenc.consultalol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
	
	@Autowired
    private RestTemplate restTemplate;
    @Value("${API_KEY}")
    private String  API_KEY;

    public String getJsonFromExternalApi(String url) {
        String jsonResponse = restTemplate.getForObject(url, String.class);
        return jsonResponse;
    }
    
    public String getKey() {
    	return API_KEY;
    }
}

