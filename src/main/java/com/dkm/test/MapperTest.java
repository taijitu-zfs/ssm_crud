package com.dkm.test;

import com.dkm.bean.Department;
import com.dkm.bean.Employee;
import com.dkm.dao.DepartmentMapper;
import com.dkm.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao层的工作
 */
//指定使用spring测试工具,有误，取不到值
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

//    @Autowired
//    DepartmentMapper departmentMapper;

    @Test
    public void crudTest(){
//        1，创建IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        2从容器中获取部门mapper
        DepartmentMapper departmentMapper = ioc.getBean(DepartmentMapper.class);
//        获取员工mapper,即获取自动注入的对象
        EmployeeMapper employeeMapper = ioc.getBean(EmployeeMapper.class);
//        注入sqlsession
        SqlSession sqlSession = ioc.getBean(SqlSession.class);
//        System.out.println(departmentMapper);
        System.out.println(departmentMapper.getClass());
//        Department department = ioc.getBean(Department.class);
//        插入部门信息
//        departmentMapper.insertSelective(new Department(null,"开发部"));
//        departmentMapper.insertSelective(new Department(null,"测试部"));
//插入员工信息        Employee(Integer empId, String empName, String gender, String email, Integer dId)
//        employeeMapper.insertSelective(new Employee(null,"Tom","男","tom@dkm.org",1));

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for(int i=0; i<50; i++){
            String uid = UUID.randomUUID().toString().substring(0,5)+""+i;
            mapper.insertSelective(new Employee(null,uid,"男",uid+"@dkm.org",1));
        }

    }
}
