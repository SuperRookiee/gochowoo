package kr.co.chunjae.gochowoo.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kr.co.chunjae.gochowoo.model.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Type;
import java.util.List;

@Entity
@Subselect("SELECT * FROM v_purchase")
@Immutable
@Data
public class Purchase extends BaseEntity {
    @Id
    private Long orderId;
    private String coupon;
    private String orderHistory;
    private Integer status;
    private Long totalPrice;
    private Long addressId;
    private String address;
    private String deliveryRequest;
    private String phoneNumber;
    private Long userId;
    private String recipient;

    public List<OrderHistory> getOrderHistoryAsList() {
        Gson gson = new Gson();
        Type orderHistoryListType = new TypeToken<List<OrderHistory>>() {}.getType();
        return gson.fromJson(orderHistory, orderHistoryListType);
    }
}
