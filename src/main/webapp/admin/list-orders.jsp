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
                           Order History
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> Order History 
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
         

                    <div class="col-lg-12">

                        <p><a href="order?page=addorder" role="button" class="btn btn-success">Add Order</a></p>

                          <c:out value="${update_message}"/>
                          <c:remove var="update_message" scope="session" />
                          
                          <c:out value="${delete_message}"/>
                          <c:remove var="delete_message" scope="session" />
                        
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Employee ID</th>
                                        <th>Menu ID</th>
                                        <th>Menu Type</th>
                                        <th>Entree</th>
                                        <th>Drink</th>
                                        <th>Menu Date</th>
                                        <th>Operations</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="tempOrder" items="${order_list}">
                                        
                                        <c:url var="temp" value="/admin/order">
                                            <c:param name="command" value="add"/>
                                            <c:param name="orderid" value="${tempOrder.id}"/>
                                            <c:param name="eid" value="${tempOrder.eid}"/>
                                        </c:url>
                                        
                                        <c:url var="tempdelete" value="/admin/order">
                                            <c:param name="command" value="delete"/>
                                            <c:param name="orderid" value="${tempOrder.id}"/>
                                        </c:url>
                                    <tr>
 
                                        <td>${tempOrder.eid}</td>
                                        <td>${tempOrder.mid}</td>
                                        <td>${tempOrder.mtype}</td>
                                        <td>${tempOrder.entree}</td>
                                        <td>${tempOrder.drink}</td>
                                        <td>${tempOrder.date}</td>
                                        <td>
                                           
                                            <a class='btn btn-warning' data-toggle="tooltip" title="Cancel " href="${tempdelete}" onclick="if (!(confirm('Confirm Delete?'))) return false"><span class='glyphicon glyphicon-minus'></span></a>
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