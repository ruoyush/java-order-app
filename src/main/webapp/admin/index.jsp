<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:choose>
    <c:when test="${sessionScope.sessionRole!=null}">
        <jsp:include page="parts/header.jsp"/>
            <div id="page-wrapper">

                <div class="container-fluid">
                    <c:choose>
                        <c:when test="${sessionScope.sessionRole.toString().equals('admin')}">
                            <jsp:include page="/admin/admin-content.jsp"/>  
                        </c:when>
                    <c:otherwise>
                        <jsp:include page="/admin/admin-emp-content.jsp"/>  
                    </c:otherwise>
                    </c:choose>
                </div>
            <!-- /.container-fluid -->
             </div>
        <!-- /#page-wrapper -->
        <jsp:include page="parts/footer.jsp"/>
    </c:when>
    <c:otherwise>
        <script>
              alert(" Please login first" );
              window.location = '../index.jsp';
        </script> 
    </c:otherwise>
</c:choose>

