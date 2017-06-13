package com.borja.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.borja.crm.dao.WorkerDAO;
import com.borja.crm.dto.RequestDTO;
import com.borja.crm.dto.Validacion;

@Controller
@RequestMapping(value = "valid")
public class Validaciones {

	@Autowired
	WorkerDAO serviceWorkers;

	@ResponseBody
	@RequestMapping(value = "isDniInBBDD", method =  RequestMethod.POST)
	public RequestDTO dniValidation(Map<String, Object> model, String dni ) {
		RequestDTO dto = new RequestDTO();
		try{
			Validacion val = new Validacion(); 
			val.setOK(serviceWorkers.isDniInBBDD(dni));
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
