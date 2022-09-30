package com.app.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.CustomerException;
import com.app.exceptions.UserException;
import com.app.login.CurrentUserSession;
import com.app.model.Customer;
import com.app.model.User;
import com.app.repository.CurrentUserSessionDao;
import com.app.repository.CustomerDao;


import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	CurrentUserSessionDao currentUserSessionDao;

	@Autowired
	CurrentUserSessionService currentUserSessionService;
	
	@Override
	public CurrentUserSession addUser(User user) throws UserException, CustomerException {
		Optional<Customer> opt = customerDao.findByMobileNumber(user.getUserId()) ;
		
		if(opt.isEmpty()) {
			throw new CustomerException("User not found with Mobile number : "+user.getUserId());
		}
		
		Customer currentCustomer = opt.get();
		
		Integer customerId = currentCustomer.getCustomerId();
		
		Optional<CurrentUserSession> currentUserOptional = currentUserSessionDao.findByCustomerId(customerId);
		
		if(currentUserOptional.isPresent()) {
			throw new UserException("User has already logged in with userId : " + user.getUserId());
		}
		
		if(currentCustomer.getMobileNumber().equals(user.getUserId()) && currentCustomer.getPassword().equals(user.getPassword())) {
			
			String key = RandomString.make(6) ;
			
			CurrentUserSession currentUserSession = new CurrentUserSession(customerId, key, LocalDateTime.now()) ;
			
			return  currentUserSessionDao.save(currentUserSession) ;
			
			
		}
		else {
			throw new UserException("Invalid UserId OR Password");
		}
	}

	@Override
	public User signOut(String key) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
