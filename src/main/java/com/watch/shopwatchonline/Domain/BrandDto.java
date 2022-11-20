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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandDto implements Serializable{

	private int id;
    
	@NotEmpty
	private String name;

	@NotEmpty
	private String thumbnail;

	@NotEmpty
	private String description;

	private short active;
    
	private Boolean isEdit = false;
}
