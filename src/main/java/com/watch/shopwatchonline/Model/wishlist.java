package com.watch.shopwatchonline.Model;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="wishlist")
public class wishlist {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date CreateAt;
    
    
    @ManyToOne
	@JoinColumn(name = "ProductId",nullable = false)
	private Product Product;

    @ManyToOne
	@JoinColumn(name = "UserId",nullable = false)
	private User users;
}
