package indi.gxwu.jdbc.controller;
import indi.gxwu.jdbc.dao.TbOrderItemDao;
import indi.gxwu.jdbc.entity.TbOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @Author: gx.wu
 * @Date: 2020/3/24 12:28
 * @Description: code something to describe this module what it is
 */

@RestController
public class OrderItemController {
    @Autowired
    private TbOrderItemDao orderItemDao;

    @RequestMapping(value = "/orderItem")
    public Optional<TbOrderItem> getOrderItemById(@RequestParam(name = "id") Long id) {
        return this.orderItemDao.findById(id);
    }

    @RequestMapping(value = "/orderItem/save")
    public TbOrderItem saveOrderItem(@RequestParam("item") String item, @RequestParam("userid") Long userId, @RequestParam("orderid") Long orderId) {
        TbOrderItem orderItem = new TbOrderItem();
        orderItem.setUserId(userId);
        orderItem.setItem(item);
        orderItem.setOrderId(orderId);
        return this.orderItemDao.save(orderItem);
    }

    @RequestMapping(value = "/orderItem/query")
    public Optional<TbOrderItem> getOrderItemByOrderId(@RequestParam(name = "orderid") Long orderId) {
        return this.orderItemDao.getOrderItemByOrderId(orderId);
    }
}
