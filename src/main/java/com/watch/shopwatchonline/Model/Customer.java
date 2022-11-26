package com.watch.shopwatchonline.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customers")
public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	@NotEmpty(message = "Tên không để trống!")
	@Column(length = 50, columnDefinition = "nvarchar(50) not null")
	@Size(max = 30, min = 5, message = "Tên phải từ 5 kí tự trở lên  và 30 kí tự trở xuống!")
	private String name;

    @Column(length = 100, columnDefinition = "nvarchar(100) not null")
	@NotEmpty(message = "Email không để trống!")
	@Pattern(regexp = ".+@.+\\.[a-z]+")
	private String email;

    @NotEmpty(message = "SĐT không để trống!")
	@Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$", 
	message = "SĐT không đúng định dạng! "
			+ "*(0+84......)")
	private String phone;

	@Column(nullable = false)
	private Short gender = 0;

	@NotEmpty(message = "Ngày sinh không để trống!")
	@Column(length = 10, columnDefinition = "nvarchar(10) not null")
	private String birthday;

	@Column(nullable = false)
	private Short status = 0;
//
//    @ManyToOne
//    @JoinColumn(name = "GiohangId",nullable = false)
//    private GioHang Giohang;
//
//    @ManyToOne
//    @JoinColumn(name = "DanhgiaId",nullable = false)
//    private DanhGia danhgia;
//
//    @OneToMany
//    @JoinColumn(name = "Phanhoi",nullable = false)
//    private PhanHoi phanhoi;
}