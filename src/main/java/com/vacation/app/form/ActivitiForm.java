package com.vacation.app.form;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "activiti.form")
@PropertySource("classpath:i18n/messages.properties")
public class ActivitiForm implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
	
	public ActivitiForm() {
		System.out.println("【构造器】调用ActivitiForm的构造器实例化");
	}
	public String wouldlike;

	public String getWouldlike() {
		return wouldlike;
	}

	public void setWouldlike(String wouldlike) {
		System.out.println("【注入属性】注入属性wouldlike");
		this.wouldlike = wouldlike;
	}

	@Override
	public void setBeanName(String arg0) {
		 System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
		
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		 System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
		
	}
	
	// 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }
     
    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
       System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }
}
