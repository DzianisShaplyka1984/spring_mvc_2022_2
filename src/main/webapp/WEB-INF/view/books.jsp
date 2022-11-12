<%@ include file="common/header.jsp" %>
<%@ include file="common/menu.jsp" %>
        <a href="<c:url value="/showCreateBook"/>">Create book</a>

        <br>

        <c:forEach items="${books}" var="book">
            <a href="<c:url value="/book?id=${book.id}"/>"> ${book.title} - ${book.price} </a> <br>
        </c:forEach>

<%@ include file="common/footer.jsp" %>