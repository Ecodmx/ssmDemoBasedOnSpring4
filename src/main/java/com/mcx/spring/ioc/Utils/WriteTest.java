package com.mcx.spring.ioc.Utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.mcx.spring.ioc.pojo.Computer;
import com.mcx.spring.ioc.pojo.Home;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WriteTest {
    @Test
    public void writeExcel1() throws Exception {
        // 文件输出位置
        OutputStream out = new FileOutputStream("/Users/machangxu/Desktop/test.xlsx");

        ExcelWriter writer = EasyExcelFactory.getWriter(out);

        // 写仅有一个 Sheet 的 Excel 文件, 此场景较为通用
        Sheet sheet1 = new Sheet(1, 0, Home.class);

        // 第一个 sheet 名称
        sheet1.setSheetName("第一个sheet");

        // 写数据到 Writer 上下文中
        // 入参1: 创建要写入的模型数据
        // 入参2: 要写入的目标 sheet
        writer.write(createModelList(), sheet1);

        // 将上下文中的最终 outputStream 写入到指定文件中
        writer.finish();

        // 关闭流
        out.close();
    }

    private List<? extends BaseRowModel> createModelList() {
        List<Home> homeList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Home home = Home.builder().homeName("easyExcel" + i).homeSize(String.valueOf(i)).build();
            homeList.add(home);
        }
        return homeList;

    }
}