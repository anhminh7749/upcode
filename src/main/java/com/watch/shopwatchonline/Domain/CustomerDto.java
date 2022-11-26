package com.watch.shopwatchonline.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Serializable{

	private int customerId;
	@NotEmpty
    @Length(min= 5, message = "it nhat 5 ki tu")
	private String name;
	@NotEmpty
    @Length(max= 100)
	private String email;
 
	@NotEmpty
	@Length(max = 10)
	private String phone;
	
    private Short gender;
    @NotEmpty
    private String birthday;

    private String status;

    private Boolean isEdit = false;
    
}
