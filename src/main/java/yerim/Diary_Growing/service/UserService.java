package yerim.Diary_Growing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yerim.Diary_Growing.domain.user.User;
import yerim.Diary_Growing.repository.UserRepository;
import yerim.Diary_Growing.repository.UserResponseDto;
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
     * @param userDto
     * @return
     */
    public String Join(UserSaveRequestDto userDto){
        // 같은 유저 id 중복 허용 x
        validateDuplicateUser(userDto);
        return userRepository.save(userDto.toEntity()).getuId();
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
    public UserResponseDto login(String uId, String passwd){
        Optional<User> loginUser = userRepository.findByuIdAndPasswd(uId, passwd);
        User user1;
        if(loginUser.isEmpty()){
            throw new IllegalStateException("회원 정보가 일치하지 않습니다.");
        }else {
            user1 = loginUser.get();
        }
        return new UserResponseDto(user1.getId(), user1.getuId(), user1.getName(), user1.getBirthday());
    }
}
