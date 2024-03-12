package ru.mts.dz7.beanpp;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import ru.mts.dz7.service.CreateAnimalServiceImpl;


@Configuration
public class OverrideBPP implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof CreateAnimalServiceImpl){
            CreateAnimalServiceImpl createAnimalServiceImpl = (CreateAnimalServiceImpl) bean;
            createAnimalServiceImpl.setType(createAnimalServiceImpl.getRandomAnimalType());
            return createAnimalServiceImpl;
        }
        return bean;
    }
}
