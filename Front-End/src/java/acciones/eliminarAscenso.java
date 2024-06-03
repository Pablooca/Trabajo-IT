package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;

public class eliminarAscenso extends ActionSupport {
    private int id;

    public eliminarAscenso() {
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
    
    public void validate(){
        
    }
    
    
}
