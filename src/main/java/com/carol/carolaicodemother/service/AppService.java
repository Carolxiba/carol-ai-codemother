package com.carol.carolaicodemother.service;

import com.carol.carolaicodemother.model.dto.app.AppAddRequest;
import com.carol.carolaicodemother.model.dto.app.AppQueryRequest;
import com.carol.carolaicodemother.model.entity.User;
import com.carol.carolaicodemother.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.carol.carolaicodemother.model.entity.App;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://github.com/carolxiba">程序员Carol</a>
 */
public interface AppService extends IService<App> {

    Long createApp(AppAddRequest appAddRequest, User loginUser);

    /**
     * 获取应用封装类
     *
     * @param app
     * @return
     */
    AppVO getAppVO(App app);

    List<AppVO> getAppVOList(List<App> appList);

    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    /**
     * 通过对话生成代码
     * @param appId 应用id
     * @param message 用户消息
     * @param loginUser 登录用户
     * @return flux流
     */
    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    String deployApp(Long appId, User loginUser);

    void generateAppScreenshotAsync(Long appId, String appUrl);
}
