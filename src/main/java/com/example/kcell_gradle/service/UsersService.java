package com.example.kcell_gradle.service;
/*
 * @author Токмурзин Мукагали
 * @version 1.0
 * @email mukagali.2002.05@gmail.com
 */
import com.example.kcell_gradle.models.Users;
import com.example.kcell_gradle.repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/*
* This is User server, I used him for searching authorized users and etc.
* */
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class UsersService implements UserDetailsService {

    private UsersRepository repository;

    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public List<Users> getAll() {
        return this.repository.getAll();
    }

    public Users getByLogin(String login) {
        return this.repository.getByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Users u = getByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(u.getLogin(), u.getPassword(), true, true, true, true, new HashSet<>());
    }
}
