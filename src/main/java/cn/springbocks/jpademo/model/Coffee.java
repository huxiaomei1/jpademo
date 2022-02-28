package cn.springbocks.jpademo.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.joda.money.Money;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity                     // 实例
@Table(name = "T_MENU")     // 将实力类与数据库表进行关联
@Data                       // getter setter equals tostring
@NoArgsConstructor          // 无参构造方法
@AllArgsConstructor         // 全参构造方法
@Builder                    // new Coffee()  不符合面向对象设计  设计模式：构建者模式 更加符合面向对象
public class Coffee implements Serializable {

    @Id                 // 在数据库中是id
    @GeneratedValue     // 自动增长
    private Long id;

    private String name;
    @Column                 // 将字段和数据库列建立起关系
    private Money price;
    @Column(updatable = false)
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;



}