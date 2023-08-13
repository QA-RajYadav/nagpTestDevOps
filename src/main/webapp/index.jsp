<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <title>CalCulatorApp</title>
</head>
<body>
    <h2>Calculator</h2>

    <h3>Build Triggered on 13 Aug 2023!!!</h3>

    <c:set var="strResult" value="${requestScope.RESULT}" />

    <form action="CalculatorServlet" method="post">
        <input type="text" name="num1" /> <label>+</label>
        <input type="text" name="num2" /> <label>=</label>

        <c:if test="${not empty strResult}">
            <p> The result is ${strResult} </p>
        </c:if>

        <br/>
        <input type="submit" value="Calculate"/>
    </form>
</body>
</html>
