/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;

/**
 *
 * @author alex_
 */
public class actualizarAscenso extends ActionSupport{
    private int id;
    private String cargo;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String jefe_departamento;
    private String requisitos;

    public actualizarAscenso() {
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getJefe_departamento() {
        return jefe_departamento;
    }

    public void setJefe_departamento(String jefe_departamento) {
        this.jefe_departamento = jefe_departamento;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }
}
