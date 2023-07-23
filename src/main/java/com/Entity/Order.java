package com.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private int oid;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_order_to_user"),
	name = "customerID",referencedColumnName = "userID")
	private User user;
	
	@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_order_to_product"),
            name = "productID",referencedColumnName = "id")
	private Product product;
	 @Column(name = "quantity")
	private int quantity;
}
