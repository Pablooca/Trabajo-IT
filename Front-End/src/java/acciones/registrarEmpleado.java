/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pablo
 */
public class registrarEmpleado extends ActionSupport {

    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String cargo;

    public registrarEmpleado() {
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void validate() {
        String patronDNI = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";
        Pattern patron = Pattern.compile(patronDNI);
        Matcher matcher = patron.matcher(this.getDni());
        String numeroDNI = "";
        String letraDNI = "";
        if (this.getDni().length() == 0) {
            addFieldError("dni", "El DNI debe estar relleno");
        }
        else {
            numeroDNI = this.getDni().substring(0, 8);
            letraDNI = this.getDni().substring(8, 9);
        }
        if (this.getDni().length() != 9) {
            addFieldError("dni", "El DNI debe tener 9 caracteres");
        }
        if (!matcher.matches()) {
            addFieldError("dni", "El DNI no está en el formato correcto");
        }
        if (numeroDNI.length() != 0 && letraDNI.compareTo(letraDNI(Integer.parseInt(numeroDNI))) != 0) {
            addFieldError("dni", "La letra es erronea.");
        }
        if (this.getNombre().length() == 0) {
            addFieldError("nombre", "El nombre debe estar relleno");
        }
        if (this.getApellidos().length() == 0) {
            addFieldError("apellidos", "Los apellidos deben estar rellenos");
        }
        if (this.getDireccion().length() == 0) {
            addFieldError("direccion", "La direccion debe estar rellena");
        }
        if (this.getCargo().length() == 0) {
            addFieldError("cargo", "El cargo debe estar relleno");
        }

    }

    private String letraDNI(int numero) {
        char caracteres[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = numero % 23;
        return String.valueOf(caracteres[resto]);
    }

}
