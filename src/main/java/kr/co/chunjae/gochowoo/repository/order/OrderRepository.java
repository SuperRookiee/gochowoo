package kr.co.chunjae.gochowoo.repository.order;

import kr.co.chunjae.gochowoo.dto.PurchaseDTO;
import kr.co.chunjae.gochowoo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Item, Long> {

    @Query("SELECT new kr.co.chunjae.gochowoo.dto.PurchaseDTO(o.id, o.orderHistory, ua.user.id, o.userAddress.id, o.status, o.totalPrice, o.coupon) " +
            "FROM Order o JOIN o.userAddress ua WHERE ua.user.id = :userId")
    List<PurchaseDTO> findAllByUserId(Long userId); // 메서드의 매개변수 이름을 userId로 변경
}
