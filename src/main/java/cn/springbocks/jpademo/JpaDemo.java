package cn.springbocks.jpademo;

import cn.springbocks.jpademo.dao.CoffeeOrderRepository;
import cn.springbocks.jpademo.dao.CoffeeRepository;
import cn.springbocks.jpademo.model.Coffee;
import cn.springbocks.jpademo.model.CoffeeOrder;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@Slf4j
@EnableJpaRepositories   // 开启jpa功能支持
public class JpaDemo implements ApplicationRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemo.class , args );

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initOrders();
    }

    private void initOrders() {
        Coffee cappuccino = Coffee.builder()
                .name("卡布奇诺").
                price(Money.of(CurrencyUnit.of("CNY"), 20.98))
                .build(); // 使用构建者模式构建对象
        // 古驰 Gucci
        coffeeRepository.save(cappuccino);  // 通过jpa保存到数据库
        log.info("咖啡 {}", cappuccino );


        Coffee icedAmericano  = Coffee.builder()
                .name("冰美式").
                price(Money.of(CurrencyUnit.of("CNY"), 30.98))
                .build(); // 使用构建者模式构建对象
        // 古驰 Gucci
        coffeeRepository.save(icedAmericano);  // 通过jpa保存到数据库
        log.info("咖啡 {}", icedAmericano );


        // 订单
        CoffeeOrder oderForCuihua = CoffeeOrder.builder()
                .customer("隔壁翠花")
                .items(Collections.singletonList(cappuccino))
                .state(0)
                .build();
        coffeeOrderRepository.save(oderForCuihua);
        log.info("订单 {}" , oderForCuihua );

        CoffeeOrder oderForLuncy = CoffeeOrder.builder()
                .customer("Lucy")
                .items(Arrays.asList(cappuccino, icedAmericano))
                .state(0)
                .build();

        coffeeOrderRepository.save(oderForLuncy);
        log.info("订单 {}" , oderForLuncy);


    }

}
