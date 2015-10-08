package com.taotaotech.core.utils;

import com.taotaotech.dto.ImportBill;
import com.taotaotech.dto.ImportPurchasement;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cailin.Chen
 * @Date 15/10/8
 * @eMail cailin618@sina.com
 */

public class ProcessPurchaseUtil {

    public static boolean isValidPurchaseExcel(HSSFRow row) {
        /*采购销售类别 采购付款年-月-日 采购付款年-月 采购入库年-月-日
        采购入库年-月 实际入库地点 采购申请单号 药品代码 药品编码 产品名称 生产厂家 规格 单位 装箱量 我司上家购货单位
        我司下家购货单位 打款分类 付款方式 购进数量 批号 有效期 采购单价 付款金额 业务流程及价 为所属客户 采购销售区域
        进项单价 进项金额 应付税 付税方式 付税年-月-日 付税年-月 发票号码 开票年-月-日 开票年-月 采购条目生成是否已核对*/
        List<String> list = new ArrayList<String>();
        list.add("采购销售类别");
        list.add("采购付款年-月-日");
        list.add("采购付款年-月");
        list.add("采购入库年-月-日");
        list.add("采购入库年-月");
        list.add("实际入库地点");
        list.add("采购申请单号");
        list.add("药品代码");
        list.add("药品编码");
        list.add("产品名称");
        list.add("生产厂家");
        list.add("规格");
        list.add("单位");
        list.add("装箱量");
        list.add("我司上家销货单位");
        list.add("我司或下家购货单位");
        list.add("打款分类");
        list.add("付款方式");
        list.add("购进数量");
        list.add("批号");
        list.add("有效期");
        list.add("采购单价");
        list.add("付款金额");
        list.add("业务流程及价");
        list.add("为所属客户");
        list.add("采购销售区域");
        list.add("进项单价");
        list.add("进项金额");
        list.add("应付税");
        list.add("付税方式");
        list.add("付税年-月-日");
        list.add("付税年-月");
        list.add("发票号码");
        list.add("开票年-月-日");
        list.add("开票年-月");
        list.add("采购条目生成是否已核对");
       return ExcelUtil.isValidPurchaseExcel(list,row);
    }


    public static List<ImportPurchasement> getImportPurchases(HSSFSheet hssfSheet) {

        List<ImportPurchasement> list = new ArrayList<ImportPurchasement>();
        // 循环行Row
        for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
            if (hssfRow != null) {
                ImportPurchasement purchasement = new ImportPurchasement();

                purchasement.setPurchaseSaleType(ExcelUtil.getValue(hssfRow.getCell(0)));
                purchasement.setPurchasePayDate(ExcelUtil.getValue(hssfRow.getCell(1)));
                purchasement.setPurchasePayYearAndMonth(ExcelUtil.getValue(hssfRow.getCell(2)));
                purchasement.setPurchaseStoreDate(ExcelUtil.getValue(hssfRow.getCell(3)));
                purchasement.setPurchaseStoreYearAndMonth(ExcelUtil.getValue(hssfRow.getCell(4)));
                purchasement.setActualStorePlace(ExcelUtil.getValue(hssfRow.getCell(5)));

                purchasement.setPurchaseSaleCode(ExcelUtil.getValue(hssfRow.getCell(6)));
                purchasement.setMedicineUniqueCode(ExcelUtil.getValue(hssfRow.getCell(7)));
                purchasement.setMedicineCode(ExcelUtil.getValue(hssfRow.getCell(8)));
                purchasement.setMedicineName(ExcelUtil.getValue(hssfRow.getCell(9)));
                purchasement.setManufacturerName(ExcelUtil.getValue(hssfRow.getCell(10)));

                purchasement.setSpecification(ExcelUtil.getValue(hssfRow.getCell(11)));
                purchasement.setUnits(ExcelUtil.getValue(hssfRow.getCell(12)));
                purchasement.setPackageNumber(Integer.parseInt(ExcelUtil.getValue(hssfRow.getCell(13))));
                purchasement.setSaleCompany(ExcelUtil.getValue(hssfRow.getCell(14)));

                purchasement.setBuyCompany(ExcelUtil.getValue(hssfRow.getCell(15)));
                purchasement.setPaymentCategory(ExcelUtil.getValue(hssfRow.getCell(16)));
                purchasement.setPaymentMode(ExcelUtil.getValue(hssfRow.getCell(17)));
                purchasement.setPurchaseNumber(Integer.parseInt(ExcelUtil.getValue(hssfRow.getCell(18))));
                purchasement.setLotNumber(ExcelUtil.getValue(hssfRow.getCell(19)));
                purchasement.setValidityPeriod(ExcelUtil.getValue(hssfRow.getCell(20)));
                purchasement.setPurchasePrice(ExcelUtil.getValue(hssfRow.getCell(21)));

                purchasement.setPaymentMoney(ExcelUtil.getValue(hssfRow.getCell(22)));
                purchasement.setWorkFlow(ExcelUtil.getValue(hssfRow.getCell(23)));
                purchasement.setClientName(ExcelUtil.getValue(hssfRow.getCell(24)));
                purchasement.setSaleArea(ExcelUtil.getValue(hssfRow.getCell(25)));
                purchasement.setPurchaseUnitPrice(ExcelUtil.getValue(hssfRow.getCell(26)));
                purchasement.setPurchaseMoney(ExcelUtil.getValue(hssfRow.getCell(27)));

                purchasement.setTax(ExcelUtil.getValue(hssfRow.getCell(28)));
                purchasement.setTaxPayMode(ExcelUtil.getValue(hssfRow.getCell(29)));
                purchasement.setTaxPayDate(ExcelUtil.getValue(hssfRow.getCell(30)));
                purchasement.setTaxPayYearAndMonth(ExcelUtil.getValue(hssfRow.getCell(31)));
                purchasement.setInvoiceNumber(ExcelUtil.getValue(hssfRow.getCell(32)));

                purchasement.setInvoiceDate(ExcelUtil.getValue(hssfRow.getCell(33)));
                purchasement.setInvoiceYearAndMonth(ExcelUtil.getValue(hssfRow.getCell(34)));
                purchasement.setCheck(ExcelUtil.getValue(hssfRow.getCell(35)));
                list.add(purchasement);
            }else {
                break;
            }
        }

        return  list;
    }


}
