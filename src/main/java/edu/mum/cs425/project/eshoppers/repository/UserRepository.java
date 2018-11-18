package edu.mum.cs425.project.eshoppers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs425.project.eshoppers.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(@Param("email") String email);
  // Optional<User> findByEmailContainsAndPassword(@Param("email") String email,@Param("password") String password);
     //   Optional<User> findByPasswordEqualsAndEmailEquals(@Param("password") String password,@Param("email") String email);
       // Optional<User> findByPassword(@Param("password") String password);
         User findByEmailContainsAndPassword(String email,String password);
         User findUserByEmailAndPassword(String email,String password);
}
