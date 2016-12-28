 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

    <div class="collapse navbar-collapse navbar-ex1-collapse">
      
          
           <c:choose>
             
               
               <c:when test="${sessionScope.sessionRole.toString().equals('admin')}">
                <ul class="nav navbar-nav side-nav">
                    <li class="">
                        <a href="index.jsp"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#orders-toggle"><i class="fa fa-fw fa-wrench"></i> Manage Orders <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="orders-toggle" class="collapse">
                            <li>
                                <a href="order?page=checkorder">Check Orders</a>
                            </li>
                            <li>
                                <a href="order?page=addorder">Add Order</a>
                            </li>
                        </ul>
                    </li>
                    
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#menus-toggle"><i class="fa fa-fw fa-glass"></i> Menus <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="menus-toggle" class="collapse">
                            <li>
                                <a href="menu?page=checkmenu">Check Menus</a>
                            </li>
                            <li>
                                <a href="menu?page=addmenu">Add Item</a>
                            </li>
                        </ul>
                    </li>
                    
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#emp-toggle"><i class="fa fa-fw fa-arrows-v"></i> Employees <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="emp-toggle" class="collapse">
                            <li>
                                <a href="employee?page=checkemp">Check Employees</a>
                            </li>
                            <li>
                                <a href="employee?page=addemp">Add Employees</a>
                            </li>
                        </ul>
                    </li>
                    
                </ul>
               </c:when>
               <c:otherwise>
                   
                   <ul class="nav navbar-nav side-nav">
                       <li class="">
                           <a href="index.jsp"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                       </li>

                       <li>
                           <a href="javascript:;" data-toggle="collapse" data-target="#orders-toggle"><i class="fa fa-fw fa-wrench"></i> Manage Orders <i class="fa fa-fw fa-caret-down"></i></a>
                           <ul id="orders-toggle" class="collapse">
                               <li>
                                   <a href="order?page=checkorder">Check Orders</a>
                               </li>
                               <li>
                                   <a href="order?page=addorder">Add Order</a>
                               </li>
                           </ul>
                       </li>

                       <li>
                           <a href="javascript:;" data-toggle="collapse" data-target="#menus-toggle"><i class="fa fa-fw fa-arrows-v"></i> Menus <i class="fa fa-fw fa-caret-down"></i></a>
                           <ul id="menus-toggle" class="collapse">
                               <li>
                                   <a href="menu?page=checkmenu">Check Menus</a>
                               </li>
                           </ul>
                       </li>


                   </ul>
               </c:otherwise>
           </c:choose>
            </div>