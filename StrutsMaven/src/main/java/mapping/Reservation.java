package mapping;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name ="res_details")
public class Reservation {
	
	@Column(name="res_id")
	@Id @SequenceGenerator(name = "ResSequence", sequenceName = "seq_res_details", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ResSequence")
	private int resId;
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="contact_person")
	private String contact_person;
	
	@Column(name="phone_no")
	private String phoneNo;
	
	@Column(name="email_address")
	private String  email;
	
	@Column(name="reservation_date")
	private Date reservation_date; 
	
	@Column(name="no_persons")
	private int noOfPesons;
	
	@Column(name="user_input")
	private String userInput;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="modified_on")
	private Date modified_on;
	
	@Column(name="modified_by")
	private String modifiedBy;
	
	@Column(name="advance_amount")
	private float advanceAmount;
	
	@Column(name="status")
	private String status;
	

	
	
	public float getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(float advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModified_on() {
		return modified_on;
	}

	public void setModified_on(Date modified_on) {
		this.modified_on = modified_on;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getReservation_date() {
		return reservation_date;
	}

	public void setReservation_date(Date reservation_date) {
		this.reservation_date = reservation_date;
	}

	public int getNoOfPesons() {
		return noOfPesons;
	}

	public void setNoOfPesons(int noOfPesons) {
		this.noOfPesons = noOfPesons;
	}

	public String getUserInput() {
		return userInput;
	}

	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
