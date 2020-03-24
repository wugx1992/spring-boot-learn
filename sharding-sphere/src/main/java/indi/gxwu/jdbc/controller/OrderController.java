package indi.gxwu.jdbc.controller;

import indi.gxwu.jdbc.dao.TbOrderDao;
import indi.gxwu.jdbc.entity.TbOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;


/**
 * @Author: gx.wu
 * @Date: 2020/3/24 12:10
 * @Description: code something to describe this module what it is
 */
@RestController
public class OrderController {
    @Autowired
    private TbOrderDao orderDao;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Optional<TbOrder> getOrderById(@RequestParam("id") Long id) {
        return orderDao.findById(id);
    }

    @RequestMapping(value = "/order/save")
    public TbOrder saveOrder(@RequestParam("name") String name, @RequestParam("userid") Long userId) {
        TbOrder order = new TbOrder();
        order.setName(name);
        order.setUserId(userId);
        return this.orderDao.save(order);
    }
}