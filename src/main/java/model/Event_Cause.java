package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Event_Cause database table.
 * 
 */
@Entity
@NamedQueries( {
	@NamedQuery(name="Event_Cause.findAll", query="SELECT e FROM Event_Cause e"),
	@NamedQuery(name = "Event_Cause.findById", query = "SELECT e FROM Event_Cause e where e.id=:id"),
})
public class Event_Cause extends MySqlTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Event_CausePK id;

	private String description;

	//uni-directional many-to-one association to Base_Data
	@OneToMany(mappedBy="eventCause")
	private List<Base_Data> baseData;

	public Event_Cause() {
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
}