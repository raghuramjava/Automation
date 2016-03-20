package mapping;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="bike_details")
public class Bike {
	@Column(name="bike_id")
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int bikeId;
	
	@Column(name="bike_type")
	private String bikeType;
	@Column(name="created_Date")
	private Date  cratedDate;
	@Column(name ="chase_no")
	private String chaseNo;
	@Column(name="model_No")
	private String modelNo;
	@Column(name="bike_no")
	private String bikeNo;
	

	public String getBikeType() {
		return bikeType;
	}

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}

	public Date getCratedDate() {
		return cratedDate;
	}

	public void setCratedDate(Date cratedDate) {
		this.cratedDate = cratedDate;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	

	

	public String getChaseNo() {
		return chaseNo;
	}

	public void setChaseNo(String chaseNo) {
		this.chaseNo = chaseNo;
	}

	public String getBikeNo() {
		return bikeNo;
	}

	public void setBikeNo(String bikeNo) {
		this.bikeNo = bikeNo;
	}

}
