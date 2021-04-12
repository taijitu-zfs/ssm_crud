package com.dkm.service;

import com.dkm.bean.Department;
import com.dkm.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//别忘了把DepartmentService放入容器内
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 通过id来查询部门信息
     * @param id
     * @return
     */
    public Department getInfo(Integer id){
        return departmentMapper.selectByPrimaryKey(id);
    }
}
