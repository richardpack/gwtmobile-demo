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

package com.ui.gwt.mobile.client.resources;

import com.google.gwt.core.client.GWT;

/**
 * @author rpack
 * @since 1.0
 */
public interface Messages extends com.google.gwt.i18n.client.Messages {

    public static final Messages INSTANCE = GWT.create(Messages.class);

    @Key("detail.empty")
    String detailEmpty();

    @Key("list.loading")
    String listLoading();
}
