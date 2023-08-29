package kr.co.chunjae.gochowoo.service;


import kr.co.chunjae.gochowoo.model.Community;
import kr.co.chunjae.gochowoo.repository.CommunityRepository;
import kr.co.chunjae.gochowoo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService{
    private final CommunityRepository communityRepository;

    public CommunityServiceImpl(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }
    @Override
    public List<Community> getAllBoard() {
        List<Community> test = communityRepository.findAll();
        for (Community com: test) {
            System.out.println(com.getTitle());
        }
        return communityRepository.findAll();
    }
}
