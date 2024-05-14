package org.scheele.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.scheele.domain.User;
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
