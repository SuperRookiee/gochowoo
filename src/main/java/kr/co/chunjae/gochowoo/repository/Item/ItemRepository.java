package kr.co.chunjae.gochowoo.repository.Item;

import kr.co.chunjae.gochowoo.model.Item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findTop8ByOrderByIdDesc();
}
