package com.example.practiceproject.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id // it is to create Primary Key
    @GeneratedValue(strategy=GenerationType.AUTO)
    @SequenceGenerator(name = "address_gen",sequenceName = "address_sequence", initialValue = 1, allocationSize = 1)
    private Long addressId;
    private String streetName;
    private String city;
    private String state;

}
