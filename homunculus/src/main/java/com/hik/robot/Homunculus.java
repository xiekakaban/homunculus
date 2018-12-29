package com.hik.robot;

import io.github.biezhi.wechat.WeChatBot;
import io.github.biezhi.wechat.api.annotation.Bind;
import io.github.biezhi.wechat.api.constant.Config;
import io.github.biezhi.wechat.api.enums.AccountType;
import io.github.biezhi.wechat.api.enums.MsgType;
import io.github.biezhi.wechat.api.model.WeChatMessage;
import io.github.biezhi.wechat.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component("homunculus")
@Slf4j
public class Homunculus extends WeChatBot implements InitializingBean,DisposableBean{

    public Homunculus() {
        super(Config.me().autoLogin(false));
    }

    @Bind(msgType = MsgType.TEXT,accountType = AccountType.TYPE_GROUP)
    public void handleText(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
//            this.sendMsg(message.getFromUserName(), "自动回复: " + message.getText());
        }
    }

    @Bind(msgType = MsgType.TEXT)
    public void handWuWeiText(WeChatMessage message){
        if(StringUtils.isNotEmpty(message.getName()) && message.getFromNickName().equals("吴唯")){
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
            if(message.getText().equals("猜成语")){
                // dochengyu();
            }
        }
    }




    public static void main(){
        WeChatMessage weChatMessage = new WeChatMessage();
        weChatMessage.setFromNickName("吴唯");
        weChatMessage.setText("你好吗？");

    }


    public void run() {
        this.start();
    }

    @Override
    public void destroy() throws Exception {
        log.info("关闭Homuculus");
        this.api().logout();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("启动Homuculus");
    }
}