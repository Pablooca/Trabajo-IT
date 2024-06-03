/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author alex_
 */
public class eliminarVacaciones extends ActionSupport{
    private int id;

    public eliminarVacaciones() {
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
