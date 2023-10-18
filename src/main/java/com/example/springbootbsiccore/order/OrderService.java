package com.example.springbootbsiccore.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
