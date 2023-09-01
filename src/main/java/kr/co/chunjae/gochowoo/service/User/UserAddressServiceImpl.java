package kr.co.chunjae.gochowoo.service.User;

import kr.co.chunjae.gochowoo.model.User.UserAddress;
import kr.co.chunjae.gochowoo.repository.User.UserAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserAddressServiceImpl implements UserAddressService{
    @Autowired
    UserAddressRepository userAddressRepository;

    @Override
    public UserAddress addUserAddress(UserAddress address) {
        return userAddressRepository.save(address);
    }

    @Override
    public List<UserAddress> getMyAllUserAddress(Long user_id) {
        return userAddressRepository.findAllByUserId(user_id);
    }
}
