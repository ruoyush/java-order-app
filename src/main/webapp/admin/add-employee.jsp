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
                            Add Employees
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Add Employee
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">

                        <form id="add" class="form-horizontal" name="add" action="employee" method="POST">

                            <fieldset>

                                <!-- Form Name -->
                                <legend><c:out value="${message}"/></legend>
                                
                                
                                <c:remove var="message" scope="session" /> 

                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="username">Name</label>  
                                    <div class="col-md-5">
                                        <input type="hidden" name="command" value="add" />
                                        
                                        <input id="username" name="username" placeholder="your name here" class="form-control input-md" required="" type="text">
                                        <span class="help-block">please input the first and last name</span>  
                                    </div>
                                </div>

                                <!-- Password input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="pass">Password</label>
                                    <div class="col-md-5">
                                        <input id="password" name="password" placeholder="password here" class="form-control input-md" required="" type="password">
                                        <span class="help-block">minimum length: 8</span>
                                    </div>
                                </div>

                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="email">E-mail</label>  
                                    <div class="col-md-4">
                                        <input id="email" name="email" placeholder="E-mail" class="form-control input-md" required="" type="email">

                                    </div>
                                </div>

                                <!-- Select Basic -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="department">Department</label>
                                    <div class="col-md-4">
                                        <select id="department" name="department" class="form-control">
                                            <jsp:include page="parts/department_list.jsp"/>
                                        </select>
                                    </div>
                                </div>

                            </fieldset>

                            <div class="form-group">
                                <label class="col-md-4 control-label" for="submit"></label>
                                <div class="col-md-8">
                                    <button id="submit" name="submit" type="submit" class="btn btn-success">submit</button>
                                    <button id="reset" name="reset" type="reset" class="btn btn-inverse">Reset</button>
                                </div>
                            </div>

                        </form>

                    </div>
                    
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    
    <script>


$(function() {
    $.validator.addMethod("regx", function(value, element, regexpr) {          
    return regexpr.test(value);
    }, "Provide a valid input for experience.");

  $("form[name='add']").validate({
    rules: {
        
      username: {
        required: true,
        regx: /^[a-zA-Z][a-zA-Z0-9]*$/
      },
      
      email: {
        required: true,
        email: true
      },
      password: {
        required: true,
        minlength: 8,
        regx: /^[0-9a-zA-z]*$/
      }
    },
    // Specify validation error messages
    messages: {
      username: {
          required: "Please enter your name",
          regx: "The first character cannot be numric, only accept number and letter."
      },
      
      password: {
        required: "Please provide a password",
        minlength: "Your password must be at least 8 characters long",
        regx: "Password only accept number and letter."
      },
      email: "Please enter a valid email address"
    }
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    // submitHandler: function(form) {
    // form.submit();
    //}
  });
});
    </script>
<jsp:include page="parts/footer.jsp"/>
</c:when>
<c:otherwise>
    <script>
          alert(" Please login first" );
          window.location = '../index.jsp';
    </script> 
</c:otherwise>
</c:choose>