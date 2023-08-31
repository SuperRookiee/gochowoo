package kr.co.chunjae.gochowoo.service;

import kr.co.chunjae.gochowoo.model.User;

public interface UserService {
    User joinUser(User user);
    User login(String email, String password);
    User userInfo(String email);
    void updateUser(User user);
    User getCash(String email);
    User withdrawUser(String email, String password);
    void updateCashByEmail(String email, int cash);
    void changeTeam(String email,String team);

    User getUserById(Long id);

}