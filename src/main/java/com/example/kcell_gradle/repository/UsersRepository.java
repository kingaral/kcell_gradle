package com.example.kcell_gradle.repository;
/*
 * @author Токмурзин Мукагали
 * @version 1.0
 * @email mukagali.2002.05@gmail.com
 */
import com.example.kcell_gradle.models.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
* Here, I create Users, they will used for authorization
* */
@Repository
public class UsersRepository {

    private List<Users> users;

    public UsersRepository() {
        this.users = List.of(
                new Users("a", "1"),
                new Users("b", "2"));
    }

    public Users getByLogin(String login) {
        return this.users.stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst()
                .orElse(null);
    }

    public List<Users> getAll() {
        return this.users;
    }


}
