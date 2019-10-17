<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean scope="page" id="customer6" class="ru.antony.entity.CustomerBean" />
<jsp:setProperty name="customer6" property="firstName" value="David" />
<jsp:setProperty name="customer6" property="lastName" value="Heffelfinger" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>Демонстрация Унифицированного языка выражений</title>
</head>
<body>
    <div>Пользователь подключен к контексту приложения:
        <!-- Применяется метод toString() в CustomerBean -->
        ${applicationScope.customer1}
    </div>
    <br/><br/>
    <div>Пользователь подключен к контексту сеанса:
        ${sessionScope.customer2.firstName}
        ${sessionScope.customer2.lastName}
    </div>
    <br /><br />
    <div>Пользователь подключен к контексту запроса:
        ${requestScope.customer3}
    </div>
    <br />
    <br />
    <div>Пользователь подключен к контексту страницы:
        ${pageScope.customer6}
    </div>
    <br />
    <br />
    <div>Список пользователей, подключенных к сеансу (session):<br />
        ${sessionScope.customerList[0]}
        <br />
        ${sessionScope.customerList[1].firstName}
        ${sessionScope.customerList[1].lastName}
    </div>
</body>
</html>