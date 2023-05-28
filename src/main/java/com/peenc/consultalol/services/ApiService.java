package com.peenc.consultalol.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Service
public class ApiService {
	
	@Autowired
    private RestTemplate restTemplate;


    @Value("${API_KEY}")
    private String  API_KEY;

    public String getJsonFromExternalApi(String url) throws JsonProcessingException {
        String jsonResponse = restTemplate.getForObject(url, String.class);
        return jsonResponse;
    }

    public String getKey() {
    	return API_KEY;
    }
}

