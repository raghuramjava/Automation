package reservation;

import mapping.Reservation;

public class ReservationEditSaveModel {
	
	private String companyName;
	private String contactPerson;
	private String phoneNo;
	private String email;
	private String reservationDate;
	private String noOfPerson;
	private String userInput;
	private String remarks;
	private String adavanceAmount;
	private String resId;
	private Reservation reservation;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(String noOfPerson) {
		this.noOfPerson = noOfPerson;
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

	public String getAdavanceAmount() {
		return adavanceAmount;
	}

	public void setAdavanceAmount(String adavanceAmount) {
		this.adavanceAmount = adavanceAmount;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
