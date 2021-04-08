package ma.youcode.BasmaStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import ma.youcode.BasmaStore.model.UserEntity;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long>{

	
}
