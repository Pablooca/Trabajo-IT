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
import modelos.Departamento;
import modelos.Empleado;
import modelos.Nomina;
import modelos.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Pilar
 */
@WebService(serviceName = "DAO")
public class DAO {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultaEmpleado")
    @WebResult(name = "Empleado")
    public Empleado consultaEmpleado(@WebParam(name = "dni") String dni) {
        Empleado empleado = null;
        try {
            Session s1 = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = s1.beginTransaction();
            Query q1 = s1.createQuery("From Empleado WHERE dni='" + dni + "'");
            List lista = (List<Empleado>) q1.list();
            empleado = (Empleado) lista.get(0);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return empleado;
    }
    
    @WebMethod(operationName = "consultaEmpleados")
    @WebResult(name = "Empleado")
    public List<Empleado> consultaEmpleados() {
        List lista = new ArrayList();
        try {

            Session s1 = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s1.beginTransaction();
            Query q1 = s1.createQuery("From Empleado");
            lista = (List<Empleado>) q1.list();
            tx.commit();
        } catch (HibernateException e) {
        }

        return lista;
    }
    @WebMethod(operationName = "updateEmpleado")
    @WebResult(name = "Empleado")
    public Empleado updateEmpleado(@WebParam(name = "dni") String dni, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "direccion") String direccion,
            @WebParam(name = "cargo") String cargo, @WebParam(name = "departamento") int departamento, @WebParam(name = "idAscensos") int idAscensos, @WebParam(name = "contrasena") String contrasena) {
        Empleado empleado = null;

        try {

            empleado = new Empleado(dni, nombre, apellidos, direccion, cargo, departamento, idAscensos, contrasena);

            Session s1 = HibernateUtil.getSessionFactory().openSession();

            Transaction tx;

            tx = s1.beginTransaction();
            s1.update(empleado);
            tx.commit();
        } catch ( HibernateException e) {

        }
        return empleado;
    }
    
    @WebMethod(operationName = "addEmpleado")
    @WebResult(name = "Empleado")
    public Empleado addCliente(@WebParam(name = "dni") String dni, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "direccion") String direccion,
            @WebParam(name = "cargo") String cargo, @WebParam(name = "departamento") int departamento, @WebParam(name = "idAscensos") int idAscensos, @WebParam(name = "contrasena") String contrasena)  {
        Empleado empleado = null;
        try {
            empleado = new Empleado(dni, nombre, apellidos, direccion, cargo, departamento, idAscensos, contrasena);

            Session s1 = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s1.beginTransaction();
            s1.save(empleado);
            tx.commit();
        } catch (HibernateException e) {
        }

        return empleado;
    }

    @WebMethod(operationName = "deleteEmpleado")
    @WebResult(name = "Empleado")
    public Empleado deleteCliente(@WebParam(name = "dni") String dni) {
        Empleado empleado = null;
        try {
            empleado = new Empleado();
            Session s1 = HibernateUtil.getSessionFactory().openSession();
            Transaction tx;
            tx = s1.beginTransaction();
            empleado.setDni(dni);
            s1.delete(empleado);
            tx.commit();
        } catch (HibernateException e) {

        }
        return empleado;
    }
    
    @WebMethod(operationName = "consultaDPTO")
    @WebResult(name = "Departamento")
    public Departamento consultaDPTO(@WebParam(name = "id") String id) {
        Departamento dpto = null;
        try {
            Session s1 = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = s1.beginTransaction();
            Query q1 = s1.createQuery("From Departamento WHERE id=" + id);
            List lista = (List<Empleado>) q1.list();
            dpto = (Departamento) lista.get(0);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return dpto;
    }
    
    @WebMethod(operationName = "consultaGerente")
    @WebResult(name = "Gerente")
    public Empleado consultaGerente(@WebParam(name = "id") String id) {
        Empleado gerente = null;
        try {
            Session s1 = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = s1.beginTransaction();
            Query q1 = s1.createQuery("From Empleado WHERE Departamento=" + id + " AND cargo = 'gerente'");
            List lista = (List<Empleado>) q1.list();
            gerente = (Empleado) lista.get(0);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return gerente;
    }
    
    @WebMethod(operationName = "consultaAscenso")
    @WebResult(name = "Ascenso")
    public Ascensos consultaAscenso(@WebParam(name = "id") String id) {
        Ascensos ascenso = null;
        try {
            Session s1 = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = s1.beginTransaction();
            Query q1 = s1.createQuery("From Ascensos WHERE id=" + id);
            List lista = (List<Empleado>) q1.list();
            ascenso = (Ascensos) lista.get(0);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("es cosa de hibernate");
        }

        return ascenso;
    }
}
