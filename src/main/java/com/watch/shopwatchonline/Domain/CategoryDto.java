package com.watch.shopwatchonline.Domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {

	private int categoryId;

	private String name;

	private Boolean isEdit = false;
}