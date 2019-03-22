package org.rpcframework.parsexml;

import java.util.Objects;
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
public class BeanDefineConfig {

    static final String ID = "id";
    static final String TYPE = "type";
    static final String CLASS = "class";
    static final String SCOPE = "scope";
    static final String SINGLE = "single";
    static final String KEY = "key";
    static final String VALUE = "value";

    private String id;
    private String className;
    private String scope;
    private String type;
    private Set<Property> properties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public class Property {
        String name;
        String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Property property = (Property) o;
            return Objects.equals(name, property.name) && Objects.equals(value, property.value);
        }

        @Override public int hashCode() {
            return Objects.hash(name, value);
        }
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BeanDefineConfig that = (BeanDefineConfig) o;
        return Objects.equals(id, that.id) && Objects.equals(className, that.className) && Objects
                .equals(scope, that.scope) && Objects.equals(type, that.type) && Objects
                .equals(properties, that.properties);
    }

    @Override public int hashCode() {
        return Objects.hash(id, className, scope, type, properties);
    }
}
