package indi.gxwu.jdbc.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: gx.wu
 * @Date: 2020/3/23 14:59
 * @Description: code something to describe this module what it is
 */
@Data
public class TbEntity {
    private int id;
    private String name;
    private Date createTime;
}
