package com.mec.spring.aop.main;

import com.mec.spring.aop.objects.FileManager;
import com.mec.spring.aop.objects.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FilenameFilter;


public class Start {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        SomeService service = context.getBean("someService", SomeService.class);
//        double val = service.getDoubleValue();
//        service.getDoubleValueException();
        FileManager fileManager = context.getBean("fileManager",FileManager.class);
        fileManager.getExtensionList("/Volumes/Hdd/Android/sdk/sources/android-29/jsr166");
        fileManager.getExtensionCount("/Volumes/Hdd/Android/sdk/sources/android-29/jsr166");
        fileManager.getExtensionList("/Users/mec/Documents");
        fileManager.getExtensionCount("/Users/mec/Documents");
        //    ((ConfigurableApplicationContext) context).close();// закрытие контекста вручную

    }
}
