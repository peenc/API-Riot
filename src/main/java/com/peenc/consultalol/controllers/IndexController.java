package com.peenc.consultalol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.peenc.consultalol.modelsDTO.SummonerDTO;
import com.peenc.consultalol.services.IndexService;
import com.peenc.consultalol.services.SummonerService;

@Controller
public class IndexController {

	@Autowired
	SummonerService ss;
	
	@Autowired
	IndexService is;
	
    @RequestMapping("/")
    public String homePage(){
        return "index";
    }
    
    @PostMapping("/")
	public String findByNameInvocador(String name) throws JsonProcessingException {
		if(name == "") {
			return "redirect:/";
		}
		try {
			SummonerDTO invocador = ss.getSummonerDTO(name); 
		}catch(Exception e){
				return "redirect:/";
		}		
		
		return "redirect:/" + name;
	}
    
    @GetMapping("/teste")
    public ResponseEntity<List<Integer>> freeWeek() throws JsonMappingException, JsonProcessingException{
    	List<Integer> list = is.getFreeWeek();
    	return ResponseEntity.ok(list);
    	
    }
	@GetMapping("/")
	public ModelAndView showIconFreeWeek() throws JsonProcessingException {
		ModelAndView mv = new ModelAndView("index");
		List<String> icons = is.getUrlListIcon();
		mv.addObject("icons", icons);
		return  mv;
	}
}
