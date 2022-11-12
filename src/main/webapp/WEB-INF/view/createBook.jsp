<%@ include file="common/header.jsp" %>
<%@ include file="common/menu.jsp" %>
        <form action="<c:url value="/createBook"/>">
            <label>Title: </label> <input name="title"> <br>
            <label>Year: </label> <input name="year"> <br>
            <label>Author: </label> <input name="author"> <br>
            <input type="submit" value="Create book">
        </form>

        <br>
        ----------------------------------------------
        <br>

        <c:url value="/createBook" var="createBookAction"/>

        <spring_form:form method="post" action="${createBookAction}" modelAttribute="createBook">
            <spring_form:label path="title">Title: </spring_form:label> <spring_form:input path="title"/> <br>
            <spring_form:label path="year">Year: </spring_form:label> <spring_form:input path="year"/> <br>
            <input type="submit" value="Create book">
        </spring_form:form>

        <a href="<c:url value="/books"/>">Back to books</a>
<%@ include file="common/footer.jsp" %>
