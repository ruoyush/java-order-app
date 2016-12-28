<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<jsp:include page="parts/header.jsp"/>
<jsp:include page="parts/slider.jsp"/>
    <!-- Page Content -->
    <div class="container">

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Core Features 
                </h1>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-check"></i>Project Tech Stack</h4>
                    </div>
                    <div class="panel-body">
                        <ul>
                            <li>Bootstrap</></li>
                            <li>jQuery</li>
                            <li>Servlet/JSP(JSTL) MVC</li>
                            <li>MySQL</li>
                            <li>Maven</li>

                        </ul>                  
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-gift"></i>Project Functionality</h4>
                    </div>
                    <div class="panel-body">
                        <ul>
                            <li>Two Roles: Admin and Employee</li>
                            <li>Admin: Manage orders,menus,employees</li>
                            <li>Employee: Order food, check history</li>
                            <li>Mobile and Desktop Responsively</li>

                        </ul>     
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-compass"></i> Website Security</h4>
                    </div>
                    <div class="panel-body">
                        <ul>
                            <li>Admin and Employee have different interfaces</li>
                            <li>Access control based on Session/Cookie</li>
                            <li>Password needed in order to use app</li>
                            <li>Admin and Employee have different permissions</li>
                        </ul>     
                    </div>
                </div>
            </div>
        </div>
        <!-- /.row -->


        <!-- Features Section -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Simple Instructions</h2>
            </div>
            <div class="col-md-6">
                <p>What's included?</p>
                <ul>
                    <li><strong>Project files(ready to import into NetBeans)</strong>
                    </li>
                    <li>War file(ready to deploy onto Tomcat)</li>
                    <li>SQL Database schema file(ready to import into MySQL)</li>
                    <li>JS/CSS and Java libraries</li>
                </ul>
                <p><strong>Hello, Professor Spring!</strong></p>
                <p>Thank you for checking my project. This is a personal project. You could login the app by the following two roles of users. I provide two sample accounts here. You might check and test other users by looking into the database.</p>
                <p>Please let me know if you have any questions.</p>
                <ul>
                    <li><strong>Admin: </strong></li>
                    <li>account: john@company.com  password:123</li>
                    <li><strong>Employee:  </strong></li>
                    <li>account: e1@company.com password:123456789</li>
                </ul>
            </div>
            <div class="col-md-6">
                <img class="img-responsive" src="images/lunch3.png" alt="">
            </div>
        </div>
        <!-- /.row -->

        <hr>

        <!-- Call to Action Section -->
        <div class="well">
            <div class="row">
                <div class="col-md-8">
                    <p>Contact me for questions or support.</p>
                </div>
                <div class="col-md-4">
                    <a class="btn btn-lg btn-default btn-block" href="mailto:rul29@pitt.edu">Contact me.</a>
                </div>
            </div>
        </div>

        <hr>

<jsp:include page="parts/footer.jsp"/>