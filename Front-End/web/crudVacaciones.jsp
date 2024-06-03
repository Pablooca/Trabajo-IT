<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operaciones CRUD Vacaciones</title>
        <link href="css/crudVacacionesCSS.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Operaciones CRUD Vacaciones</h1>
        <h2>Añadir Vacaciones</h2>
        <s:form action="registrarVacaciones">
            <s:textfield name="DNI" label="DNI"/>
            <s:textfield name="fecha_fin" label="fecha_fin"/>
            <s:textfield name="fecha_inicio" label="fecha_inicio"/>
            <s:textfield name="motivo" label="motivo"/>
            <s:submit value="Añadir Vacaciones" />
        </s:form>
        <h2>Buscar Vacaciones</h2>
        <s:form action="buscarVacaciones">
            <s:textfield name="id" label="id"/>
            <s:submit value="Buscar Vacaciones"/>
        </s:form>
        <h2>Eliminar Vacaciones</h2>
        <s:form action="eliminarVacaciones">
            <s:textfield name="id" label="id"/>
            <s:submit value="Eliminar Vacaciones"/>
        </s:form>
        <h2>Actualizar Vacaciones</h2>
        <s:form action="actualizarVacaciones">
            <s:textfield name="id" label="id"/>
            <s:textfield name="DNI" label="DNI"/>
            <s:textfield name="fecha_fin" label="fecha_fin"/>
            <s:textfield name="fecha_inicio" label="fecha_inicio"/>
            <s:textfield name="motivo" label="motivo"/>
            <s:submit value="Modificar Ascenso" />
        </s:form>
    </body>
</html>