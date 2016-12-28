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
                            Add Order
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Add Order
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">

                        <form id="add" class="form-horizontal" name="add" action="order" method="POST">

                            <fieldset>
                                <!-- Form Name -->
                                <legend><c:out value="${message}"/></legend>    
                                <c:remove var="message" scope="session" />                                   
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="mtype">Please Choose your preference of the meal</label>
                                    <div class="col-md-8">
                                        <select id="choice" name="mtype" class="form-control">
                                            <option value="regular">Regular</option>
                                            <option value="vegen">Vegetarian</option>
                                            <option value="nopork">Pork-free</option>
                                        </select>
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="choice">Please Choose one of the menu from the list</label>
                                    <div class="col-md-8">
                                        
                                        <select id="choice" name="choice" class="form-control">
                                            <c:forEach var="tempMenu" items="${menu_list}">
                                                <option value="${tempMenu.id},${tempMenu.entree},${tempMenu.drink},${tempMenu.date}"><span>${tempMenu.entree} | ${tempMenu.drink} | ${tempMenu.date}</span></option>
                                                
                                            </c:forEach> 
                                        </select>
                                        
                                    </div>
                                </div>
                                
                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="ecomment">Comment</label>
                                    <div class="col-md-8">
                                          
                                        <input type="hidden" name="command" value="add" />
                                        <input type="hidden" name="eid" value="${sessionId}" />
                                        <input id="entree" name="ecomment" placeholder="" class="form-control input-md"  type="text">
                                        <span class="help-block">If you have some special instructions, please leave here.</span>  
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

  $("form[name='']").validate({
    rules: {
        
      entree: {
        required: true
       //regx: /^[a-zA-Z][a-zA-Z0-9]*$/
      },
      
      drink:{
        required: true
      },
      month: {
        required: true
      },
      day: {
        required: true
      },
      year: {
        required: true
      }
    },
    // Specify validation error messages
    messages: {
      entree: {
          required: "Please enter an entree name"
          //regx: "The first character cannot be numric, only accept number and letter."
      },
      
      drink: {
        required: "Please provide a drink perference"
      },
      
      month: {
        required: "Please indicate a month"
      },
      day: {
        required: "Please provide a day"
      },
      year: {
        required: "Please provide a year"
      }

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