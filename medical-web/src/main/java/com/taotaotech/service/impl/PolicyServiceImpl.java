package com.taotaotech.service.impl;

import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.core.utils.ProcessExcelUtil;
import com.taotaotech.dto.policy.ImportPolicy;
import com.taotaotech.service.IPolicyService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cailin.Chen
 * @Date 15/8/28
 * @eMail cailin618@sina.com
 */
@Service
public class PolicyServiceImpl implements IPolicyService {

    public ResponseResult parsePolicyTable(MultipartFile file) {
        ResponseResult result = new ResponseResult();

        if (!file.isEmpty()) {
            try {
//                ReadExcel.read(file.getInputStream());
                HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file.getInputStream());

                List<ImportPolicy> list = new ArrayList<ImportPolicy>();
                // 循环工作表Sheet
                for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {

                    HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);

                    if (hssfSheet == null || !ProcessExcelUtil.isValidPolicyExcel(hssfSheet.getRow(0))) {
                        result.setSuccess(false);
                        result.setMsg("请选择有效的文件上传!");
                        continue;
                    }
                    List<ImportPolicy> importPolicies = ProcessExcelUtil.getImportPolicys(hssfSheet);

                }
                list.size();

            } catch (Exception e) {
                result.setSuccess(false);
                result.setMsg("异常情况:" + e.getMessage());
            }
        } else {
            result.setSuccess(false);
            result.setMsg("文件不能为空，请选择文件上传!");
        }
        return result;
    }

    private Boolean policy(){
        return false;
    }
}
