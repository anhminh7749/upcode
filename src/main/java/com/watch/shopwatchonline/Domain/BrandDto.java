package com.watch.shopwatchonline.Domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandDto implements Serializable{

	private int id;
    
	@NotEmpty(message = "Tên không để trống!")
	@Column(length = 100, columnDefinition = "nvarchar(50) not null")
	@Size(max = 30, min = 5, message = "Tên phải từ 5 kí tự trở lên và 30 kí tự trở xuống!")
	private String name;

	@NotEmpty(message = "tên không để trống!")
	private String thumbnail;
	
	private MultipartFile imageFile;

	@NotEmpty(message = "tên không để trống!")
	@Size(max = 3000, min = 10, message = "Tên phải từ 100 kí tự trở lên và 3000 kí tự trở xuống!")
	private String description;

	private short active;
    
	private Boolean isEdit = false;
}
