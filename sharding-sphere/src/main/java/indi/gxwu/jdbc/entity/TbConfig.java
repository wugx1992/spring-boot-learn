package indi.gxwu.jdbc.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: gx.wu
 * @Date: 2020/3/24 11:30
 * @Description: 广播表
 */
@Data
@Entity
@Table(name = "t_config")
public class TbConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "config")
    private String config;
}
