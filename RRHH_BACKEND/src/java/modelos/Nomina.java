package modelos;
// Generated 01-jun-2024 18:16:29 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Nomina generated by hbm2java
 */
public class Nomina  implements java.io.Serializable {


     private int id;
     private BigDecimal salario;
     private String dni;

    public Nomina() {
    }

    public Nomina(int id, BigDecimal salario, String dni) {
       this.id = id;
       this.salario = salario;
       this.dni = dni;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public BigDecimal getSalario() {
        return this.salario;
    }
    
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }




}

