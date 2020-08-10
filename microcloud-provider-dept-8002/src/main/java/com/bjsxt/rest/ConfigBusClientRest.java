package com.bjsxt.rest;

import com.bjsxt.config.InfoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigBusClientRest {

    @Autowired
    private InfoConfig infoConfig;

    @RequestMapping(value = "/config")
    public String getConfig(){
        return "【applicationName】:"+this.infoConfig.getAppName()
                +"、【companyName】:"+this.infoConfig.getCompanyName()
                +"、【applicationVersion】:"+this.infoConfig.getAppVersion();
    }

}
