package org.rpcframework;

import org.rpcframework.parsexml.BeanDefineConfig;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/22      Create this file
 * </pre>
 */
public abstract class AbstractBeanFactory implements BeanFactory{

    private String configs;
    public Map<String, BeanDefineConfig> beanMap = new ConcurrentHashMap<>(256);
    public Map<String, Object> beanObjectMap = new ConcurrentHashMap<>(256);

    public AbstractBeanFactory(String configs) {
        this.configs = configs;
    }

    @Override
    public void registerBeanBeanDefinition(String name, BeanDefineConfig beanDefineConfig) throws Exception {
        beanMap.put(name,beanDefineConfig);
    }

    public abstract void doCreateBean();

    public String getConfigs() {
        return configs;
    }
}
