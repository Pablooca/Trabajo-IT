<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operaciones CRUD Empleado</title>
        <link href="css/crudEmpleadoCSS.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Operaciones CRUD Empleados</h1>
        <h2>Añadir Empleado</h2>
        <s:form>
            <s:textfield name="dni" label="DNI"/>
            <s:textfield name="nombre" label="Nombre"/>
            <s:textfield name="apellidos" label="Apellidos"/>
            <s:textfield name="direccion" label="Direccion"/>
            <s:textfield name="cargo" label="Cargo"/>
            <s:submit value="Añadir Empleado" />
        </s:form>
        <h2>Buscar Empleado</h2>
        <s:form>
            <s:textfield name="dni" label="DNI"/>
            <s:submit value="Buscar Empleado"/>
        </s:form>
        <h2>Eliminar Empleado</h2>
        <s:form>
            <s:textfield name="dni" label="DNI"/>
            <s:submit value="Eliminar Empleado"/>
        </s:form>
        <h2>Actualizar Empleado</h2>
        <s:form>
            <s:textfield name="dni" label="DNI"/>
            <s:textfield name="nombre" label="Nombre"/>
            <s:textfield name="apellidos" label="Apellidos"/>
            <s:textfield name="direccion" label="Direccion"/>
            <s:textfield name="cargo" label="Cargo"/>
            <s:submit value="Actualizar Empleado" />
        </s:form>
    </body>
</html>
