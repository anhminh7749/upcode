package com.watch.shopwatchonline.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Serializable {

	private int customerId;


	@NotEmpty(message = "Tên không để trống!")
	@Size(max = 30, min = 5, message = "Tên phải từ 5 kí tự trở lên và 30 kí tự trở xuống!")
	private String name;

	@NotEmpty(message = "Email không để trống!")
	@Pattern(regexp = ".+@.+\\.[a-z]+",message = "email không đúng định dạng!")
	private String email;

	@NotNull(message = "SĐT không để trống!")
	@Max(value = 10, message = "SĐT không đúng định dạng!")
	@Min(value = 10, message = "SĐT không đúng định dạng!")
	private Integer phone;

	@Column(nullable = false)
	private Short gender = 0;

	@NotEmpty(message = "Ngày sinh không để trống!")
	private String birthday;

	private Short status = 0;

	private Boolean isEdit = false;

}
