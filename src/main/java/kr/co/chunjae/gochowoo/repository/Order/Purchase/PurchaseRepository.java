package kr.co.chunjae.gochowoo.repository.Order.Purchase;

import kr.co.chunjae.gochowoo.model.Order.Purchase.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findAllByUserIdOrderByCreatedTimeDesc(Long userId);
    List<Purchase> findAllByOrderByCreatedTimeDesc();

    Purchase findAllByOrderId(Long orderId);
}
