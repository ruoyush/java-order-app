<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:choose>
    <c:when test="${sessionScope.sessionRole!=null}">
<jsp:include page="parts/header.jsp"/>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Menu List 
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> Menu List 
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
         

                    <div class="col-lg-12">
                        <c:choose>
                            <c:when test="${sessionScope.sessionRole.toString().equals('admin')}">
                                 <p><a href="menu?page=addmenu" role="button" class="btn btn-success">Add Menu</a></p>
                            </c:when>
                            <c:otherwise>
               
                            </c:otherwise>
                        </c:choose>
                          <c:out value="${update_message}"/>
                          <c:remove var="update_message" scope="session" />
                          
                          <c:out value="${delete_message}"/>
                          <c:remove var="delete_message" scope="session" />
                        
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Entree</th>
                                        <th>Drink</th>
                                        <th>Available Date</th>
                                        <th>Operations</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                    <c:forEach var="tempMenu" items="${menu_list}">
                                        
                                        <c:url var="temp" value="/admin/menu">
                                            <c:param name="command" value="load"/>
                                            <c:param name="menuid" value="${tempMenu.id}"/>
                                        </c:url>
                                        
        
                                        
                                        <c:url var="tempdelete" value="/admin/menu">
                                            <c:param name="command" value="delete"/>
                                            <c:param name="menuid" value="${tempMenu.id}"/>
                                        </c:url>
                                    <tr>
 
                                        <td>${tempMenu.entree}</td>
                                        <td>${tempMenu.drink}</td>
                                        <td>${tempMenu.date}</td>

                                        <td>
                                        <c:choose>
                                            <c:when test="${sessionScope.sessionRole.toString().equals('admin')}">
                                            <a class='btn btn-warning' data-toggle="tooltip" title="Update" href="${temp}"><span class='glyphicon glyphicon-refresh '></span></a>
                                            
                                            <a class='btn btn-warning' data-toggle="tooltip" title="Remove" href="${tempdelete}" onclick="if (!(confirm('Confirm Delete?'))) return false"><span class='glyphicon glyphicon-minus'></span></a>
                                            </c:when>
                                        <c:otherwise>
                                            <span>No Authorization to delete or update</span>
                                        </c:otherwise>
                                        </c:choose>
                                        </td> 
                                    </tr>
                                     </c:forEach> 
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

             

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

<jsp:include page="parts/footer.jsp"/>
</c:when>
<c:otherwise>
    <script>
          alert(" Please login first" );
          window.location = '../index.jsp';
    </script> 
</c:otherwise>
</c:choose>