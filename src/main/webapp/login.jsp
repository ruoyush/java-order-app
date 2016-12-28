<jsp:include page="parts/header.jsp"/>

    
    <div class="container">
        <div class="row">
            <p></p>
        </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form id="login" class="form-horizontal" name="login" action="${pageContext.request.contextPath}/login" method="POST">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                
                                <div class="form-group">
                                    <label class="control-label" for="role">Role Choice</label>

                                        <select class="form-control" name="role">
                                            <option value="employee">employee</option>
                                            <option value="admin">admin</option>
                                        </select>

                                </div>   

                                <!-- Change this to a button or input when using this as a form -->
                               <div class="form-group">
                                <label class="col-md-4 control-label" for="submit"></label>
                                <div class="col-md-8">
                                    <button id="submit" name="submit" type="submit" class="btn btn-success">submit</button>
                                </div>
                                
                                
                             </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>



<jsp:include page="parts/footer.jsp"/>
