package com.mybatis.test;


import com.dao.IdCardDao;
import com.dao.OrdersDao;
import com.dao.PersonDao;
import com.mybatis.po.Idcard;
import com.mybatis.po.Person;
import com.pojo.MapUser;
import com.mybatis.po.MyUser;
import com.pojo.SelectUserParam;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MybatisTest {
    public static void main(String[] args){
        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf =
                    new SqlSessionFactoryBuilder().build(config);
            SqlSession ss = ssf.openSession();
            //查找一个
            //        MyUser mu =
//                    ss.selectOne("com.mybatis.mapper.UserMapper.selectUserById",1);
//            System.out.println(mu);
            //查找多个

            Map<String,Object>map=new HashMap<>();
            map.put("u_name","张");
            map.put("u_sex","male");
            SelectUserParam su = new SelectUserParam();
            su.setU_name("张");
            su.setU_sex("male");
//            UserDao userDao = ss.getMapper(UserDao.class);

//            MyUser one = userDao.selectUserById2(1);
//            List<MyUser> list=userDao.selectAllUser2(map);

//            List<MyUser> list=ss.selectList("com.mybatis.mapper.UserMapper.selectAllUser",su);
//            List<Map<String,Object>>lmp=ss.selectList("com.mybatis.mapper.UserMapper.selectAllUser2");
//            List<MapUser> lmp = ss.selectList("com.mybatis.mapper.UserMapper.selectResultMap");

            //            System.out.println(one);

//            for(MapUser myUser:lmp){
//                System.out.println(myUser);
//            }

            //插入
            MyUser addmu = new MyUser();
            addmu.setUid(4);
            addmu.setUname("张三");
            addmu.setUsex("male");
            MapUser addMapUser = new MapUser();
            addMapUser.setM_uid(6);
            addMapUser.setM_uname("张五");
            addMapUser.setM_usex("female");
//            Map<String,Object>addMapUser1 = new HashMap<>();
//            addMapUser1.put("m_uid",6);
//            addMapUser1.put("m_uname","张五");
//            addMapUser1.put("m_usex","female");
//            ss.insert("com.mybatis.mapper.UserMapper.addUser",addmu);
//            int result = ss.insert("com.mybatis.mapper.UserMapper.addUser2",addMapUser);
//            System.out.println(result);
            //更新
//            MapUser modifyMapUser = new MapUser();
//            modifyMapUser.setM_uid(6);
//            modifyMapUser.setM_uname("张六");
//            modifyMapUser.setM_usex("female");
//            int result = ss.update("com.mybatis.mapper.UserMapper.updateUser2",modifyMapUser);
//            System.out.println(result);
            //onetoone
            OrdersDao ordersDao = ss.getMapper(OrdersDao.class);
            PersonDao personDao = ss.getMapper(PersonDao.class);
            TestOneToOne one = new TestOneToOne();
            TestOneToMore more = new TestOneToMore();
            one.setPersonDao(personDao);
            more.setOrdersDao(ordersDao);
//            one.test();
            more.test1();
            ss.commit();
            ss.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
