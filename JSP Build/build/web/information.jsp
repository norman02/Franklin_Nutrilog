<%@include file="assets/header.jsp" %>
		<!-- Heading -->
			<div id="heading" >
				<h1>Infant Information</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
                                            <h2>${results.firstName} ${results.lastName} (#: ${results.id})</h2>
                                            <h3>Gender: ${results.gender}<br />
                                                Born: ${results.dob} at ${results.tob}<br />
                                                Weight at Birth: ${results.birthWeight}</h3> 
						<table>
							<tr>
                                                            <th>Last Fed</th>
                                                            <th>Amount</th>
                                                            <th>Last Changed</th>
                                                            <th>Last Weighed</th>
                                                            <th>Weight</th>
							</tr>
                                                        <tr>
                                                            <td>${lastFed.eventDate}</td>
                                                            <td>${lastFed.foodAmount} ${lastFed.foodUnits}</td>
                                                            <td>${lastChanged.eventDate}</td>
                                                            <td>${lastWeighed.eventDate}</td>
                                                            <td>${lastWeighed.weight}</td>
                                                        </tr>
						</table>
					</div>
				</div>
			</section>
<%@include file="assets/footer.jsp" %>