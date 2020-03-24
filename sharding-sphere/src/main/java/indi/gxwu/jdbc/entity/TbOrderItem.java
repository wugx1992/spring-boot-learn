package indi.gxwu.jdbc.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: gx.wu
 * @Date: 2020/3/24 11:29
 * @Description: 绑定表
 */
@Data
@Entity
@Table(name = "t_order_item")
public class TbOrderItem {
    @Id
    @Column(name = "order_id")
    private long orderId;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "item")
    private String item;
}
