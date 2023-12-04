package com.JoyTrav.service;

import com.JoyTrav.dto.SignUpForm;
import com.JoyTrav.model.Account;

import java.util.Optional;

public interface AccountService extends IGenericService <Account, Integer>{
    Optional<Account>  findAccountByEmail(String email);
    Account fetchAccountByEmail(String email);
    Account registerNewUserAccount(SignUpForm signupFormInfo);
}
