package com.watch.shopwatchonline.Model;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderDetail")
public class OrderDetail implements Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int Id;
     private int quantity;
     private float price;
     private float discount;

     @ManyToOne
     @JoinColumn(name = "orderId", nullable = false)
     private Order orders;

     @ManyToOne
     @JoinColumn(name = "productId", nullable = false)
     private Product Product;
}