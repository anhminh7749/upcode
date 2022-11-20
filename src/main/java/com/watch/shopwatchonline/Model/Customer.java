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
@Table(name = "Customers")
public class Customer implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(length = 100, columnDefinition = "nvarchar(50) not null")
    private String name;
    
    @Column(length = 100, columnDefinition = "nvarchar(100) not null")
    private String email;
    
    @Column(length = 10)
    private String phone;
    
    @Column(nullable = false)
    private Short gender = 0;
    
    @Column(nullable = false)
    private String birthday;
    
    @Column(nullable = false)
    private Short status = 0;
//
//    @ManyToOne
//    @JoinColumn(name = "GiohangId",nullable = false)
//    private GioHang Giohang;
//
//    @ManyToOne
//    @JoinColumn(name = "DanhgiaId",nullable = false)
//    private DanhGia danhgia;
//
//    @OneToMany
//    @JoinColumn(name = "Phanhoi",nullable = false)
//    private PhanHoi phanhoi;
}