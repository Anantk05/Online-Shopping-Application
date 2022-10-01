package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.CustomerException;
import com.app.login.CurrentUserSession;
import com.app.login.LoginException;
import com.app.model.Customer;
import com.app.repository.AddressDao;
import com.app.repository.CurrentUserSessionDao;
import com.app.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CurrentUserSessionService currentUserSessionService;
	
	@Autowired
	CurrentUserSessionDao currentUserSessionDao;
	
	@Autowired
	AddressDao addressDao ;
	
	@Override
	public Customer addCustomer(Customer cust) throws CustomerException {
		System.out.println("================================================");
		Optional<Customer> opt = customerDao.findByMobileNumber(cust.getMobileNumber()) ;
		
		if(opt.isPresent()) {
			throw new CustomerException("Customer already Exist With this Mobile Number");
		}
		
		return customerDao.save(cust) ;
	}

	@Override
	public Customer updateCustomer(Customer cust, String key) throws CustomerException, LoginException {
		
		Customer customerDetails = currentUserSessionService.getCustomerDetails(key) ;
		
		if(customerDetails == null) {
			throw new LoginException("No user Found | Login first");
		}
		
		if(cust.getCustomerId() == customerDetails.getCustomerId()) {
			customerDao.save(cust) ;
			return cust;
		}
		else {
			throw new CustomerException("Can't change UserID!") ;
		}
		
	}

	@Override
	public Customer removeCustomer(Customer cust, String key) throws CustomerException, LoginException {
		
//		Optional<Customer> opt = customerDao.findById(cust.getCustomerId());
//		
//		if(opt.isEmpty()) {
//			throw new CustomerException("Customer is not registered");
//		}
		
		Customer currentCustomer = currentUserSessionService.getCustomerDetails(key);
		
		if(currentCustomer != null) {
			
			if(cust.getCustomerId() == currentCustomer.getCustomerId()) {
				
				customerDao.delete(cust);
				
				Optional<CurrentUserSession> opt = currentUserSessionDao.findByUuid(key) ;
				
				CurrentUserSession currentSession = opt.get();
				
				currentUserSessionDao.delete(currentSession);
				return cust;
				
				
			}
			else {
				throw new CustomerException("Invalid Customer ID") ;
			}
			
		}
		else {
			throw new CustomerException("Invalid UUID key");
		}
		
		
		
		
	}

	@Override
	public Customer viewCustomer(Customer cust) throws CustomerException {
		
		Optional<Customer> opt = customerDao.findById(cust.getCustomerId());
		
		if(opt.isEmpty()) {
			throw new CustomerException("Customer is not presentt with this ID") ;
		}
		
		return opt.get();
		
	}

	@Override
	public List<Customer> viewAllCustomer(String location) throws CustomerException {
		
		//addDao : Query(select a.customer_id from Address where a.city = ?1)
		//		   public List<Integer> getCustomerIdFromLocation(String location) ;
		
		//List<Integer> customerIdList = addressDao.getCustomerIdFromLocation(String location) ;
		
//		List<Customer> list = new ArrayList<>();
//		
//		for(Integer cId : customerIdList) {
//			list.add(customerDao.findById(cId).get());
//		}
//		
//		
//
//		return list;
		return null;
	}

}

















