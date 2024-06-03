package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    public void validate() {
        String patronDNI = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";
        Pattern patron = Pattern.compile(patronDNI);
        Matcher matcher = patron.matcher(this.getDNI());
        String numeroDNI = "";
        String letraDNI = "";
        if (this.getDNI().length() == 0) {
            addFieldError("DNI", "El DNI debe estar relleno");
        }
        else {
            numeroDNI = this.getDNI().substring(0, 8);
            letraDNI = this.getDNI().substring(8, 9);
        }
        if (this.getDNI().length() != 9) {
            addFieldError("DNI", "El DNI debe tener 9 caracteres");
        }
        if (!matcher.matches()) {
            addFieldError("DNI", "El DNI no está en el formato correcto");
        }
        if (numeroDNI.length() != 0 && letraDNI.compareTo(letraDNI(Integer.parseInt(numeroDNI))) != 0) {
            addFieldError("DNI", "La letra es erronea.");
        }
        if(this.getAnyo().length() == 0){
            addFieldError("anyo", "El año debe estar relleno");
        }

    }

    private String letraDNI(int numero) {
        char caracteres[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = numero % 23;
        return String.valueOf(caracteres[resto]);
    }
    
}
