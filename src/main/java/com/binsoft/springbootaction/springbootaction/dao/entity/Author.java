package com.binsoft.springbootaction.springbootaction.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

@TableName(value = "t_author")
public class Author extends Model<Author> {
    private static final long serialVersionUID = 1L;

    @TableId(value="id",type = IdType.AUTO)
    private Integer id;

    private String realName;

    private String nickName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
