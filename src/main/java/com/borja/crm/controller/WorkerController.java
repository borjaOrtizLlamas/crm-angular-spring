package com.borja.crm.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.borja.crm.dao.WorkerDAO;
import com.borja.crm.dto.RequestDTO;
import com.borja.crm.dto.Worker;

@Controller
@RequestMapping(value = "worker")
public class WorkerController {

	@Autowired
	WorkerDAO serviceWorkers;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String holaMundo(Map<String, Object> model, @ModelAttribute("workers") List<Worker> usuario) {

		return "principal";
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
