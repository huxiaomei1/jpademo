package cn.springbocks.jpademo.dao;


import cn.springbocks.jpademo.model.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder, Long > {
}
