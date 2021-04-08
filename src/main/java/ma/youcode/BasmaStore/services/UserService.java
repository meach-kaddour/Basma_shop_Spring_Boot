package ma.youcode.BasmaStore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.youcode.BasmaStore.model.UserEntity;
import ma.youcode.BasmaStore.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	
	
	public List<UserEntity> getAllUsers() {
        List<UserEntity> users = new ArrayList<>();
        userRepository.findAll();
        return users;
    }
	
	
	public UserEntity getUserById(Long id) {
        return userRepository.getOne(id);
    }
 
    public void saveOrUpdate(UserEntity user) {
    	userRepository.save(user);
    }
 
    public void delete(Long id) {
    	userRepository.deleteById(id);
    }
	
	
}
