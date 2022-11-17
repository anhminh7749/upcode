package com.watch.shopwatchonline.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Raiting")
public class Raiting implements Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// @Size(max = 3000, min = 100, message = "Comment be between 100 and 3000 characters")
	private String comment;

	@Column(nullable = false)
	private int point;

	@Column(nullable = false)
	private short active;

    @Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date createAt;

    @ManyToOne
	@JoinColumn(name = "ProductId",nullable = false)
	private Product Product;

    @ManyToOne
	@JoinColumn(name = "UserId",nullable = false)
	private User users;
   
}
