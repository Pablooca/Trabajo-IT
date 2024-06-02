/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import modelos.Departamento;
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
@WebService(serviceName = "DPTODAO")
public class DPTODAO {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultaDPTO")
    @WebResult(name = "Departamento")
    public Departamento consultaDPTO(@WebParam(name = "id") String id) {
        Departamento dpto = null;
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Departamento WHERE id=" + id);
            dpto = (Departamento) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return dpto;
    }
        
    @WebMethod(operationName = "consultaDPTOs")
    @WebResult(name = "Departamento")
    public ArrayList<Departamento> consultaDPTOs() {
        ArrayList lista = new ArrayList();
        try {

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Departamento");
            lista = (ArrayList<Departamento>) q.list();
            tx.commit();
        } catch (HibernateException e) {
        }

        return lista;
    }
    
    @WebMethod(operationName = "addDPTO")
    @WebResult(name = "Departamento")
    public Departamento addDPTO(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "gerente") String gerente)  {
        Departamento dpto = null;
        try {
            dpto = new Departamento(id, nombre, descripcion, gerente);

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            s.save(dpto);
            tx.commit();
        } catch (HibernateException e) {
        }

        return dpto;
    }

    @WebMethod(operationName = "updateDPTO")
    @WebResult(name = "Departamento")
    public Departamento updateDPTO(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "gerente") String gerente) {
        Departamento dpto = null;

        try {

            dpto = new Departamento(id, nombre, descripcion, gerente);

            Session s = HibernateUtil.getSessionFactory().openSession();

            Transaction tx;

            tx = s.beginTransaction();
            s.update(dpto);
            tx.commit();
        } catch ( HibernateException e) {

        }
        return dpto;
    }
    
    @WebMethod(operationName = "deleteDPTO")
    @WebResult(name = "Departamento")
    public Departamento deleteDPTO(@WebParam(name = "id") int id) {
        Departamento dpto = null;
        try {
            dpto = new Departamento();
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx;
            tx = s.beginTransaction();
            dpto.setId(id);
            s.delete(dpto);
            tx.commit();
        } catch (HibernateException e) {

        }
        return dpto;
    }
    
    @WebMethod(operationName = "consultaGerente")
    @WebResult(name = "Empleado")
    public Empleado consultaGerente(@WebParam(name = "id") int id) {
        Empleado Empleado = null;
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Empleado WHERE departamento=" + id + " AND cargo='gerente'");
            Empleado = (Empleado) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return Empleado;
    }
    
    @WebMethod(operationName = "empleadosDpto")
    @WebResult(name = "Empleado")
    public ArrayList<Empleado> empleadosDpto(@WebParam(name = "id") int id) {
        ArrayList lista = new ArrayList();
        try {

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Empleado Where departamento= " + id);
            lista = (ArrayList<Empleado>) q.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return lista;
    }
    
}
