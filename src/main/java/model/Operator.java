package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Operator database table.
 * 
 */
@Entity
@NamedQueries( {
	@NamedQuery(name="Operator.findAll", query="SELECT o FROM Operator o"),
	@NamedQuery(name = "Operator.findById", query = "SELECT o FROM Operator o where o.id=:id"),
})
public class Operator extends MySqlTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OperatorPK id;

	private String country;

	@Column(name="operator_name")
	private String operatorName;

	//bi-directional many-to-one association to Base_Data
	@OneToMany(mappedBy="operator")
	private List<Base_Data> baseData;

	public Operator() {
	}

	public OperatorPK getId() {
		return this.id;
	}

	public void setId(OperatorPK id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOperatorName() {
		return this.operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public List<Base_Data> getBaseData() {
		return this.baseData;
	}

	public void setBaseData(List<Base_Data> baseData) {
		this.baseData = baseData;
	}

	public Base_Data addBaseData(Base_Data baseData) {
		getBaseData().add(baseData);
		baseData.setOperator(this);

		return baseData;
	}

	public Base_Data removeBaseData(Base_Data baseData) {
		getBaseData().remove(baseData);
		baseData.setOperator(null);

		return baseData;
	}

}