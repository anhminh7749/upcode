package com.watch.shopwatchonline.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

     private int id;

    private String name;

    private String phone;

    private String address;
    private String specificAddress;
    private Short status;
     private int userId;
     private Boolean isEdit;
     private String redirect;
}