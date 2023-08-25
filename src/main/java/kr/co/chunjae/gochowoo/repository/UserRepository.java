package kr.co.chunjae.gochowoo.Repository;

import kr.co.chunjae.gochowoo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
