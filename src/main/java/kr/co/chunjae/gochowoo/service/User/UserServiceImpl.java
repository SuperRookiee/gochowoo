package kr.co.chunjae.gochowoo.service.User;

import kr.co.chunjae.gochowoo.model.User.User;
import kr.co.chunjae.gochowoo.model.utils.Team;
import kr.co.chunjae.gochowoo.repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User joinUser(User user) {
        return userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password) && (user.getDeleted() == null || user.getDeleted().equals('N'))) {
            return user;
        }
        return null;
    }

    public User userInfo(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getCash(String email) {
        return userRepository.findCashByEmail(email);
    }

    public boolean withdrawUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            userRepository.deleteUserById(user.getId());
            return true;
        }
        return false;
    }

    @Override
    public void updateCashByEmail(String email, int cash) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.updateCash(cash);
            userRepository.updateUserNameById(user.getCash(), user.getId());
        }
    }

    @Override
    public void changeTeam(String email, String teamName) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setTeam(Team.getTeam(teamName));
            userRepository.save(user);
        }
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean isUniqueEmail(String email) {
        return userRepository.findByEmail(email) == null;
    }

    @Override
    public boolean isUniqueNickName(String nickName) {
        return userRepository.findByNickName(nickName) == null;
    }

    public void createCookie(String username, HttpServletResponse response) {
        Cookie cookie = new Cookie("user", username);
        cookie.setMaxAge(30 * 24 * 60 * 60); // 쿠키 유효 기간 (30일)
        response.addCookie(cookie);
    }
    public void removeCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("user", "");
        cookie.setMaxAge(0); // 쿠키를 즉시 만료시킴
        response.addCookie(cookie);
    }

}