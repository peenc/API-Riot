package com.peenc.consultalol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.peenc.consultalol.models.SummonerDTO;
import com.peenc.consultalol.services.SummonerService;

@Controller
public class IndexController {

	@Autowired
	SummonerService ss;
	
    @RequestMapping("/")
    public String paginaIncial(){
        return "index";
    }
    
    @PostMapping("/")
	public String findByNameInvocador(String name) throws JsonProcessingException {
		if(name == "") {
			return "redirect:/";
		}
		try {
			SummonerDTO invocador = ss.getSummoner(name); 
		}catch(Exception e){
				return "redirect:/";
		}		
		
		return "redirect:/invocador/" + name;
	}
    
    @GetMapping("/teste")
    public ResponseEntity<List<Integer>> freeWeek() throws JsonMappingException, JsonProcessingException{
    	List<Integer> list = ss.getFreeWeek();
    	return ResponseEntity.ok(list);
    	
    }
    

}
