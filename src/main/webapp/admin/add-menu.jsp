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
                            Add Menu
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Add Menu
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">

                        <form id="add" class="form-horizontal" name="add" action="menu" method="POST">

                            <fieldset>

                                <!-- Form Name -->
                                <legend><c:out value="${message}"/></legend>    
                                <c:remove var="message" scope="session" /> 

                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="entree">Name</label>  
                                    <div class="col-md-5">
                                        <input type="hidden" name="command" value="add" />
                                        
                                        <input id="entree" name="entree" placeholder="entree" class="form-control input-md" required="" type="text">
                                        <span class="help-block">please input entree name</span>  
                                    </div>
                                </div>


                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="drink">Drink</label>  
                                    <div class="col-md-4">
                                        <input id="email" name="drink" placeholder="Drink" class="form-control input-md" required="" type="text">

                                    </div>
                                </div>

                                <!-- Select Basic -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="month">Month</label>
                                    <div class="col-md-4">
                                        <select id="department" name="month" class="form-control">
                                            <option value="01">01</option>
                                            <option value="02">02</option>
                                            <option value="03">03</option>
                                            <option value="04">04</option>
                                            <option value="05">05</option>
                                            <option value="06">06</option>
                                            <option value="07">07</option>
                                            <option value="08">08</option>
                                            <option value="09">09</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="month">Day</label>
                                    <div class="col-md-4">
                                        <select id="department" name="day" class="form-control">
                                            <option value="01">01</option>
                                            <option value="02">02</option>
                                            <option value="03">03</option>
                                            <option value="04">04</option>
                                            <option value="05">05</option>
                                            <option value="06">06</option>
                                            <option value="07">07</option>
                                            <option value="08">08</option>
                                            <option value="09">09</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                            <option value="13">13</option>
                                            <option value="14">14</option>
                                            <option value="15">15</option>
                                            <option value="16">16</option>
                                            <option value="17">17</option>
                                            <option value="18">18</option>
                                            <option value="19">19</option>
                                            <option value="20">20</option>
                                            <option value="21">21</option>
                                            <option value="22">22</option>
                                            <option value="23">23</option>
                                            <option value="24">24</option>
                                            <option value="25">25</option>
                                            <option value="26">26</option>
                                            <option value="27">27</option>
                                            <option value="28">28</option>
                                            <option value="29">29</option>
                                            <option value="30">30</option>
                                            <option value="31">31</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="month">year</label>
                                    <div class="col-md-4">
                                        <select id="department" name="year" class="form-control">
                                            <option value="2016">2016</option>
                                            <option value="2017">2017</option>
                                            <option value="2018">2018</option>
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