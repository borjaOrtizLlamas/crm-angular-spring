package com.borja.crm.controller;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.borja.crm.dao.WorkerDAO;
import com.borja.crm.dto.RequestDTO;
import com.borja.crm.dto.Worker;

@Controller
@RequestMapping(value = "worker")
public class WorkerController {

	
    private static final Logger LOGGER = Logger.getLogger(WorkerController.class.getName());

	@Autowired
	WorkerDAO serviceWorkers;


	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String workerFrom(Map<String, Object> model) {
		return "workerForm";
	}


	@RequestMapping(value = "menu", method = RequestMethod.GET)
	public String workerMenu (Map<String, Object> model) {
		return "workerMenu";
	}

	@ResponseBody
	@RequestMapping(value = "addWorker", method = RequestMethod.POST)
	public RequestDTO workerFromAdd(Map<String, Object> model, @RequestBody Worker usuario) {
		try{
			serviceWorkers.insertWorker(usuario);
		}catch (Exception e) {
		 	LOGGER.warning("Localized menssage:" + e.getLocalizedMessage());
			LOGGER.warning("Menssage:"+e.getMessage());
			LOGGER.warning(e.getClass().getName());
			
			RequestDTO dto = new RequestDTO();
			dto.setError(true); 
			dto.setNameError(e.getMessage());
			return dto; 
		}
		RequestDTO dto = new RequestDTO();
		dto.setError(false); 
		dto.setNameError(null);
		return dto;
	}

		
	@ResponseBody
	@RequestMapping(value = "allWorker", method = { RequestMethod.POST, RequestMethod.GET })
	public RequestDTO getAllWorker() {
		RequestDTO dto = new RequestDTO();
		try {
			dto.setObjects(serviceWorkers.allWorkers());
			dto.setError(false);
		} catch (Exception e) {
			dto.setError(true);
			dto.setNameError(e.getMessage());
		}
		dto.setError(false);
		return dto;
	}

	@ResponseBody
	@RequestMapping(value = "allWorkerActive", method = { RequestMethod.POST, RequestMethod.GET })
	public RequestDTO getAllWorkerActive() {
		RequestDTO dto = new RequestDTO();
		try {
			dto.setObjects(serviceWorkers.allWorkersActive());
			dto.setError(false);
		} catch (Exception e) {
			dto.setError(true);
			dto.setNameError(e.getMessage());
		}
		return dto;
	}

	@ResponseBody
	@RequestMapping(value = "AllWorkerInactive", method = { RequestMethod.POST, RequestMethod.GET })
	public RequestDTO getAllWorkerInactive() {
		RequestDTO dto = new RequestDTO();
		try {
			dto.setObjects(serviceWorkers.allWorkersInactive());
			dto.setError(false);
		} catch (Exception e) {
			dto.setError(true);
			dto.setNameError(e.getMessage());
		}
		return dto;
	}

	public WorkerDAO getServiceWorkers() {
		return serviceWorkers;
	}

	public void setServiceWorkers(WorkerDAO serviceWorkers) {
		this.serviceWorkers = serviceWorkers;
	}

}
