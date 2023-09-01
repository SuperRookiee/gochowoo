package kr.co.chunjae.gochowoo.repository.Community;

import kr.co.chunjae.gochowoo.model.Community.Community;
import kr.co.chunjae.gochowoo.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
    List<Community> findAllByOrderByCreatedTimeDesc();

    List<Community> findAllByWriter(User user);
}