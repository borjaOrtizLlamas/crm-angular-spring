package com.borja.crm.dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

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
		Serializable i = sessionFactory.getCurrentSession().save(worker);
		LOGGER.info("Serializable res:" + i.toString());
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
	public boolean isDniInBBDD(String dni) {
		if (sessionFactory.getCurrentSession().getNamedQuery("getWokerByDni").setParameter(0, dni).list().size() == 0) return false;
		else return true; 
	}

}
