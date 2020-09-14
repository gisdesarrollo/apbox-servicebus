package com.gisconsultoria.com.apiBox.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Luis Enrique Morales Soriano
 */
@Entity
@Table(name = "cat_sucursales")
public class Sucursal implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Servidor")
    private String servidor;

    @Column(name = "Rfc")
    private String rfc;

    @Column(name = "KeyXsa")
    private String keyXsa;

    @Column(name = "FechaInicial")
    private Date fechaInicial;

    @Column(name = "Status")
    private String status;

    @OneToMany(mappedBy = "sucursal")
    private Set<Cliente> clientes;

    public Sucursal() {
        this.clientes = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getKeyXsa() {
        return keyXsa;
    }

    public void setKeyXsa(String keyXsa) {
        this.keyXsa = keyXsa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
}
