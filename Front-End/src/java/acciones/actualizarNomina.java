/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alex_
 */
public class actualizarNomina extends ActionSupport {

    private int id;
    private float salario;
    private String DNI;

    public actualizarNomina() {
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    }

    private String letraDNI(int numero) {
        char caracteres[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = numero % 23;
        return String.valueOf(caracteres[resto]);
    }
}
