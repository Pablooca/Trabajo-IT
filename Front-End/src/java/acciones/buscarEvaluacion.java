package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;

public class buscarEvaluacion extends ActionSupport {

    private int id;

    public buscarEvaluacion() {
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
