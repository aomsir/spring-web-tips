package com.aomsir.controller;

import com.aomsir.common.Response;
import com.aomsir.entity.TestEntity;
import com.aomsir.entity.TestEntity1;
import com.aomsir.entity.User;
import com.aomsir.service.TestServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @Author: Aomsir
 * @Date: 2023/4/10
 * @Description:
 * @Email: info@say521.cn
 * @GitHub: https://github.com/aomsir
 */
@RestController
public class TestController {

    @Resource
    private TestServiceImpl testService;

    // 不使用Jackson也是可以序列化的 - 测试的时候将WebMvcConfig与JacksonObjectMapper进行注释
    @GetMapping("/test1")
    public User get() {
        return new User("Aomsir",21,"123456789");
    }

    // 自定义使用Jackson的原因 - 测试的时候将WebMvcConfig与JacksonObjectMapper进行注释再测试,测试结束后取消注释测试,看看有什么问题
    @GetMapping("/test2")
    public TestEntity get2() {
        return new TestEntity(9223372036854775807L);
    }


    // 自定义使用Jackson的原因 - 测试的时候将WebMvcConfig与JacksonObjectMapper进行注释再测试,测试结束后取消注释测试,看看有什么问题
    @GetMapping("/test3")
    public TestEntity1 get3() {
        return new TestEntity1(LocalDateTime.now());
    }

    // 全局异常与自定义异常的处理
    // 先将自定义异常与全局异常注释,访问这个接口看看会有什么问题
    // 然后再将注释取消,重启项目再次访问看看
    // 结合前后端开发项目需要注意的要点进行思考,想想前端需要什么?这个项目开发出来是面向谁?面向的所有人都是开发者?
    @GetMapping("/test4")
    public Response get4() {
        this.testService.test();   // 里面模拟异常(两个模拟,看看有啥区别?)
        return Response.success(new TestEntity(9223372036854775807L));
    }
}
