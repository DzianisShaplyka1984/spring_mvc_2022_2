<%@ include file="common/header.jsp" %>
<%@ include file="common/menu.jsp" %>
    <c:forEach items="${authors}" var="author">
        <a href="<c:url value="/author?id=${author.id}"/>"> ${author.name}</a> <br>
    </c:forEach>

<%@ include file="common/footer.jsp" %>