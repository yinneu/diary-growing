package yerim.Diary_Growing.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import yerim.Diary_Growing.domain.user.User;
import yerim.Diary_Growing.repository.UserRepository;
import yerim.Diary_Growing.repository.UserSaveRequestDto;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    void 회원가입() {
        //given
        String uId = "title";
        String passwd = "content";
        LocalDate date = LocalDate.parse("2001-12-25");
        UserSaveRequestDto requestDto = new UserSaveRequestDto(uId, passwd, "name", date);

        String url = "http://localhost:" + port + "/user/join";

        //when
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestDto, String.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println(responseEntity.getBody());

        List<User> all = userRepository.findAll();
        assertThat(all.get(0).getuId()).isEqualTo(uId);
        assertThat(all.get(0).getPasswd()).isEqualTo(passwd);
    }
}