package com.hik;

import com.hik.robot.Homunculus;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class ContainerStart {

    public static void main(String[] args) throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ContainerStart.class);
        ConfigurableApplicationContext applicationContext = builder.headless(false).web(WebApplicationType.NONE).registerShutdownHook(true).run();
        Homunculus homunculus = (Homunculus)applicationContext.getBean("homunculus");
//        ((AbstractApplicationContext)applicationContext).registerShutdownHook(); //非java项目添加钩子函数。
        homunculus.start();
        Scanner scanner = new Scanner(System.in);
        // 循环
        while(true) {
            //获取控制台输入，如果没有会被阻塞
            String in = scanner.nextLine();
            //如果输入 q表示退出程序
            if (in.equals("q!")) {
                break;
            }
        }
        homunculus.destroy();
        log.info("关闭");

    }
}