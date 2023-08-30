package kr.co.chunjae.gochowoo.service;


import kr.co.chunjae.gochowoo.model.Community;
import kr.co.chunjae.gochowoo.repository.CommunityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService{
    private final CommunityRepository communityRepository;

    public CommunityServiceImpl(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }
    @Override
    @Transactional
    public Community write(Community post) {
        return communityRepository.save(post);
    }

    @Override
    public List<Community> getAllBoard() {
        return communityRepository.findAllByOrderByCreatedTimeDesc();
    }
}
