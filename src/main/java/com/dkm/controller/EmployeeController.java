package com.dkm.controller;

import com.dkm.bean.Department;
import com.dkm.bean.Employee;
import com.dkm.bean.Msg;
import com.dkm.service.DepartmentService;
import com.dkm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * 员工crud
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

////    返回页面json数据，适应多种请求
//    @RequestMapping("/emps")
//    @ResponseBody
//    public Msg getEmpWithJson(@RequestParam(value = "pn", defaultValue = "1")Integer pn){
//        //      获取页数为五，从pn页开始
//        PageHelper.startPage(pn,5);
////        引入分页插件pageHelper
//        List<Employee> employeeList = employeeService.getAll();
////      连续显示5页
//        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList,5);
//        return Msg.success().add("pageInfo",pageInfo);
//    }


    /**
     * 员工查询
     * @return
     */
    @RequestMapping("/emps")
    public String getEmp(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
                         Model model){
//      获取页数为五，从pn页开始
        PageHelper.startPage(pn,5);
//        引入分页插件pageHelper
        List<Employee> employeeList = employeeService.getAll();
//      连续显示5页
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList,5);
//      通过model把数据传到页面
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }

//    调用service层的方法，其实现不用管，交给容器自动注入

    @RequestMapping(value = "/emps/{id}",method = RequestMethod.DELETE)
//    传入一个参数id，即要删除的id，单个删除
    public String deleteEmpById(@PathVariable("id")Integer id){
        employeeService.deleteEmp(id);
        System.out.println("删除的ID是"+id);
        return "list";
    }

//更新跳转
    @RequestMapping(value = "/emps/{id}",method = RequestMethod.GET)
//    传入一个参数id，即要更新的id
    public String toUpdateEmpById(@PathVariable("id")Integer id,Model model){
//        employeeService.deleteEmp(id);
//        System.out.println("更新的ID是"+id);
        Employee employeeUpdate = employeeService.getOne(id);
        model.addAttribute("empInfo",employeeUpdate);
        return "updateList";
    }
//更新持久化操作
    @RequestMapping(value = "/emps/{id}",method = RequestMethod.PUT)
//    传入一个参数id，即要更新的id，单个更新
    public String updateEmpById(@PathVariable("id")Integer id,
                                @RequestParam Integer empId,
                                @RequestParam String empName,
                                @RequestParam String gender,
                                @RequestParam String email,
                                @RequestParam Integer dId){
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setEmpName(empName);
        employee.setGender(gender);
        employee.setEmail(email);
        employee.setdId(dId);

        employeeService.updateEmp(employee);//更新
//        System.out.println("更新的ID是"+id);
        return "list";
    }

    //去添加页面
    @RequestMapping(value = "/emps/toInsert",method = RequestMethod.GET)
    public String toInsertEmpById(Model model){

        return "insertList";
    }

    @RequestMapping(value = "/emps/insert",method = RequestMethod.POST)
//    添加员工信息
    public String insertEmp(@RequestParam Integer empId,
                            @RequestParam String empName,
                            @RequestParam String gender,
                            @RequestParam String email,
                            @RequestParam Integer dId){

//        if(empId.equals(employeeService.getTeInfo(empId).getEmpId())) {
//            return "insertList";
//        }else if (!dId.equals(departmentService.getInfo(dId).getDeptId())){
//            return "insertList";
//        }
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setEmpName(empName);
        employee.setGender(gender);
        employee.setEmail(email);
        employee.setdId(dId);
        employeeService.insertEmp(employee);
//        employeeService.insertEmp(employee);
//        System.out.println("添加的ID是"+id);
        return "list";
    }

}
