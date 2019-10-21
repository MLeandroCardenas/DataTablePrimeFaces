/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 *
 * @author michl
 */
@Named
@ViewScoped
public class Carros implements Serializable{

    @NotNull(message = "No puede estar vacio")
    @Size(min = 3,max = 40, message = "entre 3 y 40 caracteres")
    private String nombre;
    
    
    private String claveMarca;
    @NotNull(message = "No puede estar vacio")
    private Map<String,String> marca;
   
    
    @NotNull(message = "No puede estar vacio")
    @Min(value = 1995, message = "No puede ser menor al año 1995") @Max(value = 2019, message = "No puede ser mayor al año actual")
    private Integer modelo;
    
    private List carros;  
    /**
     * Creates a new instance of Carros
     */
    public Carros() {
    }
    
    @PostConstruct
    public void init(){
        marca = new HashMap<String,String>();
        carros = new ArrayList<Carros>();
        marca.put("BMW","BMW");
        marca.put("Toyota","Toyota");
        marca.put("Nissan","Nissan");
        marca.put("Ford","Ford");
        marca.put("Volkswagen","Volkswagen");
    }
    
    public void llenarLista(){
        Carros datos = new Carros();
        datos.nombre = nombre;
        datos.claveMarca = marca.get(claveMarca);
        datos.modelo = modelo;
       /* 
        System.out.println("1. "+datos.nombre);
        System.out.println("2. "+datos.claveMarca);
        System.out.println("3. "+datos.modelo); 
        */
        carros.add(datos);
    }
    
    public boolean enabletable() {
        if(carros.isEmpty())
            return false;
        else
            return true;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List getCarros() {
        return carros;
    }

    public void setCarros(List carros) {
        this.carros = carros;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }   

    public String getClaveMarca() {
        return claveMarca;
    }

    public void setClaveMarca(String claveMarca) {
        this.claveMarca = claveMarca;
    }

    public Map<String, String> getMarca() {
        return marca;
    }

    public void setMarca(Map<String, String> marca) {
        this.marca = marca;
    }    
}
