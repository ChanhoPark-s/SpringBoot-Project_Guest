package com.example.demo.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
    
   @Resource
    private SqlSessionTemplate sqlSessionTemplate;
    
    private static final String MAPPER_NM = "com.example.demo.model.MemberBean.";
    
    public List<MemberBean> getUserList(){
        return sqlSessionTemplate.selectList(MAPPER_NM+"getAllmember");
    }
}