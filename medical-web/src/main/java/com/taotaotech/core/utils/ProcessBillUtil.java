package com.taotaotech.core.utils;

import com.taotaotech.dto.ImportBill;
import com.taotaotech.dto.ImportPolicy;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 单据处理工具
 *
 * @author Cailin.Chen
 * @Date 15/8/28
 * @eMail cailin618@sina.com
 *
 */

public class ProcessBillUtil {

    public static boolean isValidBillExcel(HSSFRow row) {
        /*
         部门名称 药品编号 品名 规格 生产厂商 客户码 客户名称 开票日期 单位 数量 单价 批号 效期 单据号 商业类型
         */
        List<String> list = new ArrayList<String>();
        list.add("部门名称");
        list.add("药品编号");
        list.add("品名");
        list.add("规格");
        list.add("生产厂商");
        list.add("客户码");
        list.add("客户名称");
        list.add("开票日期");
        list.add("单位");
        list.add("数量");
        list.add("单价");
        list.add("批号");
        list.add("效期");
        list.add(" 单据号");
        list.add("商业类型");
        list.add("业务员姓名");
        list.add("业务员代码");
        list.add("二级代码");
        list.add("三级代码");
//        if (list.size() != row.getLastCellNum()) {
//            return false;
//        }
        for (int index = 0; index <= row.getLastCellNum()&& index <list.size(); index++) {
            String rowStr = getValue(row.getCell(index));
            String str = list.get(index);
            if (!rowStr.trim().equals(str.trim())) {
                return false;
            }
        }

        return true;
    }
    public static List<ImportBill> getImportBills(HSSFSheet hssfSheet) {
        List<ImportBill> list = new ArrayList<ImportBill>();
        // 循环行Row
        for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
            if (hssfRow != null) {
                ImportBill bill = new ImportBill();
                bill.setDepartmentName(getValue(hssfRow.getCell(0)));
                bill.setMedicineCode(getValue(hssfRow.getCell(1)));
                bill.setMedicineName(getValue(hssfRow.getCell(2)));
                bill.setMedicineSpecification(getValue(hssfRow.getCell(3)));
                bill.setManufacturerName(getValue(hssfRow.getCell(4)));
                bill.setClientCode(getValue(hssfRow.getCell(5)));

                bill.setClientName(getValue(hssfRow.getCell(6)));
                bill.setInvoiceDate(getValue(hssfRow.getCell(7)));
                bill.setUnits(getValue(hssfRow.getCell(8)));
                bill.setNumber(getValue(hssfRow.getCell(9)));
                bill.setPrice(getValue(hssfRow.getCell(10)));

                bill.setLotNumber(getValue(hssfRow.getCell(11)));
                bill.setValidityPeriod(getValue(hssfRow.getCell(12)));
                bill.setBillCode(getValue(hssfRow.getCell(13)));
                bill.setBusinessType(getValue(hssfRow.getCell(14)));

                bill.setSalesmanName(getValue(hssfRow.getCell(15)));
                bill.setSalesmanCode(getValue(hssfRow.getCell(16)));
                bill.setTwoLevelCode(getValue(hssfRow.getCell(17)));
                bill.setThreeLevelCode(getValue(hssfRow.getCell(18)));
                list.add(bill);
            }else {
                break;
            }
        }

        return  list;
    }

    private static String getValue(HSSFCell hssfCell) {
//        return hssfCell.toString();
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            if (HSSFDateUtil.isCellDateFormatted(hssfCell)) {
                //  如果是date类型则 ，获取该cell的date值
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                return sdf.format(HSSFDateUtil.getJavaDate(hssfCell.getNumericCellValue()));
            }
            DecimalFormat df = new DecimalFormat("#.#######");
            return df.format(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}
