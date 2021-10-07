/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author turme
 */
public class Producto {

    private int idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private int cantidadProducto;
    private double precioProducto;

    public Producto() {
        this.idProducto = 0;
        this.descripcionProducto = "";
        this.nombreProducto = "";
        this.precioProducto = 00.00;
        this.cantidadProducto = cantidadProducto;
                
    }

    public Producto(int idProducto, String nombreProducto, int cantidadProducto, String descripcionProducto, double precioProducto) {
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
    }

    public Producto(String nombreProducto, int cantidadProducto, String descripcionProducto, double precioProducto) {
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;

    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
    
    public String toString (){
        return "producto de la empresa " + idProducto + " se llama " + nombreProducto + ", hay " + cantidadProducto + " su descripcion es " + descripcionProducto + " y vale " + precioProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

}
