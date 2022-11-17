package com.watch.shopwatchonline.Domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class blogDto {
    private int id;

	private String title;

	private String banner;
    private MultipartFile imageFile;
    
    private String shortdecs;

	private String description;

	private short active;

	private Date createAt;

    private Boolean isEdit;

	private int ProductId;
}
