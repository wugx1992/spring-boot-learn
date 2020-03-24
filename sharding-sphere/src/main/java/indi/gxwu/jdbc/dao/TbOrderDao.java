package indi.gxwu.jdbc.dao;

import indi.gxwu.jdbc.entity.TbOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: gx.wu
 * @Date: 2020/3/24 11:44
 * @Description: code something to describe this module what it is
 */
@Repository
public interface TbOrderDao extends JpaRepository<TbOrder,Long> {
}
