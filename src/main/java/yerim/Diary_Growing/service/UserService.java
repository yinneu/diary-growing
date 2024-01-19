package yerim.Diary_Growing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yerim.Diary_Growing.domain.User;
import yerim.Diary_Growing.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 회원가입
     * @param user
     * @return
     */
    public String Join(User user){
        // 같은 유저 id 중복 허용 x
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getuId();
    }

    private void validateDuplicateUser(User user) {
        userRepository.findByuId(user.getuId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
                });
    }

    /**
     * 로그인
     */
    public Optional<User> login(String uid, String passwd){
        Optional<User> loginUser = userRepository.findByuIdAndPasswd(uid, passwd);
        return loginUser;
    }
}
