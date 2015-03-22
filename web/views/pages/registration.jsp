<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="headerbeforelogin.jsp">
    <c:param name="title" value="Registration Page"></c:param>
</c:import>
<!--=== Content Part ===-->
<div class="container content">
    <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
        <c:if test="${!empty param.success}">
            <c:import url="successalert.jsp">
                <c:param name="message" value="Registered Successfully"></c:param>
            </c:import>
        </c:if>
        <form class="reg-page" action="register" method="post" enctype="multipart/form-data">
            <div class="reg-header">
                <h2>Register a new account</h2>

                <p>Already Signed Up? Click <a href="<c:url value='/login' />" class="color-green">Sign In</a> to login
                    your account.</p>
            </div>
            <label>First Name</label>
            <input type="text" class="form-control margin-bottom-20" name="firstname">
            <label>Last Name</label>
            <input type="text" class="form-control margin-bottom-20" name="lastname">
            <label>Email Address <span class="color-red">*</span></label>
            <input type="email" class="form-control margin-bottom-20" name="email" required/>

            <div class="row">
                <div class="col-sm-6">
                    <label>Password <span class="color-red">*</span></label>
                    <input type="password" class="form-control margin-bottom-20" name="password" required/>
                </div>
                <div class="col-sm-6">
                    <label>Confirm Password <span class="color-red">*</span></label>
                    <input type="password" class="form-control margin-bottom-20" required/>
                </div>
            </div>
            <label>Date Of Birth <span class="color-red">*</span></label>
            <input type="date" class="form-control margin-bottom-20 controls input-append" name="dob" required/>
            <label>Address <span class="color-red">*</span></label>
            <input type="text" class="form-control margin-bottom-20" name="address" required/>
            <label>Occupation <span class="color-red">*</span></label>
            <input type="text" class="form-control margin-bottom-20" name="occupation" required/>
            <label>Upload Photo</label>
            <input type="file" class="form-control margin-bottom-20" name="uploadfile">
            <hr>
            <div class="row">
                <div class="col-lg-6">
                    <label class="checkbox">
                        <input type="checkbox">
                        I read <a href="#" class="color-green">Terms and Conditions</a>
                    </label>
                </div>
                <div class="col-lg-6 text-right">
                    <button class="btn-u" type="submit">Register</button>
                </div>
            </div>
        </form>
    </div>
</div>
<!--/container-->
<!--=== End Content Part ===-->
<%@include file="footer.jsp" %>