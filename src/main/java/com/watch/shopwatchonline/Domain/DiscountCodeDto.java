package com.watch.shopwatchonline.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountCodeDto implements Serializable {

	private int id;

	
	@Size(min = 20, max = 100,message = "short")
	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date ApplicableDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date ExpirationDate;
@NotNull
	private String ByteCode;

	private int Quantity;

	private Float ReductionAmount;

	private Float AmountApplied;

	private String Description;

	private Short status;

	private Boolean isEdit;
}
