package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the User_Equipment database table.
 * 
 */
@Entity
@NamedQueries( {
	@NamedQuery(name="User_Equipment.findAll", query="SELECT ue FROM User_Equipment ue"),
	@NamedQuery(name = "User_Equipment.findById", query = "SELECT ue FROM User_Equipment ue where ue.userEquipmentId=:userEquipmentId"),
})
public class User_Equipment extends MySqlTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_equipment_id")
	private int userEquipmentId;
	
	@Column(name="marketing_name")
	private String marketingName;
	
	private String manufacturer;
	
	@Column(name="access_capability")
	private String accessCapability;
	
	private String model;
	
	@Column(name="vendor_name")
	private String vendorName;
	
	@Column(name="ue_type")
	private String ueType;
	
	private String os;

	@Column(name="input_mode")
	private String inputMode;

	//bi-directional many-to-one association to Base_Data
	@OneToMany(mappedBy="userEquipment")
	private List<Base_Data> baseData;

	public User_Equipment() {
	}

	public int getUser_EquipmentId() {
		return this.userEquipmentId;
	}

	public void setUser_EquipmentId(int userEquipmentId) {
		this.userEquipmentId = userEquipmentId;
	}

	public String getAccessCapability() {
		return this.accessCapability;
	}

	public void setAccessCapability(String accessCapability) {
		this.accessCapability = accessCapability;
	}

	public String getInputMode() {
		return this.inputMode;
	}

	public void setInputMode(String inputMode) {
		this.inputMode = inputMode;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getMarketingName() {
		return this.marketingName;
	}

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOs() {
		return this.os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getUeType() {
		return this.ueType;
	}

	public void setUeType(String ueType) {
		this.ueType = ueType;
	}

	public String getVendorName() {
		return this.vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public List<Base_Data> getBaseData() {
		return this.baseData;
	}

	public void setBaseData(List<Base_Data> baseData) {
		this.baseData = baseData;
	}

	public Base_Data addBaseData(Base_Data baseData) {
		getBaseData().add(baseData);
		baseData.setUserEquipment(this);

		return baseData;
	}

	public Base_Data removeBaseData(Base_Data baseData) {
		getBaseData().remove(baseData);
		baseData.setUserEquipment(null);

		return baseData;
	}

}