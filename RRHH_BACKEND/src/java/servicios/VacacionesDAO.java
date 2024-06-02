/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import modelos.HibernateUtil;
import modelos.Nomina;
import modelos.Vacaciones;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Pilar
 */
@WebService(serviceName = "VacacionesDAO")
public class VacacionesDAO {

    /**
     * This is a sample web service operation
     */ 
    @WebMethod(operationName = "consultaVacaciones")
    @WebResult(name = "Vacaciones")
    public Vacaciones consultaVacaciones(@WebParam(name = "id") int id) {
        Vacaciones vacas = null;
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Vacaciones WHERE id=" + id);
            vacas = (Vacaciones) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return vacas;
    }
        
    @WebMethod(operationName = "consultaTodasVacaciones")
    @WebResult(name = "Vacaciones")
    public ArrayList<Vacaciones> consultaTodasVacaciones() {
        ArrayList lista = new ArrayList();
        try {

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Vacaciones");
            lista = (ArrayList<Vacaciones>) q.list();
            tx.commit();
        } catch (HibernateException e) {
        }

        return lista;
    }
    
    @WebMethod(operationName = "addVacaciones")
    @WebResult(name = "Vacaciones")
    public Vacaciones addVacaciones(@WebParam(name = "id") int id, @WebParam(name = "dni") String dni, @WebParam(name = "fechaInicio") String fechaInicio, 
            @WebParam(name = "fechaFin") String fechaFin, @WebParam(name = "motivo") String motivo) throws ParseException  {
        Vacaciones vacas = null;
        try {
            
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha_ini = format.parse(fechaInicio);
            Date fecha_fin = format.parse(fechaFin);

            vacas = new Vacaciones(id, dni, fecha_ini, fecha_fin, motivo);

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            s.save(vacas);
            tx.commit();
        } catch (HibernateException e) {
        }

        return vacas;
    }

    @WebMethod(operationName = "updateVacaciones")
    @WebResult(name = "Vacaciones")
    public Vacaciones updateVacaciones(@WebParam(name = "id") int id, @WebParam(name = "dni") String dni, @WebParam(name = "fechaInicio") Date fechaInicio, 
            @WebParam(name = "fechaFin") Date fechaFin, @WebParam(name = "motivo") String motivo) {
        Vacaciones vacas = null;

        try {

            vacas = new Vacaciones(id, dni, fechaInicio, fechaFin, motivo);

            Session s = HibernateUtil.getSessionFactory().openSession();

            Transaction tx;

            tx = s.beginTransaction();
            s.update(vacas);
            tx.commit();
        } catch ( HibernateException e) {

        }
        return vacas;
    }
    
    @WebMethod(operationName = "deleteVacaciones")
    @WebResult(name = "Vacaciones")
    public Vacaciones deleteVacaciones(@WebParam(name = "id") int id) {
        Vacaciones vacas = null;
        try {
            vacas = new Vacaciones();
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx;
            tx = s.beginTransaction();
            vacas.setId(id);
            s.delete(vacas);
            tx.commit();
        } catch (HibernateException e) {

        }
        return vacas;
    }
}
