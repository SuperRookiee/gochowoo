package kr.co.chunjae.gochowoo.service;

import kr.co.chunjae.gochowoo.model.UserAddress;

import java.util.List;

public interface UserAddressService {
    UserAddress addUserAddress(UserAddress address);

    List<UserAddress> getMyAllUserAddress(Long id);
}
