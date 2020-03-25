package indi.gxwu.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.Date;

/**
 * @Author: gx.wu
 * @Date: 2020/3/25 14:08
 * @Description: code something to describe this module what it is
 */
@Data
@Builder
public class HistoryLog {
    private long id;
    private Date createTime;
    private String content;

    @Tolerate
    public HistoryLog(){}
}
