package main;

import java.util.List;

import persistence.PersistenceUtil;
import persistence.QueryFailure;
import model.Failure;
import model.MySqlTable;

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
	
	private QueryFailure qf = new QueryFailure();

	public List<MySqlTable> getAll() {
		List<MySqlTable> failures = qf.findAllRows();
		return failures;
	}
	
	public Failure getFailureById(int failureId){
		Failure failure = (Failure) qf.findRowById(failureId);
		return failure;
	}
}