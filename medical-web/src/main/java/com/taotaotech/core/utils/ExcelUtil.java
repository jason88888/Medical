package com.taotaotech.core.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Cailin.Chen
 * @Date 15/10/8
 * @eMail cailin618@sina.com
 */

public class ExcelUtil {

    public static String getValue(HSSFCell hssfCell) {
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


    public static boolean isValidPurchaseExcel(List<String> list,HSSFRow row) {

        for (int index = 0; index <= row.getLastCellNum()&& index <list.size(); index++) {
            String rowStr = getValue(row.getCell(index));
            String str = list.get(index);
            if (!rowStr.trim().equals(str.trim())) {
                return false;
            }
        }

        return true;
    }
}
