package indi.gxwu.jdbc.controller;

import indi.gxwu.jdbc.entity.HistoryLog;
import indi.gxwu.jdbc.service.HistoryLogService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author: gx.wu
 * @Date: 2020/3/25 14:21
 * @Description: code something to describe this module what it is
 */
@Slf4j
@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    HistoryLogService historyLogService;

    @RequestMapping({"/", "/list"})
    public List<HistoryLog> getList(){
        return historyLogService.getList();
    }


    /**
     * http://localhost:8181/history/filter?beginTime=2020-03-01 00:00:00&endTime=2020-03-02 11:11:11
     * @param beginTime
     * @param endTime
     * @return
     */
    @RequestMapping("/filter")
    public List<HistoryLog> filter(String beginTime, String endTime){
        log.info("beginTime: {}, endTime: {}", beginTime, endTime);
        Date bt = DateTime.parse(beginTime, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate();
        Date et = DateTime.parse(endTime, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate();
        return historyLogService.getList(bt, et);
    }


    /**
     * http://localhost:8181/history/save?id=1&content=abcd&createTime=2020-03-02 11:11:11
     * @param id
     * @param content
     * @param createTime
     * @return
     */
    @RequestMapping("/save")
    public int save(long id, String content, String createTime){
        log.info("id: {}, content: {}, createTime: {}", id, content, createTime);
        Date cd = DateTime.parse(createTime, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate();
        return historyLogService.save(id, content, cd);
    }


}
