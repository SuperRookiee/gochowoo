package kr.co.chunjae.gochowoo.repository.Order;

import kr.co.chunjae.gochowoo.model.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
