package cn.springbocks.jpademo.dao;

import cn.springbocks.jpademo.model.Coffee;
import org.springframework.data.repository.CrudRepository;

/*
   数据库操作层
   继承自 jpa  CrudRepository (create Retrieve update delete)
   因此 CoffeeRepository 有了增删改查的功能
 */
public interface CoffeeRepository extends CrudRepository<Coffee, Long > {

}
