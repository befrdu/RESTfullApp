package com.contactRecord.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.contactRecord.model.ContactDetail;
import com.contactRecord.service.ContactRecordService;


@Controller
@RequestMapping(value="/contactRecords")
public class ContactRecordController {
@Autowired
private ContactRecordService contactRecordService;
@Autowired
MessageSourceAccessor messageAccessor;
/*
 * To store the REST response
 * But this is not thread safe
 */
private Map<String, Object>reply=new HashMap<String, Object>();


/*
 * @Valid check validation errors. And exception is handled by user defined ExceptionController exception handler
 */
@RequestMapping(value="/create", method=RequestMethod.POST)
public @ResponseBody Map<String, Object> saveContactRecord(@Valid @RequestBody ContactDetail contactDetail) {
	boolean result=contactRecordService.createContactRecord(contactDetail);
	if(result==true){
		reply.put("status", "200");
		reply.put("message", "You successfully created a new contact record!");
	}
   return reply;
}

@RequestMapping(value="/record/{recordId}", method=RequestMethod.GET)
public @ResponseBody ContactDetail retrieveContactRecord(@PathVariable("recordId") int contactId) {
	
	return contactRecordService.retrieveContactRecord(contactId);
	
}

@RequestMapping(value="/update", method=RequestMethod.PUT)
public @ResponseBody Map<String, Object> updateContactRecord( @RequestBody ContactDetail contactDetail) {
	boolean result=contactRecordService.updateContactRecord(contactDetail);
	if(result==true){
		reply.put("status", "200");
		reply.put("message", "You successfully updated contact record!");
	}
	return reply;

}


@RequestMapping(value="/delete/{recordId}",method=RequestMethod.DELETE)
public @ResponseBody Map<String, Object> deleteContactRecord(@PathVariable("recordId") int contactId) {

	boolean result=contactRecordService.deleteContactRecord(contactId);
	if(result==true){
		reply.put("status", "200");
		reply.put("message", "You successfully deleted contact record!");
	}
	return reply;

}

@RequestMapping(value="/contactList",method=RequestMethod.GET)
public @ResponseBody List<ContactDetail> getAllContactRecord() {
	
	return contactRecordService.getAllContactDetail();

}


}