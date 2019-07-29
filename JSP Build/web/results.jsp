<%@include file="assets/header.jsp" %>
		<!-- Heading -->
			<div id="heading" >
				<h1>Search Results</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						<table>
							<tr>
                                                            <th></th>
                                                            <th>Registration Number</th>
                                                            <th>Last Name</th>
                                                            <th>First Name</th>
                                                            <th>Gender</th>
							</tr>
                                                        <c:forEach var="person" items="${results}">
                                                            <tr>
                                                                <td>
                                                                    <form action="information.jsp" method="get">
                                                                        <input type="hidden" name="searchValue" value="${person.id}"/><br />
                                                                        <input type="submit" value="View Patient Record">
                                                                    </form>
                                                                </td>
                                                                <td>${person.id}</td>
                                                                <td>${person.lastName}</td>
                                                                <td>${person.firstName}</td>
                                                                <td>${person.gender}</td>
                                                            </tr>
                                                        </c:forEach>
						</table>
					</div>
				</div>
			</section>
<%@include file="assets/footer.jsp" %>