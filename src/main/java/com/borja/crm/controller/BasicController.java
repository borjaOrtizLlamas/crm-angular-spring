package com.borja.crm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.borja.crm.dto.Worker;

@Controller
public class BasicController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String holaMundo(Map<String, Object> model){
		return "principal";
	}

	@RequestMapping(value = "/demoAngularJS", method = RequestMethod.GET)
	public String holaMundo2(Map<String, Object> model){
		return "demoAngularJS";
	}

	@ResponseBody
	@RequestMapping(value = "/pruebaGet", method = RequestMethod.GET)
	public  Worker dsadsa(Map<String, Object> model){
		Worker wo = new Worker(); 
		wo.setAddress("dsadsaadsa");
		wo.setAge(1221);
		wo.setName("dsadsadsa"); 
		return wo;
	}

	
	
	@RequestMapping(value = "/pruebas", method = RequestMethod.GET)
	public String peticion(){
		return "pruebas";
	}

	@RequestMapping(value = "/peticion", method = RequestMethod.GET)
	public String peticionFormulario(){
		
		return "principal";
	}
	
	@ResponseBody
	@RequestMapping(value = "/usuario/solo", method = RequestMethod.GET)
	public Worker peticionParaAlgoFormulario(HttpServletResponse response){
		Worker nuevoUsuario = new Worker(); 
		nuevoUsuario.setSurname("ortiz");
		nuevoUsuario.setMarried(false);
		nuevoUsuario.setSalary(14877);
		nuevoUsuario.setNumberSon(0);
		nuevoUsuario.setName("boja");
		return nuevoUsuario; 
	}

	@ResponseBody
	@RequestMapping(value = "/usuario/array", method = RequestMethod.GET)
	public List<Worker> peticionParaAlgoFormularioA(HttpServletResponse response){
		List<Worker> usuarios = new ArrayList<Worker>(); 
		
		Worker nuevoUsuario = new Worker(); 
		nuevoUsuario.setSurname("ortiz");
		nuevoUsuario.setMarried(false);
		nuevoUsuario.setSalary(14877);
		nuevoUsuario.setNumberSon(0);
		nuevoUsuario.setName("borja");
		usuarios.add(nuevoUsuario); 
		
		Worker nuevoUsuario1 = new Worker(); 
		nuevoUsuario1.setSurname("furula");
		nuevoUsuario1.setMarried(false);
		nuevoUsuario1.setSalary(14877);
		nuevoUsuario1.setNumberSon(0);
		nuevoUsuario1.setName("boja");
		usuarios.add(nuevoUsuario1); 
		
		Worker nuevoUsuario2 = new Worker(); 
		nuevoUsuario2.setSurname("adla");
		nuevoUsuario2.setMarried(true);
		nuevoUsuario2.setSalary(11);
		nuevoUsuario2.setNumberSon(30);
		nuevoUsuario2.setName("zzxcqa");
		usuarios.add(nuevoUsuario2); 
		
		return usuarios; 
	}
		
	
}
