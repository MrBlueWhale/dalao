package com.ibegu.dalao.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@ComponentScan("com.ibegu")
@SpringBootApplication
@MapperScan("com.ibegu.dalao.mapper")
public class DalaoApplication {

    private static final Logger LOG = LoggerFactory.getLogger(DalaoApplication.class);


    public static void main(String[] args) {

        // SpringApplication.run(DalaoApplication.class, args);

        SpringApplication app = new SpringApplication(DalaoApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));


    }

}
