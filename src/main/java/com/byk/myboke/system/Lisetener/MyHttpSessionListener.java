package com.byk.myboke.system.Lisetener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: bianyakun
 * @Date: 2018/6/19 18:05
 * @Todo:   获取当前在线人数
 */
@WebListener
public class MyHttpSessionListener  implements HttpSessionListener {

    public static int peopleOnLine = 0;


    /**
     * @Author: bianyakun
     * @Date: 2018/6/19 18:06
     * @todo:   访客增加
     * @param:   * @param null
     */
    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        System.out.println("myHttpSessionListener.sessionCreated():"+arg0);
        peopleOnLine++;
        arg0.getSession().setAttribute("peopleOnLine",peopleOnLine);
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/6/19 18:06
     * @todo: 访客减少
     * @param:   * @param null
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        System.out.println("myHttpSessionListener.sessionDestroyed():"+arg0);
        peopleOnLine--;
        arg0.getSession().setAttribute("peopleOnLine",peopleOnLine);
    }
}
