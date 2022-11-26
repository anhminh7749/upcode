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
    private String title;
    
    @Column(length = 100, columnDefinition = "nvarchar(100) not null")
    private String gmail;
    
    @Column(nullable = false)
    private String description;
    
    @Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date createAt;//u->admin

    @Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date updateAt;//admin->user
    
    @Column(nullable = false)
    private Short status = 0;
}
