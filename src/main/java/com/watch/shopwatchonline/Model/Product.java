package com.watch.shopwatchonline.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Product")
public class Product implements Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "nvarchar(100)" ,nullable = false)
	@Size(max = 120, min = 10, message = "Name must be between 10 and 120 characters")
	@NotEmpty(message = "Please enter name")
	private String name;

	@Column(nullable = false)
	@Positive(message = "Quantity can contain values > 0 only")
	private int quantity;

	@Column(nullable = false)
	@Positive(message = "Price can contain values > 0 only")
	
	private float price;

	@PositiveOrZero(message = "SalePrice can contain values > 0 only")
	private float discount;

	@Column(length = 50,nullable = false)
	private String thumbnail;

	@Column(columnDefinition = "text not null")
	@Size(max = 3000, min = 100, message = "Descriptionmust be between 100 and 3000 characters")
	@NotEmpty(message = "Please enter description")
	private String description;

	@Column(nullable = false)
	private short active;

    @Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date createAt;

    @Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date updateAt;

    @ManyToOne
	@JoinColumn(name = "CategoryId",nullable = false)
	private Category Category;

    @ManyToOne
	@JoinColumn(name = "BrandId",nullable = false)
	private Brand Brand;

	@OneToMany(mappedBy = "Product", cascade = CascadeType.ALL)
	private Set<Raiting> raitings;

	@OneToMany(mappedBy = "Product", cascade = CascadeType.ALL)
	private Set<wishlist> wishlists;

	@OneToMany(mappedBy = "Product", cascade = CascadeType.ALL)
	private Set<Blog> blogs;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="product_images",
	joinColumns  = {
		@JoinColumn(name="product_id")
	},
	inverseJoinColumns  = {
		@JoinColumn(name="image_id")
	}
	)
	private Set<Image> productImages;

	
}
