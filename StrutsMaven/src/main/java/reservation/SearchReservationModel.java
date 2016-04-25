package reservation;

import java.util.ArrayList;
import java.util.List;

import mapping.Reservation;

public class SearchReservationModel {

	private String contactPerson;
	private String reservationDate;
	private String reservationId;
	private String companyName;
	private List<Reservation []> reservationList = new ArrayList<Reservation[]>();

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Reservation []> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservation []> reservationList) {
		this.reservationList = reservationList;
	}
	
}
