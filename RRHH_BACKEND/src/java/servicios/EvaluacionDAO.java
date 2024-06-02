/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import modelos.Evaluacion;
import modelos.HibernateUtil;
import modelos.Vacaciones;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Pilar
 */
@WebService(serviceName = "EvaluacionDAO")
public class EvaluacionDAO {

    /**
     * This is a sample web service operation
     */ 
    @WebMethod(operationName = "consultaEvaluacion")
    @WebResult(name = "Evaluacion")
    public Evaluacion consultaEvaluacion(@WebParam(name = "id") int id) {
        Evaluacion vau = null;
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Evaluacion WHERE id=" + id);
            vau = (Evaluacion) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return vau;
    }
        
    @WebMethod(operationName = "consultaEvaluaciones")
    @WebResult(name = "Evaluacion")
    public ArrayList<Evaluacion> consultaEvaluaciones() {
        ArrayList lista = new ArrayList();
        try {

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Evaluacion");
            lista = (ArrayList<Evaluacion>) q.list();
            tx.commit();
        } catch (HibernateException e) {
        }

        return lista;
    }
    
    @WebMethod(operationName = "addEvaluacion")
    @WebResult(name = "Evaluacion")
    public Evaluacion addEvaluacion(@WebParam(name = "id") int id, @WebParam(name = "dni") String dni, @WebParam(name = "anyo") int anyo,
            @WebParam(name = "companyerismo") int companyerismo, @WebParam(name = "eficiencia") int eficiencia, @WebParam(name = "iniciativa") int iniciativa, 
            @WebParam(name = "liderazgo") int liderazgo)  {
        Evaluacion vau = null;
        
        BigDecimal notaMedia = new BigDecimal((companyerismo + eficiencia + iniciativa + liderazgo)/4);
            
        try {
            vau = new Evaluacion(id, dni, anyo, companyerismo, eficiencia, iniciativa, liderazgo, notaMedia);
            
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            s.save(vau);
            tx.commit();
        } catch (HibernateException e) {
        }

        return vau;
    }

    @WebMethod(operationName = "updateEvaluacion")
    @WebResult(name = "Evaluacion")
    public Evaluacion updateEvaluacion(@WebParam(name = "id") int id, @WebParam(name = "dni") String dni, @WebParam(name = "anyo") int anyo,
            @WebParam(name = "companyerismo") int companyerismo, @WebParam(name = "eficiencia") int eficiencia, @WebParam(name = "iniciativa") int iniciativa, 
            @WebParam(name = "liderazgo") int liderazgo) {
        Evaluacion vau = null;
        
        BigDecimal notaMedia = new BigDecimal((companyerismo + eficiencia + iniciativa + liderazgo)/4);
            
        try {

            vau = new Evaluacion(id, dni, anyo, companyerismo, eficiencia, iniciativa, liderazgo, notaMedia);

            Session s = HibernateUtil.getSessionFactory().openSession();

            Transaction tx;

            tx = s.beginTransaction();
            s.update(vau);
            tx.commit();
        } catch ( HibernateException e) {

        }
        return vau;
    }
    
    @WebMethod(operationName = "deleteEvaluacion")
    @WebResult(name = "Evaluacion")
    public Evaluacion deleteEvaluacion(@WebParam(name = "id") int id) {
        Evaluacion vau = null;
        try {
            vau = new Evaluacion();
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx;
            tx = s.beginTransaction();
            vau.setId(id);
            s.delete(vau);
            tx.commit();
        } catch (HibernateException e) {

        }
        return vau;
    }
}
