package com.contactRecord.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contactRecord.model.ContactDetail;

@Repository
@Transactional
public class ContactRecordDaoImpl implements ContactRecordDao {
	@Autowired
	SessionFactory sessionFactory;
	Session session=null;
	
	public ContactRecordDaoImpl(){
		
	}
	@Override
	public boolean createContactRecord(ContactDetail contactDetail) {
		try{
			sessionFactory.getCurrentSession().save(contactDetail);
			return true;
		}
		catch(HibernateException e){
			System.out.println("Exception occur");
			e.printStackTrace();
			return false;
			
		}
	
		
	}
	@Override
	public ContactDetail retrieveContactRecord(int contactId) {
		
		return (ContactDetail)sessionFactory.getCurrentSession().createQuery("from ContactDetail c where c.id="+contactId).uniqueResult();
	}
	@Override
	public boolean updateContactRecord(ContactDetail contactDetail) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(contactDetail);
			return true;
		}
		catch(HibernateException e){
			System.out.println("Exception occur");
			e.printStackTrace();
			return false;
			
		}
	
		
	}
	@Override
	public boolean deleteContactRecord(int contactId) {
		try{
			/*
			 * load() instead of get() for one time db hit
			 */
			Object persistentInstance = sessionFactory.getCurrentSession().load(ContactDetail.class, contactId);
			if (persistentInstance != null) {
			    sessionFactory.getCurrentSession().delete(persistentInstance);
			}
			return true;
		}
		catch(HibernateException e){
			System.out.println("Exception occur");
			e.printStackTrace();
			return false;
			
		}
	
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ContactDetail> getAllContactRecord() {
		return sessionFactory.getCurrentSession().createQuery("from ContactDetail").list();
	}
	
	

}
