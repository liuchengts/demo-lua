//package com.example.demolua.common;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.redis.core.RedisHash;
//import org.springframework.data.redis.core.index.Indexed;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.Date;
//
///**
// * Created by kk on 2019/1/7.
// * 购买信息实体
// */
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@RedisHash("buy")
//public class RedisBuy implements Serializable {
//    @Id
//    @Indexed
//    private Long id;
//
//    /**
//     * 购买者主键ID
//     */
//    @Indexed
//    private Long buyDukeId;
//
//    /**
//     * 购买者昵称
//     */
//    @Indexed
//    private String buyDukeName;
//
//    /**
//     * 购买者数量
//     */
//    private Integer buyNumber;
//
//    /**
//     * 购买金额
//     */
//    @Indexed
//    private BigDecimal buyPrice;
//
//    /**
//     * 购买单价
//     */
//    @Indexed
//    private BigDecimal buyUnitPrice;
//
//    /**
//     * 创建时间
//     */
//    @Indexed
//    private Date createAt;
//
//    /**
//     * 修改时间
//     */
//    private Date updateAt;
//
//    /**
//     * 购买状态
//     */
//    @Indexed
//    private Integer buyTradeStatus;
//
//    /**
//     * 自动设置必要字段的值
//     */
//    @PostConstruct
//    public void prePersist() {
//        this.createAt = this.updateAt = new Date();
//        this.buyTradeStatus = 1;
//    }
//}
