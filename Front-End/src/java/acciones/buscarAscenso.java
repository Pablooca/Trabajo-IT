/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author alex_
 */
public class buscarAscenso extends ActionSupport{
        private int id;

    public buscarAscenso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
            @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
