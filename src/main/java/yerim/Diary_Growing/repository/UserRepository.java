package yerim.Diary_Growing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yerim.Diary_Growing.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByuId(String uId);
    Optional<User> findByuIdAndPasswd(String uId, String passwd);
    
}
