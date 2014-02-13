package Main;

import java.util.List;
import Persistence.PersistenceUtil;
import Entity.Event_Cause;

public class Event_CauseConfig {
	
	public static void main(String[] args){
		Event_CauseConfig config = new Event_CauseConfig();
	}

	public Event_CauseConfig(){
		createEvent_Cause(2, 4098, "RRC CONN SETUP-SUCCESS");
	}

	public void viewEvent_Cause(){
		List<Event_Cause> event_causes = PersistenceUtil.findAllEvent_Causes();
		for(Event_Cause ec:event_causes){
			System.out.println("Event_Cause "+ec.getId()+ " exists.");
		}
	}
	
	public void createEvent_Cause(int cause_code, int event_id, String description){			
		Event_Cause event_cause = new Event_Cause(cause_code, event_id, description);
		PersistenceUtil.persist(event_cause);
		System.out.println("Event_Cause registered");
	}			
}
