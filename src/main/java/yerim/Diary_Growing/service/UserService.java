package yerim.Diary_Growing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yerim.Diary_Growing.domain.user.User;
import yerim.Diary_Growing.repository.UserRepository;
import yerim.Diary_Growing.repository.UserSaveRequestDto;

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
     * @param useDto
     * @return
     */
    public String Join(UserSaveRequestDto useDto){
        // 같은 유저 id 중복 허용 x
        validateDuplicateUser(useDto);
        return userRepository.save(useDto.toEntity()).getuId();
    }

    private void validateDuplicateUser(UserSaveRequestDto useDto) {
        userRepository.findByuId(useDto.getuId())
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
