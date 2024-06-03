<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operaciones CRUD Departamento</title>
        <link href="css/crudDepartamentoCSS.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Operaciones CRUD Departamento</h1>
        <h2>Añadir Departamento</h2>
        <s:form action="registrarDepartamento">
            <s:textfield name="id" label="Id del departamento"/>
            <s:textfield name="nombre" label="Nombre del departamento"/>
            <s:textfield name="gerente" label="DNI del gerente del departamento"/>
            <s:textfield name="descripcion" label="Descripción del departamento"/>
            <s:submit value="Añadir Departamento" />
        </s:form>
        <h2>Buscar Empleado</h2>
        <s:form action="buscarDepartamento">
            <s:textfield name="id" label="Identificador del Departamento"/>
            <s:submit value="Buscar Departamento"/>
        </s:form>
        <h2>Eliminar Empleado</h2>
        <s:form action="eliminarDepartamento">
            <s:textfield name="id" label="Identificador del Departamento"/>
            <s:submit value="Eliminar Departamento"/>
        </s:form>
        <h2>Actualizar Departamento</h2>
        <s:form>
            <s:textfield name="id" label="Identificador"/>
            <s:textfield name="nombre" label="Nombre del Departamento"/>
            <s:textfield name="gerente" label="DNI del gerente del Departamento"/>
            <s:textfield name="descripcion" label="Descripción del Departamento"/>
            <s:submit value="Actualizar Departamento"/>
        </s:form>
    </body>
</html>
