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
public class buscarEmpleado extends ActionSupport {
    
    private String dni;
    
    public buscarEmpleado() {
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

    }

    private String letraDNI(int numero) {
        char caracteres[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = numero % 23;
        return String.valueOf(caracteres[resto]);
    }
    
}
