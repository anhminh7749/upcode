package com.watch.shopwatchonline.Domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDto implements Serializable {

    private int Id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date CompleteDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cancellationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date DeliveringDate;

    private Short Status;

    private int addressId;

    private int discountCodeId;

    private float totalAmount;

    private int totalQuantity;
}