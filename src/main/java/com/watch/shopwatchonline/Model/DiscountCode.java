package com.watch.shopwatchonline.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DiscountCode")
public class DiscountCode implements Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column( length = 100, columnDefinition = "nvarchar(100) not null")
	private String name;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date ApplicableDate;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date ExpirationDate;

    @Column 
    private String ByteCode;

    @Column
     private int Quantity;
    
     @Column
     private Float ReductionAmount;

     @Column
     private Float AmountApplied;

     @Column
     private String Description;

     @Column 
     private Short status;

     @OneToOne(mappedBy = "discountCode")
     private Order orders;
}
