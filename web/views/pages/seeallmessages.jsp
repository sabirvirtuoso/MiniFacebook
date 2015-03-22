<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="headerafterlogin.jsp">
    <c:param name="heading" value="All Messages"></c:param>
    <c:param name="title" value="View Messages Page"></c:param>
</c:import>
<!--=== Container Part ===-->
<div class="container content">
    <div class="row">
        <div class="col-md-8 col-md-offset-2 col-sm-6 col-sm-offset-3">
            <div class="table-search-v2 panel panel-grey margin-bottom-50">
                <div class="panel-heading">
                    <h3 class="panel-title pull-left"><i class="glyphicon glyphicon-globe"></i> All Sent Messages</h3>

                    <div class="clearfix"></div>
                </div>
                <div class="table-responsive">
                    <table class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>Receiver</th>
                            <th class="hidden-sm">Message</th>
                            <th>Time Sent</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="messages" items="${sessionScope.user.sentMessages}">
                            <tr>
                                <td>${messages.userName}</td>
                                <td>${messages.messageText}</td>
                                <td>${messages.dateTimeOfMessage}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            </br>
            <div class="table-search-v2 panel panel-grey margin-bottom-50">
                <div class="panel-heading">
                    <h3 class="panel-title pull-left"><i class="glyphicon glyphicon-globe"></i> All Received Messages
                    </h3>

                    <div class="clearfix"></div>
                </div>
                <div class="table-responsive">
                    <table class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>Sender</th>
                            <th class="hidden-sm">Message</th>
                            <th>Time Sent</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="messages" items="${sessionScope.user.receivedMessages}" varStatus="loopCount">
                            <tr>
                                <td>${messages.userName}</td>
                                <td>${messages.messageText}</td>
                                <td>${messages.dateTimeOfMessage}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<!--/container-->
<!--=== End Container Part ===-->
<%@include file="footer.jsp" %>