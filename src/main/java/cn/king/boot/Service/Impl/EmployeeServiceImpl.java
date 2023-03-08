package cn.king.boot.Service.Impl;

import cn.king.boot.Service.EmployeeService;
import cn.king.boot.mapper.EmployeeMapper;
import cn.king.boot.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper , Employee> implements EmployeeService {
}
