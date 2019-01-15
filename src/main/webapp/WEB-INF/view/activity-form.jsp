<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Save Activity</title>
    <style>
        .error {color: red; font-weight: bold}
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/res/css/style.css">

    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/res/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>My IT Diary</h2>
    </div>
</div>

<div id="container">
    <h3>Save Activity</h3>

    <form:form action="saveActivity" modelAttribute="activity" method="post">

        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>Date:</label></td>
                <td>
                    <form:input type="date" path="date"/>
                    <form:errors path="date" cssClass="error"/>
                </td>

            </tr>

            <tr>
                <td><label>Activity:</label></td>
                <td>
                    <form:select path="task">
                        <form:option value="${task}"/>
                        <form:options items="${activityList}"/>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td><label>Details:</label></td>
                <td><form:textarea rows="5" cols="29" path="details"/></td>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
            </tr>
            </tbody>
        </table>
    </form:form>

    <div style="clear; both; ">
    </div>
    <p>
        <a href="${pageContext.request.contextPath}/activity/list">Back to List</a>
    </p>
</div>
</body>
</html>
