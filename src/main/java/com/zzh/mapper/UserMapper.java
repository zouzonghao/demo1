package com.zzh.mapper;

import com.zzh.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * from user where username = #{userName} and password =#{passWord}")
    User select(@Param("userName") String username, @Param("passWord") String password);

    @Insert("INSERT user value (null,#{userName},#{passWord})")
    void add(@Param("userName") String username, @Param("passWord") String password);

    @Select("SELECT * from user where username = #{userName} ")
    User selectByName(@Param("userName") String username);

}
