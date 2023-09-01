package kr.co.chunjae.gochowoo.model.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.chunjae.gochowoo.model.Order.OrderHistory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OrderHistoryConverter implements AttributeConverter<OrderHistory, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(OrderHistory orderHistory) {
        try {
            return objectMapper.writeValueAsString(orderHistory);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public OrderHistory convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, OrderHistory.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
