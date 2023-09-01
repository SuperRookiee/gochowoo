package kr.co.chunjae.gochowoo.service.User;

import kr.co.chunjae.gochowoo.model.User.UserAddress;

import java.util.List;

public interface UserAddressService {
    UserAddress addUserAddress(UserAddress address);

    List<UserAddress> getMyAllUserAddress(Long id);
}
