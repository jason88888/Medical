package com.taotaotech.gen;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成器入口类
 */
public class GenRunner {
    public static void main(String[] args) throws IOException, TemplateException {

        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        Configuration cfg = new Configuration();
        // 指定模板文件从何处加载的数据源，这里设置成一个文件目录。
        cfg.setDirectoryForTemplateLoading(
                new File(path + "tmpl/"));
        // 指定模板如何检索数据模型，这是一个高级的主题了…
        // 但先可以这么来用：
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        // 创建根哈希表
        Map root = new HashMap();
        root.put("user", "Big Joe");
        Map latest = new HashMap();
        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");

        Template temp = cfg.getTemplate("test.ftl");

        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
        out.flush();
    }
}
