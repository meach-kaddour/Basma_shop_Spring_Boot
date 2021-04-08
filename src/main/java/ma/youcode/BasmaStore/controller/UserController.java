package ma.youcode.BasmaStore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ma.youcode.BasmaStore.model.UserEntity;
import ma.youcode.BasmaStore.repositories.UserRepository;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserRepository userRepository;

	// GET ALL USERS
	@GetMapping("/users")
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	// GET USER BY ID
	@GetMapping("/users/{id}")
	public Optional<UserEntity> getUserById(@PathVariable(value = "id") Long userId) {
		return userRepository.findById(userId);
		// .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}

	// CREATE USER
	@PostMapping("/users")
	public UserEntity createUser(@Validated @RequestBody UserEntity user) {
		return userRepository.save(user);
	}
	// Update user

	@PutMapping("/users/{id}")
	public UserEntity updateUser(@PathVariable(value = "id") Long userId,
			@Validated @RequestBody UserEntity userDetail) {

		UserEntity user = userRepository.getOne(userId);

		user.setFirstName(userDetail.getFirstName());
		user.setLastName(userDetail.getLastName());
		user.setEmail(userDetail.getEmail());
		user.setPassowrd(userDetail.getPassowrd());

		UserEntity userUpdated = userRepository.save(user);

		return userUpdated;
	}
	
	
	//Delete User 
	
	 @DeleteMapping("/users/{id}")
	    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long userId) {
	        UserEntity user = userRepository.getOne(userId);

	        userRepository.delete(user);

	        return ResponseEntity.ok().build();
	    }

}
