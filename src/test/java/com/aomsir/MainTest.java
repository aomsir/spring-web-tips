package com.aomsir;

import com.aomsir.entity.TestEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @Author: Aomsir
 * @Date: 2023/4/10
 * @Description:
 * @Email: info@say521.cn
 * @GitHub: https://github.com/aomsir
 */
@SpringBootTest
public class MainTest {

    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    @Test
    public void testRedisSerializar() {
        this.redisTemplate.opsForValue().set("Key","Value");
        System.out.println("this.redisTemplate.opsForValue().get(\"Key\") = " + this.redisTemplate.opsForValue().get("Key"));

        System.out.println("============");


        // 此处结合 TestEntity中的实现的接口与UID，把他们两(看成一个整体)删了进行测试看看会有啥问题？
        // 结合 RedisConfig中的序列化那行的代码看看,把那行代码注释看看
        // 上面两种情况组合起来进行测试，去看Redis中KEY-VALUE是怎么存储的，想想为啥
        // 问题我复盘不出来了,之前遇到过，反正必须得加
        TestEntity Value = new TestEntity(2L);
        this.redisTemplate.opsForValue().set("KEY",Value);
        TestEntity entity = (TestEntity) this.redisTemplate.opsForValue().get("KEY");
        System.out.println("entity.getId() = " + entity.getId());
    }
}
