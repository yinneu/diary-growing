//package yerim.Diary_Growing.repository;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import yerim.Diary_Growing.domain.user.User;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class UserRepositoryTest {
//
//    @Autowired UserRepository userRepository;
//
//    @Test
//    void Save() {
//        //given
//        User user = new User();
////        user.setuId("user1");
////        user.setPasswd("ewf");
////        user.setName("name1");
//
//        //when
//        User save1 = userRepository.save(user);
//
//        //than
//        assertThat(user.getuId()).isEqualTo(save1.getuId());
//
//    }
//
//    @Test
//    void FindByuId() {
//        //given
//        User user = new User();
////        user.setuId("user1");
////        user.setPasswd("ewf");
////        user.setName("name1");
//
//        //when
//        User save1 = userRepository.save(user);
//        User byuId = userRepository.findByuId(user.getuId()).get();
//
//        //than
//        assertThat(user.getuId()).isEqualTo(byuId.getuId());
//    }
//
//    @Test
//    void FindByuIdAndPasswd() {
//        //given
////        User user = new User();
////        user.setuId("user1");
////        user.setPasswd("ewf");
////        user.setName("name1");
//
//        //when
//        User save1 = userRepository.save(user);
////        NullPointerException e = assertThrows(NullPointerException.class, () -> userRepository.findByuId("aefef"));
//        User byuId = userRepository.findByuIdAndPasswd(user.getuId(),user.getPasswd()).get();
//
//        //than
//        assertThat(byuId.getuId()).isEqualTo(user.getuId());
//        assertThat(byuId.getPasswd()).isEqualTo(user.getPasswd());
//    }
//}