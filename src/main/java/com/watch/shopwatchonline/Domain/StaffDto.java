package com.watch.shopwatchonline.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto {
	private int staffId;
	
	@NotEmpty(message = "Tên không để trống!")
	@Size(min = 5, max = 30, message = "5 kí tự trở lên và 30 kí tự trở xuống!")
	private String name;
	
	@NotEmpty(message = "Email không để trống!")
	@Pattern(regexp = ".+@.+\\.[a-z]+",message = "email không đúng định dạng!")
	private String email;
	
	@NotEmpty(message = "SĐT không để trống!")
	@Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$", 
	message = "SĐT không đúng định dạng! "
			+ "*(0+84......)")
	private String phone;
	
	private String pBan;
	private String cVu;
	
	@NotEmpty(message = "Ngày sinh không để trống!")
	@Column(length = 10, columnDefinition = "nvarchar(10) not null")
	private String ngayBD;
	
    @NotNull(message = "Lương không để trống!")
    @Min(message = "Phải trên 1000", value = 1000)
	private Float luong;
    
	private Boolean isEdit = false;
}
