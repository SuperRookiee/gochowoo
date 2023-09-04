package kr.co.chunjae.gochowoo.service.Community;


import kr.co.chunjae.gochowoo.model.Community.Community;
import kr.co.chunjae.gochowoo.model.User.User;
import kr.co.chunjae.gochowoo.repository.Community.CommunityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {
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

    @Override
    public Community getCommunityById(Long id) {
        return communityRepository.findById(id).orElse(null);
    }
    @Override
    public void saveCommunity(Community community) {
        communityRepository.save(community);
    }

    @Override
    public List<Community> getAllBoardByUserId(Long userId) {
        return communityRepository.findAllByWriter(User.builder().id(userId).build());
    }

    @Override
    public void deleteCommunityById(Long boardId) {
        communityRepository.deleteById(boardId);
    }
}
