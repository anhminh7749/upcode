package com.watch.shopwatchonline.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

	@Size(min = 20, max = 100, message = "short")
	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date ApplicableDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date ExpirationDate;
	@NotNull
	@Size(max = 50, min = 8, message = "Phải trên 8 kí tự và không quá 50 kí tự")
	private String ByteCode;
	@Min(value = 1, message = "Không thể để giá trị bằng 0, bạn có thể không nhập nếu muốn số lượn không giới hạn!")
	private int Quantity;
	@NotNull(message = "Nhập giá giảm")
	private Float ReductionAmount;
	@NotNull(message = "Nhập mức áp dụng")
	private Float AmountApplied;

	private String Description;

	private Short status;

	private Boolean isEdit;
}
