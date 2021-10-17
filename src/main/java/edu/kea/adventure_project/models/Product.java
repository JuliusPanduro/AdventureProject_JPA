package edu.kea.adventure_project.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Julius Panduro
 */
@Data
@NoArgsConstructor
@Table(name = "products")
@Entity
public class Product {
    @Id
    private Long productID;
    @Column
    private String productName;
    @Column
    private double productPrice;



}
