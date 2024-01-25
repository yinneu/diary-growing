package yerim.Diary_Growing.repository;

public class UserLoginDto {
    private String uId;
    private String passwd;

    public UserLoginDto() {
    }

    public UserLoginDto(String uId, String passwd) {
        this.uId = uId;
        this.passwd = passwd;
    }

    public String getuId() {
        return uId;
    }

    public String getPasswd() {
        return passwd;
    }
}
