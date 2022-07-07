package com.zzh.mapper;

import com.zzh.pojo.Item;
import com.zzh.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.LinkedList;
import java.util.List;

public interface ItemMapper {
    @Results(id = "123", value = {
            @Result(column = "music", property = "name"),
            @Result(column = "musician", property = "describe")
    })
    @Select("select * from music")
    List<Item> selectAll();

    @Insert("INSERT into music values(null, #{name},#{describe},#{url})")
    void add(Item item);

    @ResultMap("123")
    @Select("SELECT * from music where music = #{name}")
    Item selectByName(String name);

    //@ResultMap("123")
    //concat('%',#{dname},'%')
    List<Item> selectByLikeName(@Param("begin") int begin, @Param("size") int size,@Param("name") String name,@Param("dname") String dname);

    @Update("UPDATE music set music = #{name},musician = #{describe},url = #{url} where music = #{name}")
    void update(Item item);

    @Delete("delete from music where music = #{name}")
    void delete(String name);

    void mdel(List<String> names);
    @ResultMap("123")
    @Select("SELECT * from music limit #{begin},#{size}")
    List<Item> selectByPage(@Param("begin") int begin, @Param("size") int size);

    @Select("SELECT COUNT(*) from music")
    int selectCounts();


    int selectCounts2(@Param("name") String name, @Param("dname") String dname);
}

