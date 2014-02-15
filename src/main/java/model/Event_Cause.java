package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Event_Cause database table.
 * 
 */
@Entity
@NamedQuery(name="Event_Cause.findAll", query="SELECT e FROM Event_Cause e")
public class Event_Cause extends MySqlTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Event_CausePK id;

	private String description;

	//bi-directional many-to-one association to Base_Data
	@OneToMany(mappedBy="eventCause")
	private List<Base_Data> baseData;

	public Event_Cause() {
	}
	
	public Event_Cause(int cause_code, int event_id, String description) {
		super();
		Event_CausePK event_causePK = new Event_CausePK(cause_code, event_id);
		this.id = event_causePK;
		this.description = description;
	}

	public Event_CausePK getId() {
		return this.id;
	}

	public void setId(Event_CausePK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Base_Data> getBaseData() {
		return this.baseData;
	}

	public void setBaseData(List<Base_Data> baseData) {
		this.baseData = baseData;
	}

	public Base_Data addBaseData(Base_Data baseData) {
		getBaseData().add(baseData);
		baseData.setEventCause(this);

		return baseData;
	}

	public Base_Data removeBaseData(Base_Data baseData) {
		getBaseData().remove(baseData);
		baseData.setEventCause(null);

		return baseData;
	}
}