package com.carol.carolaicodemother.service;

import com.carol.carolaicodemother.model.dto.UserQueryRequest;
import com.carol.carolaicodemother.model.vo.LoginUserVO;
import com.carol.carolaicodemother.model.vo.UserVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.carol.carolaicodemother.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * 用户 服务层。
 *
 * @author <a href="https://github.com/carolxiba">程序员Carol</a>
 */
public interface UserService extends IService<User> {


    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /*
    * 用户登录
    *
    * @param userAccount 用户账户
    * @param userPasswrod 用户账号
    * @param request
    * @return 脱敏后的用户信息
    * */
    LoginUserVO userLogin(String userAccount, String userPasword, HttpServletRequest request);

    User getLoginUser(HttpServletRequest request);

    String getEncryptPassword(String userPassword);

    LoginUserVO getLoginUserVO(User loginUser);
    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);

    UserVO getUserVO(User user);

    List<UserVO> getUserVOList(List<User> userList);

    QueryWrapper getQueryWrapper(UserQueryRequest userQueryRequest);
}
