package com.weikun.dao;

import com.weikun.vo.BBSUser;

/**
 * Created by Administrator on 2016/10/30.
 */
public interface IUserDAO {
    /**
     *
     * @param user :登录的用户
     * @return true：成功 false：失败
     */
    public boolean login(BBSUser user);
}
