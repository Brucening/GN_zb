package com.example.gn.gn_zb.entity;

import java.io.Serializable;

/**
 * Created by GN on 2017/2/15.
 */
public class BaseBean implements Serializable{
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
