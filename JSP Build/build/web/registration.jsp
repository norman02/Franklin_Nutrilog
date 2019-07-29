<%@include file="assets/header.jsp" %>
		<!-- Heading -->
			<div id="heading" >
				<h1>Registration</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
                                            <h3>Please Enter Information</h3>
                                            <form action="registration.jsp" method="post">
						First Name <input name="firstName"/><br />
						Last Name <input name="lastName"/><br />
						Birth Date <input type="date" name="dob"/><br />
                                                Gender <input name="gender"/><br />
						Birth Time <input type="time" name="tob"/><br />
						Weight <input name="pounds"/>lbs <input name="ounces"/> oz<br /><br />
                                                <input type="submit" value="Register">
                                            </form>
					</div>
				</div>
			</section>
<%@include file="assets/footer.jsp" %>