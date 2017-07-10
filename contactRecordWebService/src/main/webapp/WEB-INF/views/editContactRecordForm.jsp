<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Edit Contact Record Form</title>
		<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
		<script type="text/javascript"src="<spring:url value="/resource/js/editContactRecordAjax.js"/>"></script>
</head>
<body>
	<!-- Include navigation menu -->
	<div>
		<%@ include file="navigation.jsp"%>
	</div>

	<!-- Success - or Validation errors -->
	<div id="result" style="display: none">
		<p id="success"></p>
		<p id="errors"></p>
		<h4 align="center">
			<a href="#"
				onclick="make_hidden('result');resetForm('editcontactRecordForm');">
				<b>EXIT</b>
			</a>
		</h4>
	</div>

	<div id="rightList">

		<select id="contactRecordList">
			<option value="-1">Select Contact Name...</option>

		</select> <input type="button" value="Search Contact-Record"
			onclick="retrieveContactRecord();" />
	</div>

	<div id="global">
		<form id="editcontactRecordForm" method="post">
			<fieldset>
				<legend>Edit Contact Record</legend>
                <p>
                <input type="hidden" id="id" name="contactId"/>
                </p>
				<p>
					<label for="contactName"><spring:message
							code="contact.name" /> </label> <input type="text" name="name" id="name" />

				</p>

				<p>
					<label for="company"><spring:message code="contact.company" />
					</label> <input type="text" name="company" id="company" />

				</p>

				<p>
					<label for="favorite"><spring:message code="contact.favourite" /> </label> 
					<input type="radio" name="favourite" value="true" id="rad1" />Yes 
					 <input type="radio" name="favourite" value="false" id="rad2"/>No


				</p>
				<p>
					<label for="email"><spring:message code="contact.email" />
					</label> <input type="email" name="email" id="email" />

				</p>

				<p>
					<label for="website"><spring:message code="contact.website" />
					</label> <input type="text" name="website" id="website" />

				</p>
				<p>
					<label for="birthDate"><spring:message
							code="contact.birthDate" /> </label> <input type="date" name="birthDate"
						id="birthDate" />

				</p>
				<p>
					<label for="smallImageUrl"><spring:message
							code="contact.smallImageUrl" /> </label> <input type="file"
						name="smaillImageUrl" id="smallImageUrl" />

				</p>
				<p>
					<label for="largImageUrl"><spring:message
							code="contact.largImageUrl" /> </label> <input type="file"
						name="largeImageUrl" id="largImageUrl" />

				</p>
				<p>
					<label for="work"><spring:message code="contact.phone.work" />
					</label> <input type="text" name="phone.work" id="work" />

				</p>
				<p>
					<label for="home"><spring:message code="contact.phone.home" />
					</label> <input type="text" name="phone.home" id="home" />

				</p>
				<p>
					<label for="mobile"><spring:message
							code="contact.phone.mobile" /> </label> <input type="text"
						name="phone.mobile" id="mobile" />

				</p>
				<p>
					<label for="street"><spring:message
							code="contact.address.street" /> </label> <input type="text"
						name="address.street" id="street" />

				</p>
				<p>
					<label for="city"><spring:message
							code="contact.address.city" /> </label> <input type="text"
						name="address.city" id="city" />

				</p>
				<p>
					<label for="state"><spring:message
							code="contact.address.state" /> </label> <input type="text"
						name="address.state" id="state" />

				</p>
				<p>
					<label for="city"><spring:message
							code="contact.address.country" /> </label> <input type="text"
						name="address.country" id="country" />

				</p>
				<p>
					<label for="zip"><spring:message code="contact.address.zip" />
					</label> <input type="text" name="address.country" id="zip" />

				</p>
				<p>
					<input type="hidden" id="longitude" name="longitude" />
				</p>
				<p>
					<input type="hidden" id="latitude" name="latitude" />
				</p>
				<p id="buttons">
					<input type="button" value="Update Record"
						onclick="initGeolocation();updateContactRecord();" /> <input
						type="button" value="Delete Record"
						onclick="deleteContactRecord();" />
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>