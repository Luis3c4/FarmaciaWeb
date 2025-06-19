package com.proyecto.farmacia.webfarmacia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;
    private int cantidad;
    private String descripcion;
    
    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;
    
    private int stockCantidad; // Cantidad numérica para control interno

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public StockStatus getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }

    public int getStockCantidad() {
        return stockCantidad;
    }

    public void setStockCantidad(int stockCantidad) {
        this.stockCantidad = stockCantidad;
        // Actualizar automáticamente el estado del stock basado en la cantidad
        if (stockCantidad <= 0) {
            this.stockStatus = StockStatus.OUT_OF_STOCK;
        } else if (stockCantidad <= 10) {
            this.stockStatus = StockStatus.LOW_STOCK;
        } else {
            this.stockStatus = StockStatus.IN_STOCK;
        }
    }
} 