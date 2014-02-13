package main;

import persistence.PersistenceUtil;
import model.Failure;


public class FailureConfig {
	
	public static void main(String[] args){
		new FailureConfig();
	}

	public FailureConfig(){
		createFailure(0, "description");
	}
	
	public void createFailure(int failureId, String description){
		Failure failure = new Failure();
		failure.setFailureId(failureId);
		failure.setDescription(description);
		PersistenceUtil.persist(failure);
		System.out.println("Failure registered");
	}
			

}
