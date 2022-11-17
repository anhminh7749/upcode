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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Blog")
public class Blog {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "nvarchar(100)" ,nullable = false)
	@Size(max = 120, min = 10, message = "Name must be between 10 and 120 characters")
	@NotEmpty(message = "Please enter name")
	private String title;


	@Column(length = 50,nullable = false)
	private String banner;

    @Column(columnDefinition = "text not null")
	// @Size(max = 3000, min = 100, message = "Short description must be between 100 and 3000 characters")
	@NotEmpty(message = "Please enter short description")
	private String shortdecs;


	@Column(columnDefinition = "text not null")
	@Size(max = 3000, min = 100, message = "Description must be between 100 and 3000 characters")
	@NotEmpty(message = "Please enter description")
	private String description;

	@Column(nullable = false)
	private short active;

    @Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(nullable = false)
	private Date createAt;

    @Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(nullable = false)
	private Date updateAt;

	@ManyToOne
	@JoinColumn(name = "ProductId",nullable = false)
	private Product Product;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="blog_images",
	joinColumns  = {
		@JoinColumn(name="blog_id")
	},
	inverseJoinColumns  = {
		@JoinColumn(name="image_id")
	}
	)
	private Set<Image> blogImages;

}
