/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import modelos.Departamento;
import modelos.HibernateUtil;
import modelos.Nomina;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Pilar
 */
@WebService(serviceName = "NominaDAO")
public class NominaDAO {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultaNomina")
    @WebResult(name = "Nomina")
    public Nomina consultaNomina(@WebParam(name = "id") int id) {
        Nomina nomina = null;
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Nomina WHERE id=" + id);
            nomina = (Nomina) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return nomina;
    }
        
    @WebMethod(operationName = "consultaNominas")
    @WebResult(name = "Nomina")
    public ArrayList<Nomina> consultaNominas() {
        ArrayList lista = new ArrayList();
        try {

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Nomina");
            lista = (ArrayList<Nomina>) q.list();
            tx.commit();
        } catch (HibernateException e) {
        }

        return lista;
    }
    
    @WebMethod(operationName = "addNomina")
    @WebResult(name = "Nomina")
    public Nomina addNomina(@WebParam(name = "id") int id, @WebParam(name = "salario") float salario, @WebParam(name = "dni") String dni)  {
        Nomina nomina = null;
        try {
            BigDecimal sal = new BigDecimal(salario);
            nomina = new Nomina(id, sal, dni);

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            s.save(nomina);
            tx.commit();
        } catch (HibernateException e) {
        }

        return nomina;
    }

    @WebMethod(operationName = "updateNomina")
    @WebResult(name = "Nomina")
    public Nomina updateNomina(@WebParam(name = "id") int id, @WebParam(name = "salario") float salario, @WebParam(name = "dni") String dni) {
        Nomina nomina = null;

        try {

            BigDecimal sal = new BigDecimal(salario);
            nomina = new Nomina(id, sal, dni);

            Session s = HibernateUtil.getSessionFactory().openSession();

            Transaction tx;

            tx = s.beginTransaction();
            s.update(nomina);
            tx.commit();
        } catch ( HibernateException e) {

        }
        return nomina;
    }
    
    @WebMethod(operationName = "deleteNomina")
    @WebResult(name = "Nomina")
    public Nomina deleteNomina(@WebParam(name = "id") int id) {
        Nomina nomina = null;
        try {
            nomina = new Nomina();
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx;
            tx = s.beginTransaction();
            nomina.setId(id);
            s.delete(nomina);
            tx.commit();
        } catch (HibernateException e) {

        }
        return nomina;
    }
}
