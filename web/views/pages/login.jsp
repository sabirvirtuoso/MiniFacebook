<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="headerbeforelogin.jsp">
    <c:param name="title" value="Login Page"></c:param>
</c:import>
<!--=== Content Part ===-->
<div class="container content">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
            <c:if test="${!empty param.failure}">
                <c:import url="failurealert.jsp">
                    <c:param name="message" value="Invalid Credentials. Failed to login"></c:param>
                </c:import>
            </c:if>
            <form class="reg-page" action="login" method="post">
                <div class="reg-header">
                    <h2>Login to your account</h2>
                </div>
                <div class="input-group margin-bottom-20">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                    <input type="email" placeholder="Email" class="form-control" name="email" required/>
                </div>
                <div class="input-group margin-bottom-20">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input type="password" placeholder="Password" class="form-control" name="password" required/>
                </div>
                <div class="row">
                    <div class="col-md-7">
                        <label class="checkbox pull-left"><input type="checkbox" name="rememberme">Remember me</label>
                    </div>
                    <div class="col-md-5">
                        <button class="btn-u pull-right" type="submit">Login</button>
                    </div>
                </div>
                <hr>
                <h4>Not registered yet ?</h4>

                <p>no worries, <a class="color-green" href="<c:url value='/register' />">click here</a> to register.</p>
            </form>
        </div>
    </div>
    <!--/row-->
</div>
<!--/container-->
<!--=== End Content Part ===-->
<%@include file="footer.jsp" %>