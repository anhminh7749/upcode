package com.watch.shopwatchonline.Domain;

import javax.validation.constraints.NotEmpty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

	private int id;
 
	@NotEmpty
	private String name;
	
	private Boolean isEdit = false;

}
