package kr.co.chunjae.gochowoo.service.User;

import kr.co.chunjae.gochowoo.model.User.User;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    User joinUser(User user);
    User login(String email, String password);
    User userInfo(String email);
    void updateUser(User user);
    User getCash(String email);
    boolean withdrawUser(String email, String password);
    void updateCashByEmail(String email, int cash);
    void changeTeam(String email,String team);

    User getUserById(Long id);

    boolean isUniqueEmail(String nickName);
    boolean isUniqueNickName(String nickName);

    void createCookie(String username, HttpServletResponse response);
    void removeCookie(HttpServletResponse response);

}