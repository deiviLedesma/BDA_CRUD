/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDateTime;

/**
 *
 * @author SDavidLedesma
 */
public class Cliente {

    private Long idcliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private boolean estaEliminado;
    private LocalDateTime fechaHoraRegistro;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(Long idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, boolean estaEliminado, LocalDateTime fechaHoraRegistro) {
        this.idcliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estaEliminado = estaEliminado;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    // Getters y Setters
    public Long getIdCliente() {
        return idcliente;
    }

    public void setIdCliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }

    public LocalDateTime getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    // Método toString para representar al cliente
    @Override
    public String toString() {
        return "Cliente{"
                + "idCliente=" + idcliente
                + ", nombre='" + nombre + '\''
                + ", apellidoPaterno='" + apellidoPaterno + '\''
                + ", apellidoMaterno='" + apellidoMaterno + '\''
                + ", estaEliminado=" + estaEliminado
                + ", fechaHoraRegistro=" + fechaHoraRegistro
                + '}';
    }
}
