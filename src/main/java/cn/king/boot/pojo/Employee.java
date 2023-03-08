package cn.king.boot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName(value = "t_emp" , autoResultMap = true)
public class Employee {
    @TableId(value = "emp_id" , type = IdType.AUTO)
    private Long id;
    private String empName;
    private Long age;
    private String sex;
    private String email;
}
