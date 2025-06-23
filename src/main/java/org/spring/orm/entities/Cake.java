package org.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cake_details")
public class Cake {
	
	@Id
	@Column(name = "cake_id")
	private int id;
	@Column(name="cake_name")
	private String cakeName;
	@Column(name = "cake_price")
	private double cakePrice;
	@Column(name = "cake_flavour")
	private String cakeFlavour;
	
	
	public Cake() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cake(int id, String cakeName, double cakePrice, String cakeFlavour) {
		super();
		this.id = id;
		this.cakeName = cakeName;
		this.cakePrice = cakePrice;
		this.cakeFlavour = cakeFlavour;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCakeName() {
		return cakeName;
	}
	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}
	public double getCakePrice() {
		return cakePrice;
	}
	public void setCakePrice(double cakePrice) {
		this.cakePrice = cakePrice;
	}
	public String getCakeFlavour() {
		return cakeFlavour;
	}
	public void setCakeFlavour(String cakeFlavour) {
		this.cakeFlavour = cakeFlavour;
	}
	
	@Override
	public String toString() {
		return "Cake [id=" + id + ", cakeName=" + cakeName + ", cakePrice=" + cakePrice + ", cakeFlavour=" + cakeFlavour
				+ "]";
	}
	
}
