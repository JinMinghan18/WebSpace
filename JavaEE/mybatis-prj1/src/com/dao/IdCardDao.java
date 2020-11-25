package com.dao;

import com.mybatis.po.Idcard;
import org.apache.ibatis.annotations.Mapper;

import com.mybatis.po.Idcard;
//@Repository("idCardDao")
//@Mapper
public interface IdCardDao {
    public Idcard selectCodeById(Integer id);

}
