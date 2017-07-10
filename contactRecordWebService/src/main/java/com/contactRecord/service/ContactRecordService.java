package com.contactRecord.service;

import java.util.List;

import com.contactRecord.model.ContactDetail;

public interface ContactRecordService {
	
boolean createContactRecord(ContactDetail contactDetail);
ContactDetail retrieveContactRecord(int contactId);
boolean updateContactRecord(ContactDetail contactDetail);
boolean deleteContactRecord(int contactId);
List<ContactDetail>getAllContactDetail();

}
