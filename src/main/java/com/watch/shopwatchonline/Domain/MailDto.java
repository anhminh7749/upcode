package com.watch.shopwatchonline.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailDto implements Serializable {

	private int mailId;
	@NotEmpty
    @Length(min = 5)
	private String title;
	@NotEmpty
    @Length(max= 100)
	@Email
	private String gmail;
	@NotEmpty
    @Length(min = 5)
	private String description;

	private Date CreateAt ;
	private Date UpdateAt;
	private Short status = 0;
	private Boolean isEdit = false;
}
