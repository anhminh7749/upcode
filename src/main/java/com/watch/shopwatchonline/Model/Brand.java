package com.watch.shopwatchonline.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Brand")
public class Brand implements Serializable{

    @javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @Column(columnDefinition = "nvarchar(50)" ,nullable = false)
	private String name;

	@Column(length = 50,nullable = false)
	private String thumbnail;

    @Column(columnDefinition = "nvarchar(max) not null")
	private String description;

	@Column(nullable = false)
	private short active;

	@OneToMany(mappedBy = "Brand", cascade = CascadeType.ALL)
	private Set<Product> products;
    
}
