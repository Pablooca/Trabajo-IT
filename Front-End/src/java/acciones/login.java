package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login extends ActionSupport {
    
    private String dni;
    private String password;
    
    public login() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void validate(){
        String patronDNI = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";
        Pattern patron = Pattern.compile(patronDNI);
        Matcher matcher = patron.matcher(this.getDni());
        String numeroDNI = "";
        String letraDNI = "";
        if(this.getDni().length() == 0){
            addFieldError("dni", "El DNI debe estar relleno");
        }
        else {
            numeroDNI = this.getDni().substring(0, 8);
            letraDNI = this.getDni().substring(8, 9);
        }
        if(this.getDni().length() != 9){
            addFieldError("dni", "El DNI debe tener 9 caracteres");
        }
        if(!matcher.matches()){
            addFieldError("dni", "El DNI no está en el formato correcto");
        }
        if (numeroDNI.length() != 0 && letraDNI.compareTo(letraDNI(Integer.parseInt(numeroDNI))) != 0){
            addFieldError("dni", "La letra es erronea.");
        }
        if(this.getPassword().length() == 0){
            addFieldError("password", "La contraseña no puede estar vacía");
        }
        
    }
    
    private String letraDNI(int numero){
        char caracteres[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = numero % 23;
        return String.valueOf(caracteres[resto]);
    }
}
