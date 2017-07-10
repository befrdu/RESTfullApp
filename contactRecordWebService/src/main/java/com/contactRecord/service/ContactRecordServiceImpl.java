package com.contactRecord.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactRecord.dao.ContactRecordDao;
import com.contactRecord.dao.ContactRecordDaoImpl;
import com.contactRecord.model.Address;
import com.contactRecord.model.ContactDetail;

@Service
public class ContactRecordServiceImpl implements ContactRecordService {
    
	@Autowired
	private ContactRecordDao contactRecordDao;
	
	@Override
	public boolean createContactRecord(ContactDetail contactDetail) {
		return contactRecordDao.createContactRecord(contactDetail);
	}

	@Override
	public ContactDetail retrieveContactRecord(int contactId) {
		
		return contactRecordDao.retrieveContactRecord(contactId);
	}

	@Override
	public boolean updateContactRecord(ContactDetail contactDetail) {
		return contactRecordDao.updateContactRecord(contactDetail);

	}

	@Override
	public boolean deleteContactRecord(int contactId) {
		return contactRecordDao.deleteContactRecord(contactId);

	}

	@Override
	public List<ContactDetail> getAllContactDetail() {
		
		return contactRecordDao.getAllContactRecord();
	}


}
