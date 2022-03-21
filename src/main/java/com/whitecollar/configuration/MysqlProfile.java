package com.whitecollar.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("mysql.properties")
@Profile("mysql")
public class MysqlProfile {
}
