package com.watch.shopwatchonline.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailDto implements Serializable {

	private int mailId;
	
//	@NotEmpty
////	(message = "Tiêu đề không để trống!")
//    @Size(min = 5, message = "5 kí tự trở lên!")
	private String title;

//	@NotEmpty
//	(message = "Email không để trống!")
//	@Pattern(regexp = ".+@.+\\.[a-z]+",message = "email không đúng định dạng!")
	private String gmail;
	
//	@NotEmpty
//	(message = "Nội dung không để trống!")
	private String description;

	private Date CreateAt ;
	private Date UpdateAt;
	private Short status = 0;
	private Boolean isEdit = false;
}
