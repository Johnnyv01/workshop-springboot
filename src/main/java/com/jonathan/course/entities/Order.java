package com.jonathan.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jonathan.course.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "`order`")
public class Order implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momemt;
	
	private Integer orderStatus;
	
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	public Order() {
	
	}

	public Order(Long id, Instant momemt, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.momemt = momemt;
		setOrderStatus(orderStatus);
		this.client = client;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomemt() {
		return momemt;
	}

	public void setMomemt(Instant momemt) {
		this.momemt = momemt;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus) ;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", momemt=" + momemt + ", client=" + client + "]";
	}
	
	
	
	
	
	

}
