package com.taotaotech.service.impl;

import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.core.utils.ProcessPolicylUtil;
import com.taotaotech.dao.AgentMapper;
import com.taotaotech.dao.MedicinePolicyMapper;
import com.taotaotech.dao.UserMapper;
import com.taotaotech.domain.Agent;
import com.taotaotech.domain.MedicinePolicy;
import com.taotaotech.domain.User;
import com.taotaotech.dto.ImportPolicy;
import com.taotaotech.service.IPolicyService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    MedicinePolicyMapper policyMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    AgentMapper agentMapper;

    @Transactional
    public ResponseResult parsePolicyTable(MultipartFile file) {
        ResponseResult result = new ResponseResult();

        if (!file.isEmpty()) {
            try {
                HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file.getInputStream());

                List<ImportPolicy> list = new ArrayList<ImportPolicy>();
                // 循环工作表Sheet
                for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {

                    HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);

                    if (hssfSheet == null || !ProcessPolicylUtil.isValidPolicyExcel(hssfSheet.getRow(0))) {
                        result.setSuccess(false);
                        result.setMsg("请选择有效的文件上传!");
                        continue;
                    }
                    List<ImportPolicy> importPolicies = ProcessPolicylUtil.getImportPolicys(hssfSheet);
                    for (int index = 0; index < importPolicies.size(); index++) {
                        ImportPolicy ip = importPolicies.get(index);
                        generateMedicinePolicy(ip);
//                        generateSalesman(ip);
//                        generateTwoLevelAgent(ip);
//                        generateThreeLevelAgent(ip);
                    }
                    break;
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

    @Transactional
    public DWZResponseResult parsePolicyTable2(MultipartFile file) {
        DWZResponseResult result = new DWZResponseResult();

        if (!file.isEmpty()) {
            try {
                HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file.getInputStream());

                List<ImportPolicy> list = new ArrayList<ImportPolicy>();
                // 循环工作表Sheet
                for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {

                    HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);

                    if (hssfSheet == null || !ProcessPolicylUtil.isValidPolicyExcel(hssfSheet.getRow(0))) {
                        result.setStatusCode("300");
                        result.setMessage("请选择有效的文件上传!");
                        continue;
                    }
                    List<ImportPolicy> importPolicies = ProcessPolicylUtil.getImportPolicys(hssfSheet);
                    for (int index = 0; index < importPolicies.size(); index++) {
                        ImportPolicy ip = importPolicies.get(index);
                        generateMedicinePolicy(ip);
//                        generateSalesman(ip);
//                        generateTwoLevelAgent(ip);
//                        generateThreeLevelAgent(ip);
                    }
                    break;
                }
                list.size();

                result.setMessage("导入成功！");
                result.setCallbackType("closeCurrent");
                result.setNavTabId("policy_list");
            } catch (Exception e) {
                result.setStatusCode("300");
                result.setMessage("异常情况:" + e.getMessage());
            }
        } else {
            result.setStatusCode("300");
            result.setMessage("文件不能为空，请选择文件上传!");
        }
        return result;
    }

    @Override
    public List<MedicinePolicy> findMedicinePolicyList() {
        return policyMapper.findMedicinePolicyList();
    }


    private Boolean generateMedicinePolicy( ImportPolicy ip ){
        if (ip.getClientCode()==null || ip.getClientCode().equals("") ||
            ip.getMedicineCode()==null || ip.getMedicineCode().equals("") ||
            ip.getMonth()==null || ip.getMonth().equals("") ){
            return false;
        }
        if (!policyMapper.existByMonthAndClientAndMedicine(ip.getClientCode(), ip.getMedicineCode(), ip.getMonth())){

            MedicinePolicy policy = new MedicinePolicy();
            policy.setRegional(ip.getRegionalName());
            policy.setMonth(ip.getMonth());
            policy.setMedicineCode(ip.getMedicineCode());
            policy.setClientCode(ip.getClientCode());

            policy.setSalesmanPolicy(Float.parseFloat(ip.getSalesmanPolicy()));
            policy.setClinicalPolicy(Float.parseFloat(ip.getClinicalPolicy()));
            policy.setManufacturerPolicy(Float.parseFloat(ip.getManufacturerPolicy()));

            policy.setTwoLevelPolicy(Float.parseFloat(ip.getTwoLevelPolicy()));
            policy.setThreeLevelPolicy(Float.parseFloat(ip.getThreeLevelPolicy()));

            policy.setAddPolicy1(Float.parseFloat(ip.getAddPolicy1()));
            policy.setAddPolicy2(Float.parseFloat(ip.getAddPolicy2()));
            policy.setAddPolicy3(Float.parseFloat(ip.getAddPolicy3()));
            policyMapper.insertSelective(policy);
            return true;
        }
        return false;
    }

//    private Boolean generateSalesman(ImportPolicy ip){
//        if (ip.getSalesmanName()==null || ip.getSalesmanName().equals("") ||
//            ip.getSalesmanCode()==null || ip.getSalesmanCode().equals("") ){
//            return false;
//        }
//        if (!userMapper.existBySalesmanCode(ip.getSalesmanCode())){
//            User user = new User();
//            user.setUsername(ip.getSalesmanName());
//            user.setCode(ip.getSalesmanCode());
//            user.setPassword("000000");
//            user.setRole((byte) 2);
//            userMapper.insertSelective(user);
//            return true;
//        }
//
//        return false;
//    }
//
//
//    private Boolean generateTwoLevelAgent(ImportPolicy ip){
//        if (ip.getTwoLevelCode()==null || ip.getTwoLevelCode().equals("")){
//            return false;
//        }
//        Agent agent = new Agent();
//        agent.setName(ip.getTwoLevelCode());
//        agent.setCode(ip.getTwoLevelCode());
//        agent.setLevel("2");
//        return generateAgent(agent);
//    }
//
//    private Boolean generateThreeLevelAgent(ImportPolicy ip){
//        if (ip.getThreeLevelCode()==null || ip.getThreeLevelCode().equals("")){
//            return false;
//        }
//        Agent agent = new Agent();
//        agent.setName(ip.getThreeLevelCode());
//        agent.setCode(ip.getThreeLevelCode());
//        agent.setLevel("3");
//        return generateAgent(agent);
//    }
//
//    private Boolean generateAgent(Agent agent ){
//
//        if (!agentMapper.existByAgentCode(agent.getCode())){
//            agentMapper.insertSelective(agent);
//            return true;
//        }
//
//        return false;
//    }

}
