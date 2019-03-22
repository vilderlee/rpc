package org.rpcframework;

import org.rpcframework.parsexml.BeanDefineConfig;
import org.rpcframework.parsexml.XmlReader;

import java.lang.reflect.Field;
import java.util.Set;

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
public class Context extends AbstractBeanFactory {

    public Context(String configs) throws Exception {
        super(configs);
        refresh();
    }

    public void refresh() throws Exception {
        //1. 生成xml解析器
        XmlReader xmlReader = new XmlReader(this);
        xmlReader.loadBeanDefine();

        //2. 通过BeanFactory生成bean
        if (xmlReader.getRegistry().size() != 0) {
            xmlReader.getRegistry().forEach((id, beanDefine) -> {
                try {
                    registerBeanBeanDefinition((String) id, (BeanDefineConfig) beanDefine);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        //3. 实例化Bean对象
        doCreateBean();

    }

    @Override public void doCreateBean() {
        beanMap.forEach((name, bean) -> {
            String className = bean.getClassName();
            try {
                Class clz = Class.forName(className);
                Object o = clz.newInstance();
                beanObjectMap.put(name, o);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        });
    }

    @Override public Object getBean(String name) throws Exception {
        Object o = beanObjectMap.get(name);
        if (o == null) {
            throw new Exception("没有该对象");
        }
        Set<BeanDefineConfig.Property> properties = beanMap.get(name).getProperties();
        if (!properties.isEmpty()) {

            properties.forEach(property -> {
                try {
                    Field field = o.getClass().getDeclaredField(property.getName());
                    field.setAccessible(true);
                    field.set(o, property.getValue());

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });

        }
        return o;
    }
}
