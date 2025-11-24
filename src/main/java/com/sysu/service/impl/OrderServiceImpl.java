package com.sysu.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sysu.entity.Address;
import com.sysu.entity.Order;
import com.sysu.service.AddressService;
import com.sysu.service.OrderService;
import com.sysu.mapper.OrderMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private AddressService addressService;

    public Page<Order> getOrderPage(String searchQuery, Integer pageNum, Integer pageSize) {
        Page<Order> page = new Page<>(pageNum, pageSize);
        page = orderMapper.getOrderPage(page, searchQuery);
        log.info("page:{}", page.toString());

        // 遍历检查地址信息
        for (Order order : page.getRecords()) {
            // 检查Mapper查询的地址是否为空
            // 如果Mapper查询的地址为空，再尝试通过ID查询
            if (order.getSenderAddress() == null ||
                    (order.getSenderAddress().getProvince() == null && order.getDeliveryAddrID() != null)) {

                // 发货地址
                Address sender = addressService.getAddressById(order.getDeliveryAddrID());
                if (sender == null) {
                    sender = createEmptyAddress();
                }
                order.setSenderAddress(sender);
                log.info("补充发货地址 sender:{}", sender);
            }

            if (order.getShippingAddress() == null ||
                    (order.getShippingAddress().getProvince() == null && order.getShippingAddrID() != null)) {

                // 收货地址
                Address shipping = addressService.getAddressById(order.getShippingAddrID());
                if (shipping == null) {
                    shipping = createEmptyAddress();
                }
                order.setShippingAddress(shipping);
                log.info("补充收货地址 shipping:{}", shipping);
            }

            // 如果两个地址都还是空的，设置默认空地址
            if (order.getSenderAddress() == null) {
                order.setSenderAddress(createEmptyAddress());
            }
            if (order.getShippingAddress() == null) {
                order.setShippingAddress(createEmptyAddress());
            }

            // shippingTime 兜底
            if (order.getShippingTime() == null) {
                order.setShippingTime(order.getOrderTime() != null ? order.getOrderTime() : new Date());
            }

            // price 兜底
            if (order.getPrice() == null) {
                order.setPrice(BigDecimal.ZERO);
            }
        }

        return page;
    }

    /**
     * 创建空地址对象
     */
    private Address createEmptyAddress() {
        Address address = new Address();
        address.setProvince("");
        address.setCity("");
        address.setDistricts("");
        address.setAddress("");
        return address;
    }
}