package kr.co.chunjae.gochowoo.service.Community;

import kr.co.chunjae.gochowoo.model.Community.Community;

import java.util.List;

public interface CommunityService {

    List<Community> getAllBoard();
    Community write (Community write);
    Community getCommunityById(Long id);
    void saveCommunity(Community community);
    List<Community> getAllBoardByUserId(Long userId);

    void deleteCommunityById(Long board_id);
}
