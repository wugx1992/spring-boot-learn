package indi.gxwu.jdbc.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * @Author: gx.wu
 * @Date: 2020/3/24 11:28
 * @Description: 逻辑表
 */
@Data
@Entity
@Table(name = "t_order")
public class TbOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    private long userId;
    private String name;
}
