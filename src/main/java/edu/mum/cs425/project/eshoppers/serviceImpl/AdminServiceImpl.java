package edu.mum.cs425.project.eshoppers.serviceImpl;

import java.util.List;
import java.util.Optional;

import edu.mum.cs425.project.eshoppers.repository.AdminRepository;
import edu.mum.cs425.project.eshoppers.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs425.project.eshoppers.domain.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {


    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<Admin> findAll() {
        // TODO Auto-generated method stub
        return (List<Admin>) adminRepository.findAll();
    }

    @Override
    public Admin save(Admin admin) {
        return null;
    }

    @Override
    public Admin findOne(Long id) {
        return null;
    }


    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        adminRepository.deleteById(id);
    }

}
