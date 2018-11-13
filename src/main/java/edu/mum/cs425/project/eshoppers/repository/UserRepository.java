package edu.mum.cs425.project.eshoppers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs425.project.eshoppers.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
