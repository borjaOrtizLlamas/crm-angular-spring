package com.borja.crm.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import org.hibernate.SessionFactory;
import com.borja.crm.dto.Worker;

public class WorkerIMPL implements WorkerDAO {

    private static final Logger LOGGER = Logger.getLogger(WorkerIMPL.class.getName());
    
	SessionFactory sessionFactory;
	
	@Override
	public void insertWorker(Worker worker) {
		if(worker.isMarried()) {
			worker.setMarried1(1);
		}else {
			worker.setMarried1(0);
		}
		
		
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Worker>> validateConstraintViolations =     validator.validate(worker, GrupoParaValidar.class); 
		
        for (ConstraintViolation<Worker> validateConstraintViolation  : validateConstraintViolations) {
        	LOGGER.info(" validacion :" + validateConstraintViolation.getMessage());
		}
        
        
    	LOGGER.info("final validacion");

//		Serializable i = sessionFactory.getCurrentSession().save(worker);
//		LOGGER.info("Serializable res:" + i.toString());
	}


	@Override
	public List<Worker> allWorkersActive() {
		return sessionFactory.getCurrentSession().getNamedQuery("findAllWorkersActive").list(); 
	}

	@Override
	public List<Worker> allWorkers() {
		return sessionFactory.getCurrentSession().getNamedQuery("findAllWorkers").list(); 
	}

	@Override
	public List<Worker> allWorkersInactive() {
		return sessionFactory.getCurrentSession().getNamedQuery("findAllWorkersInactive").list();
	}

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean isDniInBBDD(String nif) {
		Worker workers = (Worker) sessionFactory.getCurrentSession()
				.getNamedQuery("getWokerByDni")
				.setParameter(0, nif)
				.uniqueResult();	

		if (workers == null) return true; 
		else return false; 
	}

}
