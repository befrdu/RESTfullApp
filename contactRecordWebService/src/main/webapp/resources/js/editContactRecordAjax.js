/*
 * pathname is contextRoot/path/path/ so we want to get [1] 
 * that is where contextRoot is [0] has "" as a result of split 
 */ 
     
	var contextRoot = "/" + window.location.pathname.split( '/' )[1];
	
/*
 * Populate select box when the form load
 */
$(document).ready(function(){
        $('#contactRecordList').empty();
        $.ajax({
                      type: "GET",
                      url: contextRoot + '/contactRecords/contactList',
                      success: function(data){
                    	
                    	var select=$('#contactRecordList');
                    	if(data.length==0){
                    		 select.append('<option value="'+-1+'">'+"Contact List is Empty..."+'</option>');
                    	}
                        for(var i=0; i<data.length;i++){
                        	select.append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
                        }
                      },
                      error: function(jqXHR, textStatus, errorThrown) { 
                    	  select.append('<option value="'+-1+'">'+"No Record..."+'</option>');
                      }
        });
 }); 
	
/*
 * delete contact record
 */
function deleteContactRecord(){
	var id=$('#id').val();
   	 $.ajax({
		type: 'DELETE',
		url: contextRoot + '/contactRecords/delete/'+id,
		dataType: "json",           // Accept header
 		//data:dataToSend,
 		//contentType: 'application/json',   // Sends - Content-type
		success: function(data){
			$('#errors').html("");
 			$("#result").append( 'Status code '+data.status+'</br>'+data.message);                
	 	    $('#result').show();
		},
 
		error: function(errorObject ){		
			alert("Error")
 		}
	});
}

/*
 * update contact record
 */
function updateContactRecord(){
   	var dataToSend = JSON.stringify(getFormData());
   	 $.ajax({
		type: 'PUT',
		url: contextRoot + '/contactRecords/update',
		dataType: "json",           // Accept header
 		data:dataToSend,
 		contentType: 'application/json',   // Sends - Content-type
		success: function(data){
			$('#errors').html("");
 			$("#result").append( 'Status code '+data.status+'</br>'+data.message);                
	 	    $('#result').show();
		},
 
		error: function(errorObject ){		
			if (errorObject.responseJSON.errorType == "ValidationError") {
	 			$('#success').html("");
	 			$('#errors').html("");
	 			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
	  			    $("#result").append( '<p>');
	  	
	  			    var errorList = errorObject.responseJSON.errors;
	 	 	        $.each(errorList,  function(i,error) {			   
	 		    		$("#errors").append( error.message + '<br>');
			    	});
	 	 	        $("#errors").append( '</p>');
	 	 	        $('#result').show();
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
 		}
	});
   
}
 /*
  * retrieve contact Record
  */  	 

   
function retrieveContactRecord(){
		id=$('#contactRecordList option:selected').val();
	   	 $.ajax({
			type: 'GET',
			url: contextRoot + '/contactRecords/record/'+id,
			dataType: "json",           // Accept header
			success: function(data){
				$('#id').val(data.id);
				$('#name').val(data.name);
				$('#company').val(data.company);
				$('#email').val(data.email);
				$('#website').val(data.website);
				$('#birthDate').val(data.birthDate);				
				//$('#smallImageUrl').val(data.smallImageUrl);
				//$('#largImageUrl').val(data.largImageUrl);
				$('#longitude').val(data.longitude);
				$('#latitude').val(data.latitude);
				$('#work').val(data.phone.work);
				$('#home').val(data.phone.home);
				$('#mobile').val(data.phone.mobile);
				$('#street').val(data.address.street);
				$('#city').val(data.address.city);
				$('#state').val(data.address.state);
				$('#country').val(data.address.country);
				$('#zip').val(data.address.zip);
				
				if(data.favourite==1 || data.favourite==true){
					$("#rad1").prop("checked", true)
				}
				else{
					$("#rad2").prop("checked", true)
				}
				
			},
	 
			error: function(errorObject ){		
				alert("Erro!")
				
	 		}
		});
	}
 
/*
 * reset the form
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
 * Collect form data and then put it in JSON format
 */
function getFavourite(){
	//
}
function getFormData(){
	var id=$('#id').val();  
	var name=$('#name').val();
	var favourite=$("input:radio[name=favourite]:checked").val();
    var company=$('#company').val();
    var email=$('#email').val();
    var website=$('#website').val();
    var birthDate=$('#birthDate').val();
    var smallImageUrl=$('#smallImageUrl').val();
    var largImageUrl=$('#largImageUrl').val();
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
        "longitude":longitude,
        "latitude":latitude
    }
    var contactDetail={
        "id":id,
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
 * A function to set longitude and latitude form navigator object
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

