package com.tuzhi.boot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tuzhi.boot.base.BaseDomain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @ClassName:Log
 * @Description:的实体类
 * @author 郑德超
 * @CreateDate 2018-06-26 13:40:43
 */
@Table(name = "log")
public class Log extends BaseDomain {
	
    /**id**/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**ip**/
    private String ip;

    /**createdTime**/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    private java.util.Date createdTime;

    /**id**/
    public Integer getId(){
        return id;
    }
    /**id**/
    public void setId(Integer id){
        this.id= id;
    }
    /**ip**/
    public String getIp(){
        return ip;
    }
    /**ip**/
    public void setIp(String ip){
        this.ip= ip;
    }
    /**createdTime**/
    public java.util.Date getCreatedTime(){
        return createdTime;
    }
    /**createdTime**/
    public void setCreatedTime(java.util.Date createdTime){
        this.createdTime= createdTime;
    }

	
}
