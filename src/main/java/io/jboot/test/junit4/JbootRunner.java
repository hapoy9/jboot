/**
 * Copyright (c) 2015-2021, Michael Yang 杨福海 (fuhai999@gmail.com).
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
package io.jboot.test.junit4;

import com.jfinal.aop.Aop;
import io.jboot.test.MockApp;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

public class JbootRunner extends BlockJUnit4ClassRunner {

    public JbootRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected Object createTest() throws Exception {
        Object ret = super.createTest();
        return Aop.inject(ret);
    }

    @Override
    public void run(RunNotifier notifier) {
        MockApp.getInstance().start();
        super.run(notifier);
        MockApp.getInstance().stop();
    }


    @Override
    protected Statement methodInvoker(FrameworkMethod method, Object test) {
        return super.methodInvoker(method, test);
    }


}