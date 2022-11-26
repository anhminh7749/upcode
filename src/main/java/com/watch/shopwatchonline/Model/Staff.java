package com.watch.shopwatchonline.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Staffs")
public class Staff implements Serializable {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int staffId;

	    @Column(length = 50, columnDefinition = "nvarchar(50) not null")
	    private String name;

	    @Column(length = 50, columnDefinition = "nvarchar(50) not null")
	    private String email;

	    @Column(length = 10)
	    private String phone;
	    
	    @Column(nullable = false)
	    private String pBan;

	    @Column(nullable = false)
	    private String cVu;

	    @Column(nullable = false)
	    private String ngayBD;

	    @Column(nullable = false)
	    private double luong;

}