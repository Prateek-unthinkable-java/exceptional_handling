package com.example.exceptional_handling.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    private long custId;
    private String custName;
    private long totalBill;
    private long payedBill;
    private long restBill;
    private String cityOfCustomer;
}
