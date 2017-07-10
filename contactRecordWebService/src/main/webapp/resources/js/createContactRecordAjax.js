/*
 * Pathname is contextRoot/path/path/ we we want to get [1]
 * that is where contextRoot is. [0] is "" as a result of split
 */

var contextRoot = "/" + window.location.pathname.split( '/' )[1];

function createContactRecord(){
   	var contactDetail= JSON.stringify(getFormData());
   	
   	 $.ajax({
		type: 'POST',
		url: contextRoot + '/contactRecords/create',

		dataType: "json",           // Accept header
 		data:contactDetail,
 		contentType: 'application/json',   // Sends - Content-type
		success: function(data){
			$('#errors').html("");
 			$("#validation").append('Respose Status code '+data.status+'</br>'+data.message+'</br>');
 			$("#validation").append(' End!</br>')
	 	    $('#validation').show();
		},
 
		error: function(errorObject){	
			
			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>'); 
			if (errorObject.responseJSON.errorType == "ValidationError") {
	 			$('#success').html("");
	 			$('#errors').html("");
	 			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
	  			    $("#validation").append( '<p>');
	  	
	  			    var errorList = errorObject.responseJSON.errors;
	 	 	        $.each(errorList,  function(i,error) {			   
	 		    		$("#errors").append( error.message + '<br>');
			    	});
	 	 	        $("#errors").append( '</p>');
	 	 	        $('#validation').show();
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
 		}
	});
}

 /*
  * reset the from
  */
resetForm = function(id) {
    var element = document.getElementById(id);
    $(element)[0].reset();

    }	  
	

make_hidden = function(id) {
    var e = document.getElementById(id);
        e.style.display = 'none';
        }	   

make_visible = function(id) {
    var e = document.getElementById(id);
    e.style.display = 'block';
 }	   

/*
 * save the image and return the url
 */
function saveAndRetrunLargeIMageUrl(){
	//save large image
	return $('#largImageUrl').val();
}
function saveAndReturnSmallImageUrl(){
	//save small image 
	return $('#smallImageUrl').val();
}

/*
 * Collect form data and then put it in JSON format
 */
function getFormData(){
	   
	    var name=$('#name').val();
	    var company=$('#company').val();
	    var favourite=$("input:radio[name=favourite]:checked").val();
	    var email=$('#email').val();
	    var website=$('#website').val();
	    var birthDate=$('#birthDate').val();
	    var smallImageUrl=saveAndReturnSmallImageUrl();
	    var largImageUrl=saveAndRetrunLargeIMageUrl();
	    var longitude=$('#longitude').val();
	    var latitude=$('#latitude').val();
	    //phone data
	    
	    var work=$('#work').val();
	    var home=$('#home').val();
	    var mobile=$('#mobile').val();
	    
	    //Address data
	    
	    var street=$('#street').val();
	    var city=$('#city').val();
	    var state=$('#state').val();
	    var country=$('#country').val();
	    var zip=$('#zip').val();
	    
	    
	    var phone={
	        "work":work,
	    	"home":home,
	        "mobile":mobile,
	    }
	    
	    var address={
	        "street":street,
	        "city":city,
	        "state":state,
	        "country":country,
	        "zip":zip,
	        "longitude":longitude,
	        "latitude":latitude
	    }
	    var contactDetail={
	        "name":name,
	        "company":company,
	        "favourite":favourite,
	        "email":email,
	        "website":website,
	        "birthDate":birthDate,
	        "smallImageUrl":smallImageUrl,
	        "largImageUrl":largImageUrl,
	        "phone":phone,
	        "address":address
	    }
	
	return contactDetail;
		
	
}
/*
 * collect location information and set the attributes
 */
function initGeolocation()
{
   if( navigator.geolocation )
   {
      // Call getCurrentPosition with success and failure callbacks
      navigator.geolocation.getCurrentPosition( success, fail );
   }
   else
   {
      alert("Sorry, your browser does not support geolocation services.");
   }
}

function success(position)
{

    document.getElementById('longitude').value = position.coords.longitude;
    document.getElementById('latitude').value = position.coords.latitude
}

function fail()
{
   // Could not obtain location
}






 