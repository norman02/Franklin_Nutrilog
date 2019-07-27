<%@include file="assets/header.jsp" %>
		<!-- Heading -->
			<div id="heading" >
				<h1>Registration</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
                                            <form action="registration" method="post">
                                                <input type="hidden" name="action" value="addPerson"/>
						First Name <input name="firstName"/><br />
						Last Name <input name="lastName"/><br />
						Birth Date <input type="date" name="dob"/><br />
                                                Gender <input name="gender"/><br />
						Birth Time <input type="time"/><br />
						Weight <input />lbs <input /> oz<br /><br />
                                                <input type="submit" value="Register">
                                            </form>
					</div>
				</div>
			</section>
<%@include file="assets/footer.jsp" %>