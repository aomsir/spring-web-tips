package com.aomsir.entity;

import java.io.Serializable;

/**
 * @Author: Aomsir
 * @Date: 2023/4/10
 * @Description:
 * @Email: info@say521.cn
 * @GitHub: https://github.com/aomsir
 */
public class TestEntity  implements Serializable{


    private static final long serialVersionUID = 1L;

    private Long id;

    public TestEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
