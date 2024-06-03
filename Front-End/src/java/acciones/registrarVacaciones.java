/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alex_
 */
public class registrarVacaciones extends ActionSupport {

    private int id;
    private String DNI;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String motivo;

    public registrarVacaciones() {
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void validate() {
        String patronDNI = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";
        Pattern patron = Pattern.compile(patronDNI);
        Matcher matcher = patron.matcher(this.getDNI());
        String numeroDNI = "";
        String letraDNI = "";
        if (this.getDNI().length() == 0) {
            addFieldError("dni", "El DNI debe estar relleno");
        } else {
            numeroDNI = this.getDNI().substring(0, 8);
            letraDNI = this.getDNI().substring(8, 9);
        }
        if (this.getDNI().length() != 9) {
            addFieldError("dni", "El DNI debe tener 9 caracteres");
        }
        if (!matcher.matches()) {
            addFieldError("dni", "El DNI no está en el formato correcto");
        }
        if (numeroDNI.length() != 0 && letraDNI.compareTo(letraDNI(Integer.parseInt(numeroDNI))) != 0) {
            addFieldError("dni", "La letra es erronea.");
        }
        if (this.getMotivo().length() == 0){
            addFieldError("motivo", "Las vacaciones deben ser justificadas");
        }

    }

    private String letraDNI(int numero) {
        char caracteres[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = numero % 23;
        return String.valueOf(caracteres[resto]);
    }

}
