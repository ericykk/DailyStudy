package com.eric.study.mybatis.test;

import com.eric.study.mybatis.dao.PhoneNumberDao;
import com.eric.study.mybatis.model.PhoneNumber;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * description:
 * author:yangkang
 * Date:16/8/22
 * Time:10:26
 * version 1.0.0
 */
public class PhoneNumberTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try{
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        try{

//          PhoneNumber phoneNum = session.selectOne("PhoneNumberDao.getPhoneNumberById",2);
            //方式2 通过接口
            PhoneNumberDao phoneNumberDao = session.getMapper(PhoneNumberDao.class);
            PhoneNumber phoneNum = phoneNumberDao.getPhoneNumberById(2);
            System.out.println(phoneNum.getPhoneNum());
            System.out.println(phoneNum.getImei());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }

    }


}
