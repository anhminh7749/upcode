package com.watch.shopwatchonline.Domain;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto {
	private int staffId;
    @NotEmpty
    @Length(min= 5, message = "it nhat 5 ki tu")
    private String name;
    @NotEmpty
    @Length(max= 100)
    private String email;
    @NotEmpty
    @Length(max= 10)
    private String phone;
    private String pBan;
    private String cVu;
    @NotEmpty
    private String ngayBD;
//    @NotEmpty
    private double luong;
    private Boolean isEdit = false;
}
