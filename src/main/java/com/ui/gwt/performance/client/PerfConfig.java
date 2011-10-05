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

package com.ui.gwt.performance.client;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rpack
 * @since 1.0
 */
public class PerfConfig {

    public static final int UNLIMITED_QUEUE_SIZE = -1;

    protected static boolean logImmediately;
    private static final Set<String> enabledClasses = new HashSet<String>();
    private static boolean perfEnabled;
    private static int maxQueueSize = 100;
    protected static boolean enableAll;

    private PerfConfig() {
    }

    public static boolean isClassEnabled(final String classname) {
        return enableAll || enabledClasses.contains(classname);
    }

    public static boolean isPerfEnabled() {
        return perfEnabled;
    }

    public static void setEnableAllClasses(boolean enableAll) {
        PerfConfig.enableAll = enableAll;
    }

    public static int getMaxQueueSize() {
        return maxQueueSize;
    }

    public static void setMaxQueueSize(int size) {
        if (size >= -1) {
            maxQueueSize = size;
        } else {
            maxQueueSize = UNLIMITED_QUEUE_SIZE;
        }
    }

    public static void setPerfEnabled(final boolean isPerfEnabled) {
        perfEnabled = isPerfEnabled;
    }

    public static void registerClass(final List<String> strings) {
        enabledClasses.addAll(strings);
    }

    public static void setLogImmediately(boolean logImmediately) {
        PerfConfig.logImmediately = logImmediately;
    }
}
