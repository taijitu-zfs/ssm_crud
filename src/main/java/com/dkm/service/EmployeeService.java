package com.dkm.service;

import com.dkm.bean.Department;
import com.dkm.bean.Employee;
import com.dkm.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 查到所有员工信息，需要dao层，注入
     * @return
     */
    public List<Employee> getAll(){

        return employeeMapper.selectByExampleWithDept(null);
    }

    public Employee getTeInfo(Integer id){
        return employeeMapper.selectByPrimaryKey(id);
    }


    /**
     * 获取要更新人的信息，包括部门信息
     * @param id
     * @return
     */
    public Employee getOne(Integer id){
        return employeeMapper.selectByPrimaryKeyWithDept(id);
    }

//service层调用dao层的删除方法，其中dao层的删除方法已经在他的mybatis配置文件中已经写好，直接调用即可
    public void deleteEmp(Integer id){
        employeeMapper.deleteByPrimaryKey(id);
    }
//更新操作
    public void updateEmp(Employee employee){
        employeeMapper.updateByPrimaryKeySelective(employee);
    }
    //添加操作
    public void insertEmp(Employee employee){
        employeeMapper.insertSelective(employee);
    }
}
