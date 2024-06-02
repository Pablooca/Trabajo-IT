package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registrarDepartamento extends ActionSupport {

    private int id;
    private String nombre;
    private String gerente;
    private String descripcion;

    public registrarDepartamento() {
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void validate() {
        String patronDNI = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";
        Pattern patron = Pattern.compile(patronDNI);
        Matcher matcher = patron.matcher(this.getGerente());
        String numeroDNI = "";
        String letraDNI = "";
        if (this.getGerente().length() == 0) {
            addFieldError("dni", "El DNI debe estar relleno");
        }
        else {
            numeroDNI = this.getGerente().substring(0, 8);
            letraDNI = this.getGerente().substring(8, 9);
        }
        if (this.getGerente().length() != 9) {
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
        if (this.getDescripcion().length() == 0){
            addFieldError("descripcion", "La descripcion debe estar rellena");
        }

    }

    private String letraDNI(int numero) {
        char caracteres[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = numero % 23;
        return String.valueOf(caracteres[resto]);
    }
    
}
