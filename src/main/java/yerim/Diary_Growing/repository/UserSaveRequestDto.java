package yerim.Diary_Growing.repository;

import yerim.Diary_Growing.domain.user.User;

import java.time.LocalDate;

public class UserSaveRequestDto {
    private String uId;
    private String passwd;
    private String name;
    private LocalDate birthday;

    public UserSaveRequestDto(){}

    //빌더로 변경
    public UserSaveRequestDto(String uId, String passwd, String name, LocalDate birthday) {
        this.uId = uId;
        this.passwd = passwd;
        this.name = name;
        this.birthday = birthday;
    }

    public String getuId() {
        return uId;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    //이후 빌더로
    public User toEntity(){
        User newUser = new User(uId, passwd, name, birthday);
        return  newUser;
    }
}
