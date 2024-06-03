<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operaciones CRUD Nominas</title>
        <link href="css/crudNominaCSS.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Operaciones CRUD Nominas</h1>
        <h2>Añadir Ascenso</h2>
        <s:form action="registrarNomina">
            <s:textfield name="salario" label="salario"/>
            <s:textfield name="DNI" label="DNI"/>
            <s:submit value="Añadir Nomina" />
        </s:form>
        <h2>Buscar Nomina</h2>
        <s:form action="buscarNomina">
            <s:textfield name="id" label="id"/>
            <s:submit value="Buscar Nomina"/>
        </s:form>
        <h2>Eliminar Nomina</h2>
        <s:form action="eliminarNomina">
            <s:textfield name="id" label="id"/>
            <s:submit value="Eliminar Nomina"/>
        </s:form>
        <h2>Actualizar Nomina</h2>
        <s:form action="actualizarNomina">
            <s:textfield name="salario" label="salario"/>
            <s:textfield name="DNI" label="DNI"/>
            <s:submit value="Modificar Nomina" />
        </s:form>
    </body>
</html>
