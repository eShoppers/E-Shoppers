package edu.mum.cs425.project.eshoppers.repository;

import edu.mum.cs425.project.eshoppers.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State,Long> {

}
