package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getALL();
    }
    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }
    public Admin save(Admin admin){
        if (admin.getIdAdmin()==null){
            return adminRepository.save(admin);
        } else {
            Optional<Admin> opt = adminRepository.getAdmin(admin.getIdAdmin());
            if (opt.isEmpty()){
                return adminRepository.save(admin);
            }else {
                return admin;
            }
        }
    }
    public Admin update(Admin admin){
        if (admin.getIdAdmin()!= null){
            Optional<Admin> opt1 = adminRepository.getAdmin((admin.getIdAdmin()));
            if (opt1.isPresent()){
                if (admin.getName() != null){
                    opt1.get().setName(admin.getName());
                }
                if(admin.getEmail() != null){
                    opt1.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null){
                    opt1.get().setPassword(admin.getPassword());
                    adminRepository.save(opt1.get());
                    return opt1.get();
                }else {
                    return admin;
                }
            } else {
                return admin;
            }
        }
        return admin;
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Admin>admin = adminRepository.getAdmin(id);
        if (admin.isPresent()){
            adminRepository.delete(admin.get());
            flag=true;
        }
        return flag;
    }
}
