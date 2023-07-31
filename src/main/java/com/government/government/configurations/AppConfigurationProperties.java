package com.government.government.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Anachuna Abuchi
 * email: aanachuna@oasismgt.net
 * July, 2023
 **/
@Configuration
@ConfigurationProperties(prefix = "app", ignoreInvalidFields = true)
@Getter
@Setter
public class AppConfigurationProperties {
    private String jwtSecret;
    private int jwtExpiration;
    private String secretSalt;;
    private String printDirectory;
}
