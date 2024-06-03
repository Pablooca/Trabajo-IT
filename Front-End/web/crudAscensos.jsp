<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operaciones CRUD Ascensos</title>
        <link href="css/crudAscensosCSS.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Operaciones CRUD Ascensos</h1>
        <h2>Añadir Ascenso</h2>
        <s:form action="registrarAscenso">
            <s:textfield name="cargo" label="cargo"/>
            <s:textfield name="fecha_inicio" label="fecha_inicio"/>
            <s:textfield name="fecha_fin" label="fecha_fin"/>
            <s:textfield name="jefe_departamento" label="jefe_departamento"/>
            <s:textfield name="requisitos" label="requisitos"/>
            <s:submit value="Añadir Ascenso" />
        </s:form>
        <h2>Buscar Ascenso</h2>
        <s:form action="buscarAscenso">
            <s:textfield name="id" label="id"/>
            <s:submit value="Buscar Ascenso"/>
        </s:form>
        <h2>Eliminar Ascenso</h2>
        <s:form action="eliminarAscenso">
            <s:textfield name="id" label="id"/>
            <s:submit value="Eliminar Ascenso"/>
        </s:form>
        <h2>Actualizar Ascenso</h2>
        <s:form action="actualizarAscenso">
            <s:textfield name="id" label="id"/>
            <s:textfield name="cargo" label="cargo"/>
            <s:textfield name="fecha_inicio" label="fecha_inicio"/>
            <s:textfield name="fecha_fin" label="fecha_fin"/>
            <s:textfield name="jefe_departamento" label="jefe_departamento"/>
            <s:textfield name="requisitos" label="requisitos"/>
            <s:submit value="Modificar Ascenso" />
        </s:form>
    </body>
</html>
