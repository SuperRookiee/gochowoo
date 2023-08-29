package kr.co.chunjae.gochowoo.repository;

import kr.co.chunjae.gochowoo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findCashByEmail(String email);
}
