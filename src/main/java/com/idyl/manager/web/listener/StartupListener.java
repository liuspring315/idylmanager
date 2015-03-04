package com.idyl.manager.web.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created on 12-9-13
 * <p>描述:    [所属模块及功能描述]</p>
 * <p>版权所有： 首都信息发展有限责任公司</p>
 *
 * @version 0.1
 * @liuzhaochun
 */
public class StartupListener implements ServletContextListener {
    private static final Log log = LogFactory.getLog(StartupListener.class);
    /**
     * spring程序的上下文
     */
    private WebApplicationContext context;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.debug("Initializing context...");
        ServletContext servletContext = sce.getServletContext();
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        //
        //获得系统的路径 /WebRoot

//        String rootPath = servletContext.getRealPath("/");
//        //获得log4j.properties的输入流
//        InputStream is =this.getClass().getClassLoader().getResourceAsStream("log4j.properties");
//        Properties prop = new Properties();
//        try {
//            prop.load(is);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //设置日志文件的输出路径
//        prop.setProperty("log4j.appender.RollingFile.File",rootPath+prop.getProperty("log4j.appender.RollingFile.File"));
//        prop.setProperty("log4j.appender.RollingFile.DatePattern",rootPath+prop.getProperty("log4j.appender.RollingFile.DatePattern"));
        //加载配置项
//        PropertyConfigurator.configure(prop);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /**
         *
         * 作成日期： ${DATE}
         * <p>功能描述: </p>
         * @author liuzhaochun
         * @version 0.1
         */

    }

    /**
     *
     * <p>描述:返回程序的上下文</p>
     *
     * @return
     * @update:
     */
    public WebApplicationContext getContext() {
        return context;
    }
}
