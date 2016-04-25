package reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import mapping.PriceInventory;

public class ReservationManageModel {
	
	private String month;
	private String year;
	private List<PriceInventory> priceInvList;
	private Map<String,String> yearMap = new LinkedHashMap<String, String>();
	private Map<String,String> monthMap=new LinkedHashMap<String, String>();
	private Map<String,String> dateMap = new LinkedHashMap<String, String>();
	
	private String numberOfDays;
	private List<String> adultPrices =new ArrayList<String>();
	private List<String> childPrices = new ArrayList<String>();
	private List<String> seats =new ArrayList<String>();
	private List<String> dates =new ArrayList<String>();
	private List<String> priIds = new ArrayList<String>();
	
	private List<Object[]> invAarray;
	
	public List<String> getChildPrices() {
		return childPrices;
	}

	public void setChildPrices(List<String> childPrices) {
		this.childPrices = childPrices;
	}

	
  
	public List<String> getAdultPrices() {
		return adultPrices;
	}

	public void setAdultPrices(List<String> adultPrices) {
		this.adultPrices = adultPrices;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<PriceInventory> getPriceInvList() {
		return priceInvList;
	}

	public void setPriceInvList(List<PriceInventory> priceInvList) {
		this.priceInvList = priceInvList;
	}

	public Map<String,String> getYearMap() {
		return yearMap;
	}

	public void setYearMap(Map<String,String> yearMap) {
		this.yearMap = yearMap;
	}

	public Map<String,String> getMonthMap() {
		return monthMap;
	}

	public void setMonthMap(Map<String,String> monthMap) {
		this.monthMap = monthMap;
	}

	public Map<String,String> getDateMap() {
		return dateMap;
	}

	public void setDateMap(Map<String,String> dateMap) {
		this.dateMap = dateMap;
	}

	public String getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(String numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public List<String> getSeats() {
		return seats;
	}

	public void setSeats(List<String> seats) {
		this.seats = seats;
	}

	public List<String> getDates() {
		return dates;
	}

	public void setDates(List<String> dates) {
		this.dates = dates;
	}

	public List<Object[]> getInvAarray() {
		return invAarray;
	}

	public void setInvAarray(List<Object[]> invAarray) {
		this.invAarray = invAarray;
	}

	public List<String> getPriIds() {
		return priIds;
	}

	public void setPriIds(List<String> priIds) {
		this.priIds = priIds;
	}

	

}
