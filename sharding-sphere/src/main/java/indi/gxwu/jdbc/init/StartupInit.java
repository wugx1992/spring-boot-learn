package indi.gxwu.jdbc.init;

import indi.gxwu.jdbc.service.InitMainTableMapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: gx.wu
 * @Date: 2020/3/27 15:25
 * @Description: code something to describe this module what it is
 */
@Slf4j
@Component
public class StartupInit implements CommandLineRunner {

    @Autowired
    InitMainTableMapService initMainTableMapService;

    @Override
    public void run(String... args) throws Exception {
        log.info("start initial main table map ...");
        initMainTableMapService.initOrUpdateCacheMap();
        initMainTableMapService.listeningCreateNewTable();
    }
}
