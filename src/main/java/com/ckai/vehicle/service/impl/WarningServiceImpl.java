package com.ckai.vehicle.service.impl;

import com.ckai.vehicle.domain.VehicleInfo;
import com.ckai.vehicle.dto.warning.SignalData;
import com.ckai.vehicle.dto.warning.WarningDTO;
import com.ckai.vehicle.dto.warning.WarningJson;
import com.ckai.vehicle.mapper.VehicleInfoMapper;
import com.ckai.vehicle.mapper.WarningRuleMapper;
import com.ckai.vehicle.service.VehicleService;
import com.ckai.vehicle.service.WarningService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarningServiceImpl implements WarningService {


    @Autowired
    private VehicleInfoMapper vehicleInfoMapper;
    @Autowired
    private WarningRuleMapper warningRuleMapper;


    @Override
    public List<WarningDTO> processWarnData(List<WarningJson> warningJson) {
        List<WarningDTO> results = new ArrayList<>();
        for (WarningJson data : warningJson){
            System.out.println( data);
            data.setSignalData(data.getSignal());
            SignalData signal = data.getSignalData();
            String carVid = data.getCarVid();
            Integer warnId = data.getWarnId();

            Integer batteryType = vehicleInfoMapper.getBatteryTypeByVid(carVid);



            // 处理数据
            // 如果warnId为空，则同时处理电压和电流报警
            if (warnId == null) {
                results.add(new WarningDTO(
                        carVid,
                        batteryType,
                        1,
                        getWarnLevel(batteryType,1,signal.getMx(), signal.getMi())
                ));
                results.add(new WarningDTO(
                        carVid,
                        batteryType,
                        2,
                        getWarnLevel(batteryType,2,signal.getIx(), signal.getIi())
                ));

            }else {
                // 处理Mx、Mi信号（电压差报警）
                if (signal.getMx() != null && signal.getMi() != null) {
                    results.add(new WarningDTO(
                            carVid,
                            batteryType,
                            warnId,
                            getWarnLevel(batteryType, warnId, signal.getMx(), signal.getMi())
                    ));
                }

                // 处理Ix、Ii信号（电流差报警）
                if (signal.getIx() != null && signal.getIi() != null) {
                    results.add(new WarningDTO(
                            carVid,
                            batteryType,
                            warnId,
                            getWarnLevel(batteryType, warnId, signal.getIx(), signal.getIi())
                    ));
                }
            }
        }

        return results;
    }


    public Integer getWarnLevel(Integer batteryType, Integer ruleId,Double x, Double i) {
        /**
         * warnId 为ruleId ，根据ruleId和batteryType查询出对应的报警等级，并计算mx-mi为flag，
         * 根据flag再返回的报警区间，返回warningLevel
          */
        //定义flag double(5,2)

        double flag = x - i;
        // System.out.println("flag:"+flag);
        return warningRuleMapper.getLevel(batteryType,ruleId,flag);

    }

}
