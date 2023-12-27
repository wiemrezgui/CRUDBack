package com.example.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Repas {
    @Id
    private String id;
    private String name;
    private float price;
	public void setId(String id) {
		this.id=id;
		
	}
}
