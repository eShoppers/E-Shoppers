package edu.mum.cs425.project.eshoppers.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.cs425.project.eshoppers.domain.User;



public interface UserService {

	public List<User> findAll();
	public User save(User user);
	public User findOne(Long id);
	public void delete(Long id);

}
