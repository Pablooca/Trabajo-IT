<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operaciones CRUD Evaluacion</title>
        <link href="css/crudEvaluacionCSS.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Operaciones CRUD Evaluacion</h1>
        <h2>Añadir Evaluacion</h2>
        <s:form action="registrarEvaluacion">
            <s:textfield name="DNI" label="DNI"/>
            <s:textfield name="anyo" label="anyo"/>
            <s:textfield name="companyerismo" label="companyerismo"/>
            <s:textfield name="eficiencia" label="eficiencia"/>
            <s:textfield name="iniciativa" label="iniciativa"/>
            <s:textfield name="liderazgo" label="liderazgo"/>
            <s:textfield name="nota_media" label="nota_media"/>
            <s:submit value="Añadir Evaluacion" />
        </s:form>
        <h2>Buscar Evaluacion</h2>
        <s:form action="buscarEvaluacion">
            <s:textfield name="id" label="id"/>
            <s:submit value="Buscar Evaluacion"/>
        </s:form>
        <h2>Eliminar Evaluacion</h2>
        <s:form action="eliminarEvaluacion">
            <s:textfield name="id" label="id"/>
            <s:submit value="Eliminar Evaluacion"/>
        </s:form>
        <h2>Actualizar Evaluacion</h2>
        <s:form action="actualizarEvaluacion">
            <s:textfield name="ID" label="ID"/>
            <s:textfield name="DNI" label="DNI"/>
            <s:textfield name="anyo" label="anyo"/>
            <s:textfield name="companyerismo" label="companyerismo"/>
            <s:textfield name="eficiencia" label="eficiencia"/>
            <s:textfield name="iniciativa" label="iniciativa"/>
            <s:textfield name="liderazgo" label="liderazgo"/>
            <s:textfield name="nota_media" label="nota_media"/>
            <s:submit value="Modificar Evaluacion" />
        </s:form>
    </body>
</html>