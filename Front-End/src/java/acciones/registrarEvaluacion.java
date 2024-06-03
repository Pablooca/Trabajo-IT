/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author alex_
 */
public class registrarEvaluacion extends ActionSupport{
    private int id;
    private String DNI;
    private String anyo;
    private int companyerismo;
    private int eficiencia;
    private int iniciativa;
    private int liderazgo;
    private float nota_media;

    public registrarEvaluacion() {
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public int getCompanyerismo() {
        return companyerismo;
    }

    public void setCompanyerismo(int companyerismo) {
        this.companyerismo = companyerismo;
    }

    public int getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(int eficiencia) {
        this.eficiencia = eficiencia;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

    public int getLiderazgo() {
        return liderazgo;
    }

    public void setLiderazgo(int liderazgo) {
        this.liderazgo = liderazgo;
    }

    public float getNota_media() {
        return nota_media;
    }

    public void setNota_media(float nota_media) {
        this.nota_media = nota_media;
    }
    
    
    
}
