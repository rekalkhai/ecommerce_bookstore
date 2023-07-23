package com.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title" ,unique = true)
	private String title;
	
	@Lob
	@Column(name = "image",columnDefinition = "MEDIUMBLOB")
	private String image;
	
	@Column(name = "author")
	private String author;
	@Column(name = "description" , columnDefinition = "TEXT")
	private String description;
	@Column(name = "price")
	private float price;
	@Column(name = "date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_product_to_category"),
	name = "cateID",referencedColumnName = "cid")
	private Category category;
	@Column(name = "sold")
	private int sold;
}
