package com.springmvc;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

public class SpringApplicationContext implements ApplicationContextAware {
    private ApplicationContext context;

    private volatile static SpringApplicationContext springContextUtil = null;

    public SpringApplicationContext() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringApplicationContext.getInstance().setContext(applicationContext);
    }

    /**
     * 初始化单例类
     *
     * @return
     */
    public static SpringApplicationContext getInstance() {
        if (springContextUtil == null) {
            synchronized (SpringApplicationContext.class) {
                if (springContextUtil == null) {
                    springContextUtil = new SpringApplicationContext();
                }
            }
        }
        return springContextUtil;
    }

    private void setContext(final ApplicationContext pContext) {
        this.context = pContext;
    }

    private ApplicationContext getContext() {
        return context;
    }

    /**
     * 获取ApplicationContext
     *
     * @return
     */
    public static ApplicationContext getCtx() {
        return SpringApplicationContext.getInstance().getContext();
    }

    /**
     * 根据类名获取bean
     *
     * @param beanType
     * @return
     */
    public static <T> T getBean(Class<T> beanType) {
        T t = getCtx().getBean(beanType);
        return t;
    }

    /**
     * 根据beanId获取bean
     *
     * @param beanId
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanId) {
        T t = (T) getCtx().getBean(beanId);
        return t;
    }
}
