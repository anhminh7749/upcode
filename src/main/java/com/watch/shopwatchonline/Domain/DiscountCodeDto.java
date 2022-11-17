package com.watch.shopwatchonline.Domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountCodeDto implements Serializable{
   
	private int id;


	private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date ApplicableDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date ExpirationDate;

    private String ByteCode;

   
     private int Quantity; 
   
     private Float ReductionAmount;

     private Float AmountApplied;

     private String Description;

          private Short status;

          private Boolean isEdit;
}
