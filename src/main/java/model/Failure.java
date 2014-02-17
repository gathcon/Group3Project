package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Failure database table.
 * 
 */
@Entity
@NamedQueries( {
	@NamedQuery(name = "Failure.findAll", query = "SELECT f FROM Failure f"),
	@NamedQuery(name = "Failure.findById", query = "SELECT f FROM Failure f where f.failureId=:failureId"),
})
public class Failure extends MySqlTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="failure_id")
	private int failureId;

	private String description;

	//bi-directional many-to-one association to Base_Data
	@OneToMany(mappedBy="failure")
	private List<Base_Data> baseData;

	public Failure() {
	}

	public Failure(int failure_id, String description) {
		super();
		this.failureId = failure_id;
		this.description = description;
	}

	public int getFailureId() {
		return this.failureId;
	}

	public void setFailureId(int failureId) {
		this.failureId = failureId;
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
		baseData.setFailure(this);

		return baseData;
	}

	public Base_Data removeBaseData(Base_Data baseData) {
		getBaseData().remove(baseData);
		baseData.setFailure(null);

		return baseData;
	}

}