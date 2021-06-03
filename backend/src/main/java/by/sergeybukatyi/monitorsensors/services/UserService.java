package by.sergeybukatyi.monitorsensors.services;

import by.sergeybukatyi.monitorsensors.entities.Explorer;
import by.sergeybukatyi.monitorsensors.persistence.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    JpaUserRepository jpaUserRepository;


    @Autowired
    public UserService(JpaUserRepository jpaUserRepository){

        this.jpaUserRepository = jpaUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Explorer user = jpaUserRepository.findUser(s);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(user.getAuthority()));
        return new User(user.getUsername(), user.getPassword(), authorityList);
    }
}
