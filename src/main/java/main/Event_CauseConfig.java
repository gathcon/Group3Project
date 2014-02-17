package main;

import java.util.List;

import persistence.QueryEvent_Cause;
import model.Event_Cause;
import model.MySqlTable;

public class Event_CauseConfig extends AbstractTableConfig{

	public List<MySqlTable> viewRow() {
		QueryEvent_Cause queryEvent_Cause = new QueryEvent_Cause();
		List<MySqlTable> event_causes = queryEvent_Cause.findAllRows();
		for(MySqlTable ec:event_causes){
			System.out.println("Event_Cause "+((Event_Cause) ec).getId()+ " exists.");
		}
		return event_causes;
	}

	public <T> MySqlTable getRowById(T id) {
		QueryEvent_Cause queryEvent_Cause = new QueryEvent_Cause();
		Event_Cause event_cause = queryEvent_Cause.findRowById(id);
		return event_cause;
	}
	
}
