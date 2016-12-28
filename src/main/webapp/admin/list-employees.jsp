<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:choose>
    <c:when test="${sessionScope.sessionRole.equals('admin')}">
<jsp:include page="parts/header.jsp"/>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Employees List 
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> Employees List 
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
         

                    <div class="col-lg-12">

                        <p><a href="employee?page=addemp" role="button" class="btn btn-success">Add Employee</a></p>

                          <c:out value="${update_message}"/>
                          <c:remove var="update_message" scope="session" />
                          
                          <c:out value="${delete_message}"/>
                          <c:remove var="delete_message" scope="session" />
                        
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Email</th>
                                        <th>Manager ID</th>
                                        <th>Department</th>
                                        <th>Operations</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="tempEmp" items="${emoployee_list}">
                                        
                                        <c:url var="temp" value="/admin/employee">
                                            <c:param name="command" value="load"/>
                                            <c:param name="empid" value="${tempEmp.id}"/>
                                        </c:url>
                                        
                                        <c:url var="tempdelete" value="/admin/employee">
                                            <c:param name="command" value="delete"/>
                                            <c:param name="empid" value="${tempEmp.id}"/>
                                        </c:url>
                                    <tr>
 
                                        <td>${tempEmp.name}</td>
                                        <td>${tempEmp.email}</td>
                                        <td>${tempEmp.aid}</td>
                                        <td>${tempEmp.department}</td>
                                        <td>
                                            <a class='btn btn-warning' data-toggle="tooltip" title="Update" href="${temp}"><span class='glyphicon glyphicon-refresh '></span></a>
                                            <a class='btn btn-warning' data-toggle="tooltip" title="Remove" href="${tempdelete}" onclick="if (!(confirm('Confirm Delete?'))) return false"><span class='glyphicon glyphicon-minus'></span></a>
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