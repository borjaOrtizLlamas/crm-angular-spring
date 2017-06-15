package com.borja.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.borja.crm.dao.WorkerDAO;
import com.borja.crm.dto.RequestDTO;
import com.borja.crm.dto.Validacion;

@Controller
@RequestMapping(value = "valid")
public class ValidacionesController {

	@Autowired
	WorkerDAO serviceWorkers;

	@ResponseBody
	@RequestMapping(value = "isDniInBBDD/{nif}", method =  RequestMethod.POST)
	public RequestDTO dniValidation(Map<String, Object> model, @PathVariable("nif") String nif) {
		RequestDTO dto = new RequestDTO();
		try{
			Validacion val = new Validacion(); 
			val.setOK(serviceWorkers.isDniInBBDD(nif));
			dto.setObjet(val);
			dto.setError(false);
			return dto;
		}catch (Exception e) {
			dto.setError(true);
			dto.setNameError(e.getMessage());
			return dto;
		}
	}

	
}
