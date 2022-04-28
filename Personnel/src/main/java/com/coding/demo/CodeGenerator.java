package com.coding.demo;
import java.util.ArrayList;
import java.util.List;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
public class CodeGenerator {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/personnel?useUnicode=true&useSSL=false&characterEncoding=utf8";
	private static final String JDBC_USER_NAME = "root";
	private static final String JDBC_PASSOWRD = "123456";
	private static final String PACKAGE_NAME = "com.coding";
	private static final String MODULE_NAME = "demo";
	private static final String TBL_NAMES = "t_apply";
	private static final String TABLE_PREFIX = "t_";
	public static void main(String[] args) {
	    AutoGenerator mpg = new AutoGenerator();
	    GlobalConfig gc = getGlobalConfig();
	    mpg.setGlobalConfig(gc);
	    DataSourceConfig dsc = getDataSourceConfig();
	    mpg.setDataSource(dsc);
	    PackageConfig pc = getPackageConfig();
	    mpg.setPackageInfo(pc);
	    InjectionConfig cfg = getInjectionConfig();
	    mpg.setCfg(cfg);
	    TemplateConfig templateConfig = getTemplateConfig();
	    mpg.setTemplate(templateConfig);
	    mpg.setTemplateEngine(new FreemarkerTemplateEngine());
	    StrategyConfig strategy = getStrategyConfig();
	    mpg.setStrategy(strategy);
	    mpg.execute();
	}
	private static GlobalConfig getGlobalConfig() {
	    GlobalConfig gc = new GlobalConfig();
	    String projectPath = System.getProperty("user.dir");
	    gc.setOutputDir(projectPath + "/src/main/java");
	    gc.setAuthor("gjh");
	    gc.setOpen(false);
	    gc.setServiceName("%s" + ConstVal.SERVICE);
	    return gc;
	}
	private static DataSourceConfig getDataSourceConfig() {
	    DataSourceConfig dsc = new DataSourceConfig();
	    dsc.setDriverName(JDBC_DRIVER);
	    dsc.setUrl(JDBC_URL);
	    dsc.setUsername(JDBC_USER_NAME);
	    dsc.setPassword(JDBC_PASSOWRD);
	    return dsc;
	}
	private static PackageConfig getPackageConfig() {
	    PackageConfig pc = new PackageConfig();
	    pc.setParent(PACKAGE_NAME);
	    pc.setModuleName(MODULE_NAME);
	    return pc;
	}
	private static InjectionConfig getInjectionConfig() {
	    String templatePath = "/templates/mapper.xml.ftl";
	    List<FileOutConfig> focList = new ArrayList<>();
	    String projectPath = System.getProperty("user.dir");
	    focList.add(new FileOutConfig(templatePath) {
	        @Override
	        public String outputFile(TableInfo tableInfo) {
	            return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper"
	                    + StringPool.DOT_XML;
	        }
	    });
	    InjectionConfig cfg = new InjectionConfig() {
	        @Override
	        public void initMap() {
	            // to do nothing
	        }
	    };
	    cfg.setFileOutConfigList(focList);
	    return cfg;
	}
	private static TemplateConfig getTemplateConfig() {
	    TemplateConfig templateConfig = new TemplateConfig();
	    templateConfig.setXml(null);
	    return templateConfig;
	}
	private static StrategyConfig getStrategyConfig() {
	    StrategyConfig strategy = new StrategyConfig();
	    strategy.setNaming(NamingStrategy.underline_to_camel);
	    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
	    strategy.setEntityLombokModel(false);
	    strategy.setRestControllerStyle(true);
	    strategy.setInclude(TBL_NAMES.split(","));
	    strategy.setControllerMappingHyphenStyle(true);
	    strategy.setTablePrefix(TABLE_PREFIX);
	    return strategy;
	}
}