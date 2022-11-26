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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

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
	@NotEmpty(message = "Tên không để trống!")
	@Size(min = 5, max = 30, message = "5 kí tự trở lên và 30 kí tự trở xuống!")
	private String name;

	@Column(length = 50, columnDefinition = "nvarchar(50) not null")
	@NotEmpty(message = "Email không để trống!")
	@Pattern(regexp = ".+@.+\\.[a-z]+")
	private String email;

	@NotEmpty(message = "SĐT không để trống!")
	@Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$", 
	message = "SĐT không đúng định dạng! "
			+ "*(0+84......)")
	private String phone;

	@Column(nullable = false)
	private String pBan;

	@Column(nullable = false)
	private String cVu;

	@NotEmpty(message = "Ngày sinh không để trống!")
	@Column(length = 10, columnDefinition = "nvarchar(10) not null")
	private String ngayBD;

	@NotNull(message = "Lương không để trống!")
	@Min(value = 1000, message = "Phải trên 1000")
	private Float luong;

}