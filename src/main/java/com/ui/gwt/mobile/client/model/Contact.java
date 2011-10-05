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

package com.ui.gwt.mobile.client.model;

import java.io.Serializable;

/**
 * Simple Contact Record
 *
 * @author rpack
 * @since 1.0
 */
public class Contact implements Serializable {

    private String name;
    private String picURL;
    private String phone;
    private String email;
    private String webAddr;
    private String addr1;
    private String addr2;
    private String country;

    public Contact() {
    }

    public Contact(String name, String picURL, String phone, String email, String webAddr, String addr1, String addr2, String country) {
        this.name = name;
        this.picURL = picURL;
        this.phone = phone;
        this.email = email;
        this.webAddr = webAddr;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getPicURL() {
        return picURL;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getWebAddr() {
        return webAddr;
    }

    public String getAddr1() {
        return addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public String getCountry() {
        return country;
    }
}
