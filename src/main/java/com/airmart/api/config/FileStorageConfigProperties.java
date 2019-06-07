package com.airmart.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix =ApiConstants.FILE_PROPERTIES_PREFIX)
@Data
public class FileStorageConfigProperties {

    private String uploadDir;

}
