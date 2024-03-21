package cn.iocoder.yudao.module.ai.remote.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhoupeng
 */
@Configuration
@ConfigurationProperties(prefix = "langchain")
@Data
public class LangchainPropertiesConfig {

    private String host;
    private String knowledgeList;
    private String knowledgeCreate;
    private String knowledgeDelete;
    private String knowledgeListDocs;
    private String knowledgeSearchDocs;
    private String knowledgeUploadDocs;
    private String knowledgeDeleteDocs;
    private String knowledgeUpdateDocs;
    private String knowledgeDownloadDocs;



}
