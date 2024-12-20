package com.t3h.e_commerce.controller.resources;

import com.t3h.e_commerce.dto.requests.OrderCreationRequest;
import com.t3h.e_commerce.dto.responses.OrderResponse;
import com.t3h.e_commerce.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderResourceController {
    private final IOrderService iOrderService;

    @PostMapping("/order")
    public ResponseEntity<OrderResponse> orderProduct(@RequestBody OrderCreationRequest request) {
        return ResponseEntity.ok(iOrderService.orderProduct(request));
    }
}