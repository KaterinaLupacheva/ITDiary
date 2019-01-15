<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>List Activities</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/res/css/style.css" />

</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>My IT Diary</h2>
    </div>

    <div id="container">
        <div id="content">

            <input type="button" value="Add Activity"
                   onclick="window.location.href='showFormForAdd'; return false;"
                   class="add-button"
            />
            <table>
                <tr>
                    <th>Date</th>
                    <th>Task</th>
                    <th>Details</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="tempActivity" items="${activities}">

                    <c:url var="updateLink" value="/activity/showFormForUpdate">
                        <c:param name="activityId" value="${tempActivity.id}"/>
                    </c:url>

                    <c:url var="deleteLink" value="/activity/delete">
                        <c:param name="activityId" value="${tempActivity.id}"/>
                    </c:url>

                    <tr>
                        <td>${tempActivity.date}</td>
                        <td>${tempActivity.task}</td>
                        <td>${tempActivity.details}</td>
                        <td>
                            <a href="${updateLink}">Update
                                |
                                <a href="${deleteLink}"
                                   onclick="if (!(confirm('Are you sure you want to delete this activity?'))) return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-end">
        <li class="page-item">
            <c:set var="page_num" scope="request" value="${param.page}"/>
            <c:if test="${page_num > 1}"><a class="page-link" href="${pageContext.request.contextPath}/activity/list?page=${param.page-1}">Previous</a></c:if>
        </li>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/activity/list?page=1">1</a></li>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/activity/list?page=2">2</a></li>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/activity/list?page=3">3</a></li>
        <li class="page-item">
            <a class="page-link" href="${pageContext.request.contextPath}/activity/list?page=${param.page+1}">Next</a>
        </li>
    </ul>
</nav>

</body>
</html>
