<%@include file="assets/header.jsp" %>
		<!-- Heading -->
			<div id="heading" >
				<h1>Log an Event</h1>
			</div>
		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
                                            <form action="event.jsp" method="post">
                                                <h3>Event Information</h3>
						Registration Number <input name="patientNumber"/><br />
                                                Event Date <input type="date" name="date"/><br />
                                                Event Time <input type="time" name="time"/><br />
                                                <br /><h3>Feeding</h3>
                                                Amount Fed <input name="foodAmount"/><br />
						<select name="foodUnits">
							<option>Select</option>
							<option>Minutes</option>
							<option>Milliliters</option>
                                                        <option>Ounces</option>
						</select>
                                                <br /><h3>Changing</h3>
                                                Diaper Contents
						<select name="diaper">
                                                        <option>Select</option>
							<option>Urine Only</option>
							<option>Stool Only</option>
							<option>Both Urine and Stool</option>
						</select>
                                                <br /><h3>Weighing</h3>
						Update Weight <input name="pounds"/>lbs <input name="ounces"/>oz
                                                <br /><br /><input type="submit" value="Log Event">
                                            </form>
					</div>
				</div>
			</section>
<%@include file="assets/footer.jsp" %>