package kr.co.chunjae.gochowoo.repository;

import kr.co.chunjae.gochowoo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findTop8ByOrderByIdDesc();
}
