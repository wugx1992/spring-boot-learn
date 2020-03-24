package indi.gxwu.jdbc.controller;

import indi.gxwu.jdbc.dao.TbConfigDao;
import indi.gxwu.jdbc.entity.TbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @Author: gx.wu
 * @Date: 2020/3/24 14:04
 * @Description: code something to describe this module what it is
 */


@RestController
public class ConfigController {
    @Autowired
    private TbConfigDao configDao;

    @RequestMapping(value = "/listConfig", method = RequestMethod.GET)
    public List<TbConfig> getConfig() {
        return this.configDao.findAll();
    }
}