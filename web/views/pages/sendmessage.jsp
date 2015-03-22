<form action="/sendmessage" method="post">
    <input type="text" style="display:none" name="userid" value="${users.userId}">

    <div class="input-group col-md-12 margin-bottom-0">
        <textarea type="text" placeholder="Message Text" class="form-control" name="message" required></textarea>
    </div>
    <div class="row">
        <div class="col-md-12">
            <button class="btn-u pull-right" type="submit">Send Message</button>
        </div>
    </div>
</form>