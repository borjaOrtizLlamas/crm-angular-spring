package com.borja.crm.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import com.borja.crm.dto.Worker;

public class WorkerIMPL implements WorkerDAO {

	
	SessionFactory sessionFactory;
	
	@Override
	public void insertWorker(Worker worker) {
		if(worker.isMarried()) {
			worker.setMarried1(1);
		}else {
			worker.setMarried1(0);
		}
		sessionFactory.getCurrentSession().save(worker);
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

}
