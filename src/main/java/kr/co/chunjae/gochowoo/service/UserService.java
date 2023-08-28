package kr.co.chunjae.gochowoo.service;

import kr.co.chunjae.gochowoo.model.User;

public interface UserService {
    User joinUser(User user);
    User login(String email, String password);
    User userInfo(String email);
    User updateUser(User user);

}