package com.sparksys.admin.application.event;

import cn.hutool.system.SystemUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;

/**
 * description: Application启动后运行
 * 日志打印微服务关键配置信息(服务名、接口文档、访问地址)
 *
 * @author zhouxinlei
 * @date 2020-06-05 20:31:48
 */
@Component
@Slf4j
public class ApplicationRunner implements CommandLineRunner {

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        Environment env = applicationContext.getEnvironment();
        log.info("\n--------------------------------------------------------------\n\t" +
                        "Java Version: {} \n\t" +
                        "运行环境: {} \n\t" +
                        "应用: {} 运行成功! \n\t" +
                        "Spring Boot Admin监控: \t\thttp://{}:{}/\n" +
                        "--------------------------------------------------------------",
                SystemUtil.getJavaInfo().getVersion(),
                SystemUtil.getOsInfo().getName(),
                env.getProperty("spring.application.name"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }
}
