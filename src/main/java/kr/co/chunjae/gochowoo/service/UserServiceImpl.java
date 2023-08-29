package kr.co.chunjae.gochowoo.service;

import kr.co.chunjae.gochowoo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.chunjae.gochowoo.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    public User userInfo(String email) {
        return userRepository.findByEmail(email);
    }

    public User withdrawUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
             userRepository.delete(user);
        }
        return null;
    }

}