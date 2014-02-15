package main;

import java.util.List;

import persistence.PersistenceUtil;
import persistence.QueryEvent_Cause;
import model.Event_Cause;
import model.Event_CausePK;

public class Event_CauseConfig {
	
	public static void main(String[] args){
		Event_CauseConfig config = new Event_CauseConfig();
	}

	public Event_CauseConfig(){
		createEvent_Cause(2, 5002, "RRC CONN SETUP-SUCCESS");
		Event_CausePK event_causePK = new Event_CausePK(0, 4097);
		deleteEvent_Cause(event_causePK);
	}

	public void viewEvent_Cause(){
		List<Event_Cause> event_causes = PersistenceUtil.findAllEvent_Causes();	//Need to return a list of Event_Causes instead of MySqlTables.
		for(Event_Cause ec:event_causes){
			System.out.println("Event_Cause "+ec.getId()+ " exists.");
		}
	}
	
	public void createEvent_Cause(int cause_code, int event_id, String description){			
		Event_Cause event_cause = new Event_Cause(cause_code, event_id, description);
		PersistenceUtil.persist(event_cause);
		System.out.println("Event_Cause registered");
	}	
	
	public void deleteEvent_Cause(Event_CausePK event_causePK){
		Event_Cause event_cause = getEvent_CauseById(event_causePK);
		PersistenceUtil.remove(event_cause);			//QueryFailure doesn't have delete failure method.
		System.out.println("Event_Cause deleted");
	}
	
	public Event_Cause getEvent_CauseById(Event_CausePK event_causePK){
		QueryEvent_Cause queryEvent_Cause = new QueryEvent_Cause();
		Event_Cause event_cause = queryEvent_Cause.findRowById(event_causePK);
		return event_cause;
	}
}
