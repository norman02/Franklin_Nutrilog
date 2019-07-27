<%@include file="assets/header.jsp" %>
		<!-- Heading -->
			<div id="heading" >
				<h1>Log an Event</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						Registration Number <input /><br />
						Event Type
						<select>
							<option>Select</option>
							<option>Feeding</option>
							<option>Changing</option>
							<option>Weighing</option>
						</select>
						Amount Fed
						<select>
							<option>Select</option>
							<option>Minutes</option>
							<option>Cubic Centimeters</option>
						</select>
						<input /><br />
						Changed
						<select>
							<option>Select</option>
							<option>Yes</option>
							<option>No</option>
						</select>
						<input /><br />
						Urine/Stool Present
						<select>
							<option>Select</option>
							<option>Urine Only</option>
							<option>Stool Only</option>
							<option>Both Urine and Stool</option>
						</select>
						Update Weight <input />lbs <input />oz
					</div>
				</div>
			</section>
<%@include file="assets/footer.jsp" %>