package com.example.demo.Users;

import com.example.demo.partners.entity.Partner;
import com.example.demo.partners.service.dto.RegisterInput;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserServiceRepository userServiceRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UsersEntity> optionalUsersEntity = userServiceRepository.findById(username);
        if(optionalUsersEntity.isEmpty()) {
            throw new UsernameNotFoundException("user info not found");
        }

        UsersEntity usersEntity = optionalUsersEntity.get();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        if (usersEntity.isAdminYn()) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }


        return new User(usersEntity.getUserName(), usersEntity.getPassword(), grantedAuthorities);
    }

    @Override
    public boolean register(UserInput parameter) {
        Optional<UsersEntity> optionalMember = userServiceRepository.findById(parameter.getUserName());
        if(optionalMember.isPresent()){
            return false;
        }

        String encPassword = BCrypt.hashpw(parameter.getPassword(), BCrypt.gensalt());

        userServiceRepository.save(UsersEntity.builder()
                .userName(parameter.getUserName())
                .password(encPassword)
                .type(parameter.getType())
                .adminYn(parameter.isAdminYn())
                .build());

        return true;
    }
}
