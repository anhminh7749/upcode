package com.watch.shopwatchonline.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto implements Serializable{
   
	private int Id;

	
	private String Name;

	
	private int Quantity;

	
	private float Price;

	
	private String thumbnail;
	private MultipartFile imageFile;
	
	private String description;
	private Date CreateAt;
	
	private float Discount;

	
	private short Active;

	private int categoryId;
	private int ImageId;
	private int BrandId;

	private Boolean isEdit;

}
