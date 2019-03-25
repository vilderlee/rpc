package org.rpcframework.parsexml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.rpcframework.Context;
import org.rpcframework.util.StringUtils;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
public class XmlReader {

    private Context beanFactory;
    private Map<String, BeanDefineConfig> map = new ConcurrentHashMap<>();

    public XmlReader(Context context) {
        this.beanFactory = context;
    }

    private static final String ROOT_ELEMENT = "root";

    public void loadBeanDefine() throws DocumentException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(beanFactory.getConfigs());
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element rootElement = document.getRootElement();
        if (ROOT_ELEMENT.equals(rootElement.getQualifiedName())) {
            List<Element> elements = rootElement.elements();
            elements.forEach(element -> {
                String id = element.attributeValue(BeanDefineConfig.ID);
                if (!map.containsKey(id)) {
                    BeanDefineConfig beanDefineConfig = new BeanDefineConfig();
                    beanDefineConfig.setId(id);

                    String type = element.attributeValue(BeanDefineConfig.TYPE);
                    if (StringUtils.isEmpty(type)) {
                        beanDefineConfig.setType(element.attributeValue(BeanDefineConfig.TYPE_DEFAULT));
                    } else {
                        beanDefineConfig.setType(element.attributeValue(BeanDefineConfig.TYPE));
                    }

                    beanDefineConfig.setClassName(element.attributeValue(BeanDefineConfig.CLASS));
                    String scope = element.attributeValue(BeanDefineConfig.SCOPE);
                    if (StringUtils.isEmpty(scope)) {
                        beanDefineConfig.setScope(BeanDefineConfig.SINGLE);
                    } else {
                        beanDefineConfig.setScope(scope);
                    }
                    Set<BeanDefineConfig.Property> set = new HashSet<>();
                    if (element.elements().size() != 0) {
                        List<Element> properties = element.elements();
                        properties.forEach(propertyElement -> {
                            BeanDefineConfig.Property property = new BeanDefineConfig().new Property();
                            property.setName(propertyElement.attributeValue(BeanDefineConfig.KEY));
                            property.setValue(propertyElement.attributeValue(BeanDefineConfig.VALUE));
                            set.add(property);
                        });
                    }

                    beanDefineConfig.setProperties(set);
                    map.putIfAbsent(id, beanDefineConfig);
                }
            });
        }
    }

    public Map getRegistry() {
        return map;
    }
}
