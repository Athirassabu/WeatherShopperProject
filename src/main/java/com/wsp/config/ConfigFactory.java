package com.wsp.config;

public final class ConfigFactory { //no one can extend this

    private ConfigFactory(){}

    public static FrameworkConfig getConfig(){
        return org.aeonbits.owner.ConfigFactory.create(FrameworkConfig.class);
    }
}
