package edu.mum.cs425.project.eshoppers.service;

import edu.mum.cs425.project.eshoppers.domain.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public interface AdminService {
    public List<Admin> findAll();
    public Admin save(Admin admin);
    public Admin findOne(Long id);
    public void delete(Long id);
}
