package com.watch.shopwatchonline.Domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

	private int id;
 
	@NotEmpty(message = "Tên không để trống!")
	@Size(max = 30, min = 5, message = "Tên phải từ 5 kí tự trở lên và 30 kí tự trở xuống!")
	private String name;
	
	private Boolean isEdit = false;

}
