package com.springtest.demospringproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@RestController
@RequestMapping("/springtest/api/")
public class HostNameResource {

    private static final Logger log = LogManager.getLogger(HostNameResource.class);

    @GetMapping("/hostname")
    public String getHostName(){
        InetAddress ip;
        String hostname = null;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            log.info("Hostname:{}" ,hostname);
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
        return hostname;
    }

    @GetMapping("/timestamp")
    public Date getTimestamp() {
        Date date = new Date();
        log.info("Hostname:{}", date);
        return date;
    }
}
