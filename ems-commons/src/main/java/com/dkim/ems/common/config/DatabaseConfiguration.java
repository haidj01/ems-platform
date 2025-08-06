package com.dkim.ems.common.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

@Data
@Configuration
@ConfigurationProperties(prefix = "ems.datasource")
public class DatabaseConfiguration {
    private String host;
    private String userName;
    private String password;
    private String database;

    @Bean
    ConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder()
            .host(host)
            .port(5432)
            .database(database)
            .username(userName)
            .password(password)
            .build();

        return new PostgresqlConnectionFactory(config);
    }

    public R2dbcEntityTemplate r2dbcEntityTemplate(ConnectionFactory connectionFactory) {
        return new R2dbcEntityTemplate(connectionFactory);
    }
}
