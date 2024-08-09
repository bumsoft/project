package com.erica.project.springSecurity;

import com.erica.project.User.domain.User;
import com.erica.project.User.domain.UserRole;
import com.erica.project.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> _user = userRepository.findByusername(username);
        if(_user.isEmpty())
        {
            throw new UsernameNotFoundException("존재하지않는아이디입니다.");
        }
        User user = _user.get();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if(user.getRole().equals(UserRole.ADMIN))
        {
            grantedAuthorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        }
        else if(user.getRole().equals(UserRole.EMPLOYEE))
        {
            grantedAuthorities.add(new SimpleGrantedAuthority(UserRole.EMPLOYEE.getValue()));
        }
        else if(user.getRole().equals(UserRole.EMPLOYER))
        {
            grantedAuthorities.add(new SimpleGrantedAuthority(UserRole.EMPLOYER.getValue()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
