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
import modelos.Empleado;
import modelos.Evaluacion;
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
@WebService(serviceName = "EmpleadoDAO")
public class EmpleadoDAO {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultaEmpleado")
    @WebResult(name = "Empleado")
    public Empleado consultaEmpleado(@WebParam(name = "dni") String dni) {
        Empleado empleado = null;
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Empleado WHERE dni='" + dni + "'");
            empleado = (Empleado) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return empleado;
    }
    
    @WebMethod(operationName = "consultaEmpleados")
    @WebResult(name = "Empleado")
    public ArrayList<Empleado> consultaEmpleados() {
        ArrayList lista = new ArrayList();
        try {

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Empleado");
            lista = (ArrayList<Empleado>) q.list();
            tx.commit();
        } catch (HibernateException e) {
        }

        return lista;
    }
    
    @WebMethod(operationName = "addEmpleado")
    @WebResult(name = "Empleado")
    public Empleado addEmpleado(@WebParam(name = "dni") String dni, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "direccion") String direccion,
            @WebParam(name = "cargo") String cargo, @WebParam(name = "departamento") int departamento, @WebParam(name = "idAscensos") int idAscensos, @WebParam(name = "contrasena") String contrasena)  {
        Empleado empleado = null;
        try {
            empleado = new Empleado(dni, nombre, apellidos, direccion, cargo, departamento, idAscensos, contrasena);

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            s.save(empleado);
            tx.commit();
        } catch (HibernateException e) {
        }

        return empleado;
    }

    @WebMethod(operationName = "updateEmpleado")
    @WebResult(name = "Empleado")
    public Empleado updateEmpleado(@WebParam(name = "dni") String dni, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "direccion") String direccion,
            @WebParam(name = "cargo") String cargo, @WebParam(name = "departamento") int departamento, @WebParam(name = "idAscensos") int idAscensos, @WebParam(name = "contrasena") String contrasena) {
        Empleado empleado = null;

        try {

            empleado = new Empleado(dni, nombre, apellidos, direccion, cargo, departamento, idAscensos, contrasena);

            Session s = HibernateUtil.getSessionFactory().openSession();

            Transaction tx;

            tx = s.beginTransaction();
            s.update(empleado);
            tx.commit();
        } catch ( HibernateException e) {

        }
        return empleado;
    }
    
    @WebMethod(operationName = "deleteEmpleado")
    @WebResult(name = "Empleado")
    public Empleado deleteCliente(@WebParam(name = "dni") String dni) {
        Empleado empleado = null;
        try {
            empleado = new Empleado();
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx;
            tx = s.beginTransaction();
            empleado.setDni(dni);
            s.delete(empleado);
            tx.commit();
        } catch (HibernateException e) {

        }
        return empleado;
    }
    
    @WebMethod(operationName = "nominasEmpleado")
    @WebResult(name = "Nomina")
    public ArrayList<Nomina> nominasEmpleado(@WebParam(name = "dni") String dni) {
        ArrayList lista = new ArrayList();
        try {

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Nomina Where dni= '" + dni + "'");
            lista = (ArrayList<Nomina>) q.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return lista;
    }
    
    @WebMethod(operationName = "vacacionesEmpleado")
    @WebResult(name = "Vacaciones")
    public ArrayList<Vacaciones> vacacionesEmpleado(@WebParam(name = "dni") String dni) {
        ArrayList lista = new ArrayList();
        try {

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Vacaciones Where dni= '" + dni + "'");
            lista = (ArrayList<Vacaciones>) q.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return lista;
    }
    
    @WebMethod(operationName = "evaluacionesEmpleado")
    @WebResult(name = "Evaluacion")
    public ArrayList<Evaluacion> evaluacionesEmpleado(@WebParam(name = "dni") String dni) {
        ArrayList lista = new ArrayList();
        try {

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            Query q = s.createQuery("From Evaluacion Where dni= '" + dni + "'");
            lista = (ArrayList<Evaluacion>) q.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return lista;
    }
    
}
