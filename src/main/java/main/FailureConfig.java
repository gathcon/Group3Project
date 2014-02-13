package main;

import persistence.PersistenceUtil;
import model.Failure;

public class FailureConfig {

	public FailureConfig(){
	}
	
	public void createFailure(int failureId, String description){
		Failure failure = new Failure();
		failure.setFailureId(failureId);
		failure.setDescription(description);
		PersistenceUtil.persist(failure);
		System.out.println("Failure registered");
	}
	
	public void deleteFailure(int failureId){
		Failure failure = getFailureById(failureId);
		PersistenceUtil.remove(failure);
		System.out.println("Failure deleted");
	}
	
	public Failure getFailureById(int failureId){
		Failure failure = PersistenceUtil.findFailureById(failureId);
		return failure;
	}
}