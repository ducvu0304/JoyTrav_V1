package com.JoyTrav.controllerAdvice;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class RegistrationAdvice {

//    @ExceptionHandler(BindException.class)
//    public ModelAndView handleBindException(BindException e) {
//        // Trả về message của lỗi đầu tiên
//        String errorMessage = "Request không hợp lệ";
//        if (e.getBindingResult().hasErrors())
//            e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
//        return new ModelAndView("auth/register-page");
//    }
}
