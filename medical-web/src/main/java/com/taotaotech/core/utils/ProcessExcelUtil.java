package com.taotaotech.core.utils;

import com.taotaotech.dto.policy.ImportPolicy;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cailin.Chen
 * @Date 15/8/28
 * @eMail cailin618@sina.com
 */

public class ProcessExcelUtil {

    public static boolean isValidPolicyExcel(HSSFRow row) {
        /*
         药品编号 品名 规格 单位 生产厂商 单价 所属区域 销售模式 月份 业务员姓名 业务员代码 业务员政策
         二级代码 二级政策 三级代码 三级政策 临床政策 厂家政策 附加政策1 附加政策2 附加政策3 客户码 客户名称
         */
        List<String> list = new ArrayList<String>();
        list.add("药品编号");
        list.add("品名");
        list.add("规格");
        list.add("生产厂商");
        list.add("单价");
        list.add("所属区域");
        list.add("销售模式");
        list.add("月份");
        list.add("业务员姓名");
        list.add("业务员代码");
        list.add("业务员政策");
        list.add("二级代码");
        list.add("二级政策");
        list.add("三级代码");
        list.add("三级政策");
        list.add("临床政策");
        list.add("厂家政策");
        list.add("附加政策1");
        list.add("附加政策2");
        list.add("附加政策3");
        list.add("客户码");
        list.add("客户名称");
        if (list.size() != row.getLastCellNum()) {
            return false;
        }
        for (int index = 0; index <= row.getLastCellNum(); index++) {
            if (!row.getCell(index).equals(list.get(index))) {
                return false;
            }
        }

        return true;
    }
    public static List<ImportPolicy> getImportPolicys(HSSFSheet hssfSheet) {
        List<ImportPolicy> list = new ArrayList<ImportPolicy>();
        // 循环行Row
        for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
            if (hssfRow != null) {
                ImportPolicy policy = new ImportPolicy();
                policy.setMedicineCode(getValue(hssfRow.getCell(0)));
                policy.setMedicineName(getValue(hssfRow.getCell(1)));
                policy.setMedicineSpecification(getValue(hssfRow.getCell(2)));
                policy.setManufacturerName(getValue(hssfRow.getCell(3)));
                policy.setPrice(getValue(hssfRow.getCell(4)));

                policy.setRegionalName(getValue(hssfRow.getCell(5)));
                policy.setSaleMode(getValue(hssfRow.getCell(6)));
                policy.setMonth(getValue(hssfRow.getCell(7)));
                policy.setSalesmanName(getValue(hssfRow.getCell(8)));
                policy.setSalesmanCode(getValue(hssfRow.getCell(9)));

                policy.setSalesmanPolicy(getValue(hssfRow.getCell(10)));
                policy.setTwoLevelCode(getValue(hssfRow.getCell(11)));
                policy.setTwoLevelPolicy(getValue(hssfRow.getCell(12)));
                policy.setThreeLevelCode(getValue(hssfRow.getCell(13)));
                policy.setThreeLevelPolicy(getValue(hssfRow.getCell(14)));

                policy.setClinicalPolicy(getValue(hssfRow.getCell(15)));
                policy.setManufacturerPolicy(getValue(hssfRow.getCell(16)));
                policy.setAddPolicy1(getValue(hssfRow.getCell(17)));
                policy.setAddPolicy2(getValue(hssfRow.getCell(18)));
                policy.setAddPolicy3(getValue(hssfRow.getCell(19)));

                policy.setClientCode(getValue(hssfRow.getCell(20)));
                policy.setClientName(getValue(hssfRow.getCell(21)));
            }
        }

        return  list;
    }

    private static String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}
