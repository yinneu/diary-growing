package yerim.Diary_Growing.domain;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "dg_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Nonnull
    @Column(unique = true, length = 10)
    private String uId;

    @Nonnull
    @Column
    private String passwd;

    @Nonnull
    @Column
    private String name;

    @Column
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Nonnull
    public String getuId() {
        return uId;
    }

    public void setuId(@Nonnull String uId) {
        this.uId = uId;
    }

    @Nonnull
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(@Nonnull String passwd) {
        this.passwd = passwd;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public void setName(@Nonnull String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
