package com.JoyTrav.security;

import com.JoyTrav.model.Account;
import com.JoyTrav.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         Account account =  accountRepository.fetchAccountByEmail(email);

         if(account != null) {
             return new UserInfoDetails(account);
         }else {
             throw new UsernameNotFoundException("User not found by" + email);
         }
    }

}
