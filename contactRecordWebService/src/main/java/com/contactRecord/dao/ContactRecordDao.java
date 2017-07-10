package com.contactRecord.dao;

import java.util.List;

import com.contactRecord.model.ContactDetail;

public interface ContactRecordDao {
	boolean createContactRecord(ContactDetail contactDetail);
	ContactDetail retrieveContactRecord(int contactId);
	boolean updateContactRecord(ContactDetail contactDetail);
	boolean deleteContactRecord(int contactDetail);
	List<ContactDetail>getAllContactRecord();
}
