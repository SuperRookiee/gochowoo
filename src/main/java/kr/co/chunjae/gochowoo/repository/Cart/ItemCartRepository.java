package kr.co.chunjae.gochowoo.repository.Cart;

import kr.co.chunjae.gochowoo.model.Item.ItemCart;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemCartRepository extends JpaRepository<ItemCart, Long> {
    List<ItemCart> findAllByUserId(Long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update ItemCart c set c.amount = :amount where c.id = :id")
    void updateAmountById(@Param(value = "id") Long id, @Param(value = "amount")int amount);

    Optional<ItemCart> findByItemIdAndUserId(Long item_id, Long user_id);

    @Modifying(clearAutomatically = true)
    @Transactional
    void deleteAllByUserId(Long id);
}
