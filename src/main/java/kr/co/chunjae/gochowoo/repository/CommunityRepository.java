package kr.co.chunjae.gochowoo.repository;

import kr.co.chunjae.gochowoo.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
    List<Community> findAllByOrderByCreatedTimeDesc();
}