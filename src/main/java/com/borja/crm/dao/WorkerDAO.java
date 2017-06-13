package com.borja.crm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.borja.crm.dto.Worker;

@Repository
public interface WorkerDAO {
	
	@Transactional(readOnly = false)
	public void insertWorker(Worker worker);

	@Transactional(readOnly = true)
	public List<Worker> allWorkersActive();

	@Transactional(readOnly = true)
	public List<Worker> allWorkers();

	@Transactional(readOnly = true)
	public List<Worker> allWorkersInactive();
	
	@Transactional(readOnly = true)
	public boolean isDniInBBDD(String dni);



}
