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
@Table(name ="res_price_inventory")
public class PriceInventory {
	@Column(name="id")
	@Id @SequenceGenerator(name = "PriceSequence", sequenceName = "seq_price_invent", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PriceSequence")
	private int id;
	@Column(name ="price_date")
	private Date priceDate;
	@Column(name ="adult_price")
	private float adultPrice;
	@Column(name ="child_price")
	private float childPrice;
	@Column(name ="seats")
	private int seats;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
	}

	public float getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(float adultPrice) {
		this.adultPrice = adultPrice;
	}

	public float getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(float childPrice) {
		this.childPrice = childPrice;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

}
