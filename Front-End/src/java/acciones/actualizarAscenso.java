package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    public void validate(){
        String patronDNI = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";
        Pattern patron = Pattern.compile(patronDNI);
        Matcher matcher = patron.matcher(this.getJefe_departamento());
        String numeroDNI = "";
        String letraDNI = "";
        if (this.getCargo().length() == 0){
            addFieldError("cargo", "El cargo debe estar relleno");
        }
        if(this.getRequisitos().length() == 0){
            addFieldError("requisitos", "Debe haber algún requisito para el ascenso");
        }
        if (this.getJefe_departamento().length() == 0){
            addFieldError("jefe_departamento", "El jefe de departamento debe estar relleno");
        }
        else {
            numeroDNI = this.getJefe_departamento().substring(0, 8);
            letraDNI = this.getJefe_departamento().substring(8, 9);
        }
        if (this.getJefe_departamento().length() != 9) {
            addFieldError("jefe_departamento", "El DNI debe tener 9 caracteres");
        }
        if (!matcher.matches()) {
            addFieldError("jefe_departamento", "El DNI no está en el formato correcto");
        }
        if (numeroDNI.length() != 0 && letraDNI.compareTo(letraDNI(Integer.parseInt(numeroDNI))) != 0) {
            addFieldError("jefe_departamento", "La letra es erronea.");
        }
    }
    
    private String letraDNI(int numero) {
        char caracteres[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = numero % 23;
        return String.valueOf(caracteres[resto]);
    }
}
