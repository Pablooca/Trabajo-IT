/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;

/**
 *
 * @author alex_
 */
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
    
    
    
    
}
