package org.rpcframework;

import org.rpcframework.parsexml.BeanDefineConfig;

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
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    void registerBeanBeanDefinition(String name, BeanDefineConfig beanDefineConfig) throws Exception;
}
