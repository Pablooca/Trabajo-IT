<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/loginCSS.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="form-container">
            <h1>Login</h1>
            <s:form action="login">
                <s:textfield name="dni" label="DNI"/>
                <s:password name="password" label="Password"/>
                <s:submit value="Iniciar Sesion" />
            </s:form>
        </div> 
    </body>
</html>