package indi.gxwu.jdbc.controller;

import indi.gxwu.jdbc.entity.TbEntity;
import indi.gxwu.jdbc.service.TbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: gx.wu
 * @Date: 2020/3/23 15:11
 * @Description: code something to describe this module what it is
 */
@RestController
@RequestMapping("/tb")
public class TbController {

    @Autowired
    TbService tbService;

    @RequestMapping("/getList")
    public List<TbEntity> getList(){
        return tbService.getList();
    }

    @RequestMapping("/save")
    public int save(String name){
        return tbService.save(name);
    }

    @RequestMapping("/copy")
    public int save(int id){
        return tbService.copy(id);
    }
}
