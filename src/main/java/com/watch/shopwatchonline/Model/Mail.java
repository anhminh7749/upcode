package com.watch.shopwatchonline.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Mails")
public class Mail implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mailId;

    @Column(length = 100, columnDefinition = "nvarchar(50) not null")
//    @NotEmpty
//    (message = "Tiêu đề không để trống!")
//    @Size(min = 5, message = "5 kí tự trở lên!")
    private String title;
    
    @Column(length = 100, columnDefinition = "nvarchar(100) not null")
//    @NotEmpty
//    (message = "Email không để trống!")
//	@Pattern(regexp = ".+@.+\\.[a-z]+",message = "email không đúng định dạng!")
    private String gmail;
    
	@Column(length = 1000, columnDefinition = "nvarchar(1000) not null")
//	@NotEmpty
//	(message = "Nội dung không để trống!")
	private String description;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date createAt;//u->admin

    @Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date updateAt;//admin->user
    
    @Column(nullable = false)
    private Short status = 0;
}
