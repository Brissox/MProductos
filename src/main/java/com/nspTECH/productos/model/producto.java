package com.nspTECH.productos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PRODUCTO")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private Long id;

    @Column(name = "NOMBRE",nullable= false , length = 100)
    private String NOMBRE;

    @Column(name = "CANTIDAD",nullable= false , precision = 10)
    private Long CANTIDAD;

    @Column(name = "PRECIO",nullable= false , precision = 10, scale=2)
    private Long PRECIO;

    @Column(name = "SKU",nullable= false , precision = 20)
    private String SKU;

    

}

