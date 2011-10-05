/*
 * Copyright 2011 Richard Pack
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.ui.gwt.mobile.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.ui.gwt.mobile.client.model.Contact;

import java.util.ArrayList;

/**
 * @author rpack
 * @since 1.0
 */
@RemoteServiceRelativePath("mobileService")
public interface MobileRPCService extends RemoteService {

    ArrayList<Contact> getContacts();

    /**
     * Defer the init of INSTANCE from clinit time
     *
     * Use MobileRPCService.App.getInstance() to access static instance of mobileServiceAsync
     */
    public static class App {
        private static final MobileRPCServiceAsync INSTANCE = GWT.create(MobileRPCService.class);

        private App() {
        }

        public static synchronized MobileRPCServiceAsync getInstance() {
            return INSTANCE;
        }
    }
}