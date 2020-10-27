package com.hefeng.guli.service.edu;

//import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.util.ArrayList;

public class CodeGenerator {

    @Test
    public void genCode(){
        String prefix = "db20_";
        String moduleName = "edu";

        AutoGenerator mpg = new AutoGenerator();

        GlobalConfig gc = new GlobalConfig();

        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("Michael");
        gc.setOpen(false);

        gc.setServiceName("%sService");
        gc.setIdType(IdType.ASSIGN_ID);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/" + prefix + "guli_" + moduleName + "?serverTimezone=GMT%2b8");

        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("12345678");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent("com.hefeng.guli.service");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix(moduleName + "_");

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);

        strategy.setLogicDeleteFieldName("is_deleted");
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);

        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);

        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);

        strategy.setTableFillList(tableFills);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);

        strategy.setSuperEntityClass("com.hefeng.guli.service.base.model.BaseEntity");
        strategy.setSuperEntityColumns("id", "gmt_create", "gmt_modified");
        mpg.setStrategy(strategy);

        mpg.execute();
    }
}
