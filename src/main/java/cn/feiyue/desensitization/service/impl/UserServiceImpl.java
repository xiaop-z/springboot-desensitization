package cn.feiyue.desensitization.service.impl;

import cn.feiyue.desensitization.mapper.UserMapper;
import cn.feiyue.desensitization.pojo.User;
import cn.feiyue.desensitization.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Date 2020-08-27 15:25
 * @Created by zfy
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
