/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import modelos.Ascensos;
import modelos.Empleado;
import modelos.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Pilar
 */
@WebService(serviceName = "AscensosDAO")
public class AscensosDAO {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultaAscenso")
    @WebResult(name = "Ascenso")
    public Ascensos consultaAscenso(@WebParam(name = "id") int id) {
        Ascensos ascenso = null;
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Ascensos WHERE id=" + id);
            ascenso = (Ascensos) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return ascenso;
    }
        
        
    @WebMethod(operationName = "consultaAscensos")
    @WebResult(name = "Ascenso")
    public ArrayList<Ascensos> consultaAscensos() {
        ArrayList lista = new ArrayList();
        try {

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Ascensos");
            lista = (ArrayList<Ascensos>) q.list();
            tx.commit();
        } catch (HibernateException e) {
        }

        return lista;
    }
    
    @WebMethod(operationName = "addAscenso")
    @WebResult(name = "Ascenso")
    public Ascensos addAscenso(@WebParam(name = "id") int id, @WebParam(name = "cargo") String cargo, @WebParam(name = "fechaInicio") String fechaInicio, @WebParam(name = "fechaFin") String fechaFin,
            @WebParam(name = "jefeDepartamento") String jefeDepartamento, @WebParam(name = "requisitos") String requisitos) throws ParseException  {
        Ascensos ascenso = null;
        try {
            
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha_ini = format.parse(fechaInicio);
            Date fecha_fin = format.parse(fechaFin);

            ascenso = new Ascensos(id, cargo, fecha_ini, fecha_fin, jefeDepartamento, requisitos);

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            s.save(ascenso);
            tx.commit();
        } catch (HibernateException e) {
        }

        return ascenso;
    }

    @WebMethod(operationName = "updateAscenso")
    @WebResult(name = "Ascenso")
    public Ascensos updateAscenso(@WebParam(name = "id") int id, @WebParam(name = "cargo") String cargo, @WebParam(name = "fechaInicio") String fechaInicio, @WebParam(name = "fechaFin") String fechaFin,
            @WebParam(name = "jefeDepartamento") String jefeDepartamento, @WebParam(name = "requisitos") String requisitos) throws ParseException {
        Ascensos ascenso = null;

        try {
            
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha_ini = format.parse(fechaInicio);
            Date fecha_fin = format.parse(fechaFin);

            ascenso = new Ascensos(id, cargo, fecha_ini, fecha_fin, jefeDepartamento, requisitos);

            Session s = HibernateUtil.getSessionFactory().openSession();

            Transaction tx;

            tx = s.beginTransaction();
            s.update(ascenso);
            tx.commit();
        } catch ( HibernateException e) {

        }
        return ascenso;
    }
    
    @WebMethod(operationName = "deleteAscenso")
    @WebResult(name = "Ascenso")
    public Ascensos deleteAscenso(@WebParam(name = "id") int id) {
        Ascensos ascenso = null;
        try {
            ascenso = new Ascensos();
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx;
            tx = s.beginTransaction();
            ascenso.setId(id);
            s.delete(ascenso);
            tx.commit();
        } catch (HibernateException e) {

        }
        return ascenso;
    }
    
    @WebMethod(operationName = "candidatosAscenso")
    @WebResult(name = "Empleado")
    public List<Empleado> candidatosAscenso(@WebParam(name = "id") int id) {
        List lista = new ArrayList();
        try {

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Empleado Where id_ascensos= " + id);
            lista = (List<Empleado>) q.list();
            tx.commit();
        } catch (HibernateException e) {
        }

        return lista;
    }
    
}
