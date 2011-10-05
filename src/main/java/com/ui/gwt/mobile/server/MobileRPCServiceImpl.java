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

package com.ui.gwt.mobile.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ui.gwt.mobile.client.MobileRPCService;
import com.ui.gwt.mobile.client.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rpack
 * @since 1.0
 */
public class MobileRPCServiceImpl extends RemoteServiceServlet implements MobileRPCService {

    private static final List<Contact> contacts;

    static {
        contacts = new ArrayList<Contact>(25);
        contacts.add(new Contact("Williams, David", "/avatar.jpg", "415.555.5555", "dwilliams@acme.com", "http://www.domain.com",
                                 "123 Main St", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Pack, Richard", "/avatar.jpg", "415.555.5555", "richard@acme.com", "http://www.domain.com",
                                 "1 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Smith, Nancy", "/avatar.jpg", "415.555.5555", "nancy@acme.com", "http://www.domain.com",
                                 "800 3rd St.", "San Francisco, CA 94107", "USA"));
        contacts.add(new Contact("Park, John", "/avatar.jpg", "415.555.5555", "john@acme.com", "http://www.domain.com",
                                 "522 Broadway", "New York, NY 94102", "USA"));
        contacts.add(new Contact("O'Connell, John", "/avatar.jpg", "415.555.5555", "johno@acme.com", "http://www.domain.com",
                                 "400 W 9th St", "Los Angeles, CA 90015", "USA"));
        contacts.add(new Contact("Murphy, Erin", "/avatar.jpg", "415.555.5555", "Erin@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Jackson, Tim", "/avatar.jpg", "415.555.5555", "tim@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Valero, Linda", "/avatar.jpg", "415.555.5555", "linda@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Patel, Kathy", "/avatar.jpg", "415.555.5555", "kpatel@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Monroe, Kevin", "/avatar.jpg", "415.555.5555", "kevin@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Schneider, Elena", "/avatar.jpg", "415.555.5555", "elena@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Parker, Fess", "/avatar.jpg", "415.555.5555", "nancy@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Smith, David", "/avatar.jpg", "415.555.5555", "nancy@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Green, Mark", "/avatar.jpg", "415.555.5555", "nancy@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Glebow, Philip", "/avatar.jpg", "415.555.5555", "nancy@acme.com", "http://www.domain.com",
                                 "400 Chesnut St.", "San Francisco, CA 94133", "USA"));
        contacts.add(new Contact("Conway, Twitty", "/avatar.jpg", "415.555.5555", "nancy@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Griffin, Peter", "/avatar.jpg", "415.555.5555", "nancy@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Smith, Nancy", "/avatar.jpg", "415.555.5555", "nancy@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Smith, Nancy", "/avatar.jpg", "415.555.5555", "nancy@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Smith, Nancy", "/avatar.jpg", "415.555.5555", "nancy@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));
        contacts.add(new Contact("Smith, Nancy", "/avatar.jpg", "415.555.5555", "nancy@acme.com", "http://www.domain.com",
                                 "8331 Market St.", "San Francisco, CA 94102", "USA"));

    }

    @Override
    public ArrayList<Contact> getContacts() {
        //Force ArrayList type to keep RPCMap small
        return (ArrayList<Contact>) contacts;
    }

}