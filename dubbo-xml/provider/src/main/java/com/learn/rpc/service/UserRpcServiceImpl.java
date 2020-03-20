package com.learn.rpc.service;

import com.learn.rpc.api.UserRpcService;
import com.learn.rpc.dto.UserAddDTO;
import com.learn.rpc.dto.UserDTO;
import org.springframework.stereotype.Service;

/**
 * @author liujin
 * @datetime 2020/3/6 13:45
 */
@Service
public class UserRpcServiceImpl implements UserRpcService {

    @Override
    public UserDTO get(Integer id) {
        return new UserDTO().setId(id)
                .setName("没有昵称：" + id)
                .setGender(id % 2 + 1); // 1 - 男；2 - 女
    }

    @Override
    public Integer add(UserAddDTO addDTO) {
        return (int) (System.currentTimeMillis() / 1000); // 嘿嘿，随便返回一个 id
    }

}
