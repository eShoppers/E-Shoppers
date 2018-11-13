package edu.mum.cs425.project.eshoppers.serviceImpl;

import java.util.List;
import java.util.Optional;

import edu.mum.cs425.project.eshoppers.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.mum.cs425.project.eshoppers.repository.CustomerRepository;
import edu.mum.cs425.project.eshoppers.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}



	@Override
	public Customer findOne(Long id) {
		// TODO Auto-generated method stub
		Optional<Customer> a= customerRepository.findById(id);
		return a.orElse(null);
	}
}
