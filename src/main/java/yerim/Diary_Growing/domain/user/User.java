package yerim.Diary_Growing.domain.user;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dg_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, length = 20, nullable = false)
    private String uId;

    @Column(length = 60, nullable = false)
    private String passwd;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthday;

    public User(){}

    //이후 빌더로
    public User(String uId, String passwd, String name, LocalDate birthday) {
        this.uId = uId;
        this.passwd = passwd;
        this.name = name;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
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
}
