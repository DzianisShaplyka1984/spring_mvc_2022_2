<%@ include file="common/header.jsp" %>
<%@ include file="common/menu.jsp" %>
        ${book.id} - ${book.title} - ${book.year}
        <br>
        Author
        <br>

        <c:forEach items="${book.authors}" var="author">
            ${author.name} <br>
        </c:forEach>

        <a href="<c:url value="/books"/>">Back to books</a>

<%@ include file="common/footer.jsp" %>