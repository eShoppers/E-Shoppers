package edu.mum.cs425.project.eshoppers.serviceImpl;

import edu.mum.cs425.project.eshoppers.domain.State;
import edu.mum.cs425.project.eshoppers.repository.StateRepository;
import edu.mum.cs425.project.eshoppers.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {
     @Autowired
     StateRepository stateRepository;
    @Override
    public List<State> findAll() {
        return (List<State>) stateRepository.findAll();
    }
}
