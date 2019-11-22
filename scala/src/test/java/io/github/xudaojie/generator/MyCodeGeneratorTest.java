package io.github.xudaojie.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.mysql.jdbc.Driver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class MyCodeGeneratorTest {

    private String url = "jdbc:mysql://192.168.115.105:3306/news_user";

    private String username = "root";

    private String password = "Hik12345+";

    private String packageName = "io.github.xudaojie.generator";

    @Test
    public void codeTest() {

        GlobalConfig config = new GlobalConfig();
        config.setAuthor("xdj")
                .setOutputDir("src/main/java")
                .setServiceName("%sService")
                .setFileOverride(true);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName(Driver.class.getName())
                .setUrl(url)
                .setUsername(username)
                .setPassword(password);

        // 表配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setSkipView(true)
                .setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel) // 下划线转驼峰
                .setRestControllerStyle(true)
                .setTablePrefix("news")
                .setInclude("news_user");

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setController("controller")
                .setEntity("domain")
                .setService("service")
                .setServiceImpl("service.impl")
                .setParent(packageName);

        // Templates
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("templates/controller.java");

        // 自定义
        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
        fileOutConfigs.add(new FileOutConfig("templates/datasource.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "./com/xml/" + tableInfo.getEntityName() + "DataSource.java";
            }
        });
        fileOutConfigs.add(new FileOutConfig("templates/repository.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "./com/xml/" + tableInfo.getEntityName() + "Repository.java";
            }
        });
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("packageName", packageName);
                this.setMap(map);
            }
        }.setFileOutConfigList(fileOutConfigs);

        // 生成
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
            .setTemplate(templateConfig)
            .setTemplateEngine(new FreemarkerTemplateEngine())
                .setCfg(injectionConfig)
                .execute();

    }
}
