package com.zzh.service;

import com.zzh.mapper.ItemMapper;

import com.zzh.pojo.Item;
import com.zzh.pojo.PageBean;
import com.zzh.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Item> selectAll() {
        SqlSession sqlSession = factory.openSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        List<Item> items = mapper.selectAll();
        sqlSession.close();
        return items;
    }

    public int add(Item item) {
        SqlSession sqlSession = factory.openSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);

        Item items = this.selectByName(item.getName());
        if ((item.getName() != null) && (items == null)) {
            mapper.add(item);
            sqlSession.commit();
            sqlSession.close();
            return 1;
        } else {
            sqlSession.close();
            return 0;
        }
    }

    public int del(Item item) {
        SqlSession sqlSession = factory.openSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        mapper.delete(item.getName());
        sqlSession.commit();
        Item items = this.selectByName(item.getName());
        if (items == null) {
            sqlSession.close();
            return 1;
        } else {
            sqlSession.close();
            return 0;
        }
    }

    public int update(Item item) {
        SqlSession sqlSession = factory.openSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        Item item1 = this.selectByName(item.getName());
        if (item1 == null) {
            mapper.add(item);
            sqlSession.commit();
            sqlSession.close();
            return 1;
        }
        mapper.update(item);
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    public int mdel(Item[] items) {
        SqlSession sqlSession = factory.openSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            strings.add(items[i].getName());
        }
        mapper.mdel(strings);
        sqlSession.commit();

        return 1;

    }

    //    @Test
//    public void mdel() {
//        SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
//        SqlSession sqlSession = factory.openSession();
//        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
//        List<String> strings = new ArrayList<>();
//        strings.add("123");
//        strings.add("1234");
//        strings.add("12345");
//        System.out.println(strings);
//        mapper.mdel(strings);
//        sqlSession.commit();
////
//    }
    public int updateip(String ip) {
        List<Item> items = this.selectAll();
        for (int i = 0; i < items.size(); i++) {
            String url = items.get(i).getUrl();
            if (!url.contains("[" ) || !url.contains("]")){
                continue;
            }
            int a = url.lastIndexOf('[');
            int b = url.lastIndexOf(']');
            String begin = url.substring(0, a + 1);
            String end = url.substring(b );
            String newurl = begin + ip + end;
            items.get(i).setUrl(newurl);
            this.update(items.get(i));
        }
        return 1;

    }

//    @Test
//    public void text(){
//        String url = "[123]";
//        String ip ="1234";
//        if (!url.contains("[" ) || !url.contains("]")){
//        return;
//        }
//        int a = url.lastIndexOf('[');
//        int b = url.lastIndexOf(']');
//        System.out.println(url.substring(0, a + 1));
//        System.out.println(url.substring(b + 1, url.length()));
//        String begin = url.substring(0, a + 1);
//        String end = url.substring(b , url.length());
//        String newurl = begin + ip + end;
//        System.out.println(newurl);
//    }


    //    @Test
//public void selectByMusic(){
//        SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
//        SqlSession sqlSession = factory.openSession();
//        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
//        Item items = mapper.selectByName("123");
//        sqlSession.close();
//    //System.out.println(item);
//    System.out.println(items);
//}
    public Item selectByName(String name) {
        SqlSession sqlSession = factory.openSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        Item items = mapper.selectByName(name);
        sqlSession.close();
        return items;
    }
    public PageBean<Item> selectByLikeName(int currentPage, int pageSize, String name, String dname) {
        SqlSession sqlSession = factory.openSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        //计算sql所需参数（开始索引-1，查找数目）
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        System.out.println("lmpl:" + begin + size + name + dname);
        //调用sql语句
        List<Item> items = mapper.selectByLikeName(begin, size, name, dname);
        System.out.println("lmpl:" + items);
        int counts = mapper.selectCounts2(name, dname);
        System.out.println("lmpl:" + items);
        //封装PageBean
        PageBean<Item> itemPageBean = new PageBean<>();
        itemPageBean.setPageItems(items);
        itemPageBean.setCounts(counts);
        System.out.println("lmpl:" + itemPageBean);
        return itemPageBean;
    }

//    @Test
//    public void  test(){
//        SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
//        SqlSession sqlSession = factory.openSession();
//        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
//        List<Item> items = mapper.selectByLikeName(0, 10, "J", "D");
//        int counts = mapper.selectCounts2("J", "D");
//        System.out.println(items);
//        System.out.println(counts);
//    }

    public PageBean<Item> page(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        //计算sql所需参数（开始索引-1，查找数目）
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        //调用sql语句
        List<Item> items = mapper.selectByPage(begin, size);
        int counts = mapper.selectCounts();
        //封装PageBean
        PageBean<Item> itemPageBean = new PageBean<>();
        itemPageBean.setPageItems(items);
        itemPageBean.setCounts(counts);

        return itemPageBean;
    }

//    public List<Item> selectByLikeMusic(String music) {
//        SqlSession sqlSession = factory.openSession();
//        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
//        List<Item> items = mapper.selectByLikeMusic(music);
//        sqlSession.close();
//        return items;
//    }
//    @Test
//    public void t(){
//        SqlSession sqlSession = factory.openSession();
//        MusicMapper mapper = sqlSession.getMapper(MusicMapper.class);
//        List<Music> musics = mapper.selectByLikeMusic("稻");
//        sqlSession.close();
//        System.out.println(musics);
//
//    }


    public void delete(String music) {
        SqlSession sqlSession = factory.openSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        mapper.delete(music);
        sqlSession.commit();
        sqlSession.close();
    }

}
