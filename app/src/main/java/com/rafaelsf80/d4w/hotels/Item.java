package com.rafaelsf80.d4w.hotels;

public class Item
{

    String nombre_actividad;
    String descripcion;
    String total_plazas;
    String reservadas;
    String disponibles;
    String color;
    
    public Item()
    {
    	super();
    }
    
    public Item(String nombre_actividad, String descripcion, 
    		String total_plazas, String reservadas, 
    		String disponibles, String color)
    {
    	super();
    	this.descripcion = descripcion;
    	this.nombre_actividad=nombre_actividad;
    	this.total_plazas=total_plazas;
    	this.reservadas=reservadas;
    	this.disponibles=disponibles;
    	this.color = color;
    }
    
    public String getNombreActividad() {
        return nombre_actividad;
    }
    
    public String getTotalPlazas() {
        return total_plazas;
    }
    
    public String getPlazasReservadas() {
        return reservadas;
    }
    
    public String getPlazasDisponibles() {
        return disponibles;
    }
}
