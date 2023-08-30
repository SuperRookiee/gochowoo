package kr.co.chunjae.gochowoo.service;

import kr.co.chunjae.gochowoo.model.Team;
import kr.co.chunjae.gochowoo.model.User;
import kr.co.chunjae.gochowoo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public User getCash(String email) {
        return userRepository.findCashByEmail(email);
    }

    public User withdrawUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
             userRepository.delete(user);
        }
        return null;
    }

    @Override
    public void updateCashByEmail(String email, int cash) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.updateCash(cash);
            userRepository.save(user);
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


}