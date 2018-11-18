package edu.mum.cs425.project.eshoppers.serviceImpl;

import edu.mum.cs425.project.eshoppers.domain.User;
import edu.mum.cs425.project.eshoppers.repository.UserRepository;
import edu.mum.cs425.project.eshoppers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByEmailContainsAndPassword(String email, String password) {
        return userRepository.findByEmailContainsAndPassword(email,password);
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email,password);
    }




    @Override
    public List<User> findAll() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
