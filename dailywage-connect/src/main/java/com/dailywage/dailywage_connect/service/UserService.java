package com.dailywage.dailywage_connect.service;

import com.dailywage.dailywage_connect.model.UserModel;
import com.dailywage.dailywage_connect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
@Autowired
    UserRepository ur;
    public UserModel addUser(UserModel uM)
    {
       return ur.save(uM);
    }
    public List<UserModel> getAllUser()
    {
        return ur.findAll();
    }
    public String deleteUser(Long id)
    {
        ur.deleteById(id);
        return "deleted";
    }
    public UserModel updateUser(UserModel newValue,Long id)
    {
        UserModel olddata=ur.findById(id).orElse(null);
        olddata.setUserCity(newValue.getUserCity());
        olddata.setUserEmail(newValue.getUserEmail());
        olddata.setUserName(newValue.getUserName());
        olddata.setUserPhoneno(newValue.getUserPhoneno());
        olddata.setUserPassword(newValue.getUserPassword());
        olddata.setUserRole(newValue.getUserRole());
        return ur.save(olddata);

    }
    public List<UserModel> searchBycity(String city)
    {
        return ur.findBycity(city);
    }
    public List<UserModel> searchByrole(String role)
    {
        return ur.findByrole(role);
    }
}
