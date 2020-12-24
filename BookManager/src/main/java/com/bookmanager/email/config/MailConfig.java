package com.bookmanager.email.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "mail")
public class MailConfig {

    private List<MailProperties> configs;

    @Data
    public static class MailProperties {
        /**
         * 邮箱地址
         */
        private String username;
        /**
         * 授权密码
         */
        private String password;

        /**
         * host
         */
        private String host;

        /**
         * 端口
         */
        private Integer port;

        /**
         * 协议
         */
        private String protocol;

        /**
         * 默认编码
         */
        private String defaultEncoding;

    }

}