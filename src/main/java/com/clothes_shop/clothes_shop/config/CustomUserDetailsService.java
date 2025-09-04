package com.clothes_shop.clothes_shop.config;

import com.clothes_shop.clothes_shop.domain.User;
import com.clothes_shop.clothes_shop.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = this.userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("username not found");
        }
        return new CustomUserDetails(user);
    }
}
