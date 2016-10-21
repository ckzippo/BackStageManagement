package service;

import model.BackStageAdmin;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/19/16
 * TIME:4:31 PM
 */
public interface BackStageAdminService {

    // 用户名密码校验
    BackStageAdmin validateAdmin(String name, String password);

    // 新增管理员
    public void addBackStageAdmin(BackStageAdmin backStageAdmin);
}
