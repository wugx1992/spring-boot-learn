package indi.gxwu.jdbc.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.Date;

/**
 * @Author: gx.wu
 * @Date: 2020/3/25 14:54
 * @Description: code something to describe this module what it is
 */
@Data
@Builder
public class HistoryLogMsg {
    private int id;
    private Integer beginId;
    private Integer endId;
    private Date beginTime;
    private Date endTime;
    private int tableSuffix;
    private Date createTime;

    @Tolerate
    public HistoryLogMsg(){
    }
}
