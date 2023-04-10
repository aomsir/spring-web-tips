package com.aomsir.entity;

import java.time.LocalDateTime;

/**
 * @Author: Aomsir
 * @Date: 2023/4/10
 * @Description:
 * @Email: info@say521.cn
 * @GitHub: https://github.com/aomsir
 */
public class TestEntity1 {
    private LocalDateTime time;

    public TestEntity1(LocalDateTime time) {
        this.time = time;
    }

    public TestEntity1() {
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
