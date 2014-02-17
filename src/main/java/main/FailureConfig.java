package main;

import java.util.List;

import persistence.QueryFailure;
import model.Failure;
import model.MySqlTable;

public class FailureConfig extends AbstractTableConfig {

	public <T> MySqlTable getRowById(T id) {
		QueryFailure queryFailure = new QueryFailure();
		Failure failure = queryFailure.findRowById(id);
		return failure;
	}

	public List<MySqlTable> viewRow() {
		QueryFailure queryFailure = new QueryFailure();
		List<MySqlTable> failures = queryFailure.findAllRows();
		for(MySqlTable f:failures){
			System.out.println("Failure "+((Failure) f).getFailureId()+ " exists.");
		}
		return failures;
	}
}
