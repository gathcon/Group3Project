package Main;

import java.util.List;
import Persistence.PersistenceUtil;
import Entity.Failure;

public class FailureConfig {
	
	public static void main(String[] args){
		FailureConfig config = new FailureConfig();
	}

	public FailureConfig(){
		createFailure(1, "BAD EMERGENCY");
	}

	public void viewFailure(){
		List<Failure> failures = PersistenceUtil.findAllFailures();
		for(Failure f:failures){
			System.out.println("Failure "+f.getFailureId()+ " exists.");
		}
	}
	
	public void createFailure(int failure_id, String description){
		Failure failure = new Failure(failure_id, description);
		PersistenceUtil.persist(failure);
		System.out.println("Failure registered");
	}			
}
