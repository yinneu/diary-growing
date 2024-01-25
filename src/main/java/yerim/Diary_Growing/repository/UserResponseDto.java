package yerim.Diary_Growing.repository;

import java.time.LocalDate;

public class UserResponseDto {
    private long id;
    private String uId;
    private String name;
    private LocalDate birthday;

    public UserResponseDto(long id, String uId, String name, LocalDate birthday) {
        this.id = id;
        this.uId = uId;
        this.name = name;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public String getuId() {
        return uId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
