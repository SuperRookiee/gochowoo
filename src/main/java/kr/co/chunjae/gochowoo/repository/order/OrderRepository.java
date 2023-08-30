package kr.co.chunjae.gochowoo.repository.order;

import kr.co.chunjae.gochowoo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}