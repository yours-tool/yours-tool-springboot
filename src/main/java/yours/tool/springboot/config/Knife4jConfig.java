package yours.tool.springboot.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(
        name = {"knife4j.enable"},
        havingValue = "true",
        matchIfMissing = true
)
public class Knife4jConfig {

    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public Knife4jConfig(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Autowired
    private Environment environment;

    @Bean(value = "defaultApi3")
    public Docket defaultApi3() {
        String groupName = environment.getProperty("knife4j.info.groupName","default");
        String scanPackage = environment.getProperty("knife4j.info.scanPackage","yours.tool");
        Docket docket=new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName(groupName)
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage(scanPackage))
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildExtensions(groupName));
        return docket;
    }

    private ApiInfo apiInfo() {
        String title = environment.getProperty("knife4j.info.title","yours-tool");
        String description = environment.getProperty("knife4j.info.description","");
        String serviceUrl = environment.getProperty("knife4j.info.serviceUrl","https://www.baidu.com");
        String author = environment.getProperty("knife4j.info.author","yours-tool");
        String authorUrl = environment.getProperty("knife4j.info.authorUrl","");
        String authorEmail = environment.getProperty("knife4j.info.authorEmail","");
        String version = environment.getProperty("knife4j.info.version","1.0");
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(serviceUrl)
                .contact(new Contact(author,authorUrl,authorEmail))
                .version(version)
                .build();
    }
}
