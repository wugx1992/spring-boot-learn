package indi.gxwu.jdbc.dao;

import indi.gxwu.jdbc.entity.TbOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @Author: gx.wu
 * @Date: 2020/3/24 11:46
 * @Description: code something to describe this module what it is
 */
public interface TbOrderItemDao extends JpaRepository<TbOrderItem, Long> {
    /**
     * 测试绑定表
     */
    @Query(value = "select n from TbOrder t inner join TbOrderItem n on t.orderId = n.orderId where n.orderId=:orderId")
    Optional<TbOrderItem> getOrderItemByOrderId(@Param("orderId") Long orderId);
}
