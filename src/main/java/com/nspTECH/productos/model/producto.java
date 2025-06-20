package com.nspTECH.productos.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PRODUCTOS")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    @Schema(description ="aa")
    private Long ID_PRODUCTO;

    @Column(name = "NOMBRE",nullable= false , length = 30)
    @Schema(description ="aa")
    private String NOMBRE;
    
    @Column(name = "descripcion",nullable= true , length = 255)
    @Schema(description ="aa")
    private String descripcion;
    
    @Column(name = "marca",nullable= true , length = 50)
    @Schema(description ="aa")
    private String marca;

    @Column(name = "PRECIO",nullable= false , precision = 10)
    @Schema(description ="aa")
    private Long PRECIO;

    @Column(name = "SKU",nullable= false , length = 12)
    @Schema(description ="aa")
    private String SKU;

    @Column(name = "estado",nullable= false)
    @Schema(description ="aa")
    private char estado;
    

}

