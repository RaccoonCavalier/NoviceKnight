package cn.king.boot.mapper;

import cn.king.boot.pojo.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
}
