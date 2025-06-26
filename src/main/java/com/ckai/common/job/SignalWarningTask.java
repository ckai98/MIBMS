package com.ckai.common.job;

import com.ckai.common.mq.Provider;
import com.ckai.vehicle.domain.BatterySignals;
import com.ckai.vehicle.dto.warning.WarningDTO;
import com.ckai.vehicle.dto.warning.WarningJson;
import com.ckai.vehicle.mapper.BatterySignalMapper;
import com.ckai.vehicle.service.BatterySignalService;
import com.ckai.vehicle.service.WarningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class SignalWarningTask {

    @Autowired
    private BatterySignalService batterySignalService;

    @Autowired
    private WarningService warningService;

    @Autowired
    private Provider provider;


    @Scheduled(cron = "0 */1 * * * ?")
    public void scanSignalDataAndSendWarning(){
        log.info("开始处理数据");

        List<BatterySignals> batterySignals = batterySignalService.getRecentSignalReports(100);
        if (CollectionUtils.isEmpty(batterySignals)) return;
        for (BatterySignals batterySignal : batterySignals) {
            WarningJson warningJson = new WarningJson();
            warningJson.setCarVid(batterySignal.getVid());
            String signal = "{\"Mx\":" + batterySignal.getMx() + ",\"Mi\":" + batterySignal.getMi() + ",\"Ix\":" + batterySignal.getIx() + ",\"Ii\":"+batterySignal.getIi() + "}";
            warningJson.setSignal(signal);
            List<WarningJson> warningJsonList = new ArrayList<>();
            warningJsonList.add(warningJson);

            List<WarningDTO> warningDTOS = warningService.processWarnData(warningJsonList);
            // System.out.println(warningDTOS);
            for (WarningDTO warningDTO : warningDTOS){
                if (warningDTO.getWarnLevel() > 0) {
                    System.out.println(warningDTO);
                    provider.sendMsg("warn", warningDTO);
                }
            }
        }


    }
}
