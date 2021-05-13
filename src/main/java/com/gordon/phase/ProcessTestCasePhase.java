package com.gordon.phase;

import com.gordon.bean.TestCase;
import com.gordon.framework.context.GlobalTestContext;
import com.gordon.utils.CSVUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;
import org.testng.ITestContext;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessTestCasePhase extends AbstractPhase{


    public List<Object[]> processFromCSV(String csvName, String caseId, ITestContext iTestContext){
        List<Object[]> list = CSVUtil.getDataFromCSV(csvName, TestCase.class);
        list.stream().filter(Objects ->{
            Object object=Objects[0];
            if(object instanceof TestCase){
                TestCase testCase = (TestCase) object;
                if(BooleanUtils.isFalse(testCase.getEnable())){

                    return false;
                }
                //组装请求参数和返回参数对象类型
                fillTestCase(testCase);

            }
            return false;
        }).collect(Collectors.toList());

        return list;
    }

    private void fillTestCase(TestCase testCase) {
        try {
            testCase.setInterFaceName(getFullInterfaceName(testCase));
            testCase.setRequestParamtType(getFacadeRequestType(testCase));
            testCase.setResponseParamType(getFacadeResponse(testCase));
        }catch (Exception e){

        }
    }

    private String getFacadeResponse(TestCase testCase) throws ClassNotFoundException {
        Class<?> classFacade = Class.forName(testCase.getInterFaceName());
        Method[] methods = classFacade.getDeclaredMethods();
        for (Method method:methods){
            if(method.getName().equals(testCase.getMethodNama())){
                return method.getReturnType().getName();
            }
        }
        return null;
    }

    private String getFacadeRequestType(TestCase testCase) throws ClassNotFoundException {
        Class<?> classFacade = Class.forName(testCase.getInterFaceName());
        Method[] methods = classFacade.getDeclaredMethods();
        for(Method method:methods){
            if (method.getName().equals(testCase.getMethodNama())){
                if(ArrayUtils.isEmpty(method.getParameterTypes())){
                    return  null;
                }
                return method.getParameterTypes()[0].getName();
            }
        }
        return null;
    }

    private String getFullInterfaceName(TestCase testCase) {
        for(String facadePage :frameworkConfigBean.getFacadePackageList()){
            if (testCase.getInterFaceName().contains(facadePage)||testCase.getInterFaceName().contains(".")){
                return testCase.getInterFaceName();
            }
        }
        return GlobalTestContext.FACADE_INTERFACE_NAME_MAP.get(testCase.getInterFaceName());
    }
}
