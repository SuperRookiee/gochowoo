package kr.co.chunjae.gochowoo.repository.Order;

import kr.co.chunjae.gochowoo.model.Order.Order;
import kr.co.chunjae.gochowoo.model.utils.ShippingStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Order o SET o.status = :status WHERE o.id IN :ids")
    int updateAllById(@Param("status") ShippingStatus status, @Param("ids") List<Long> ids);

}
