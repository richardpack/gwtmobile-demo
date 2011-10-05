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

import com.google.gwt.core.client.Duration;

/**
 * @author rpack
 * @since 1.0
 */
public final class PerfTimer {

    private static final PerfTimer DEFAULT_DISABLED_TIMER = new PerfTimer();

    private PerfRecord record;
    private Duration duration;

    private PerfTimer() {
    }

    private PerfTimer(Object o, String methodName) {
        record = new PerfRecord(o.getClass().getName(), methodName);
        SpeedTracer.mark(record.toString() + ": start");
        duration = new Duration();
    }

    private PerfTimer(Class c, String methodName) {
        record = new PerfRecord(c.getName(), methodName);
        SpeedTracer.mark(record.toString() + ": start");
        duration = new Duration();
    }

    public static PerfTimer get(Object o, String methodName) {
        if (PerfConfig.isPerfEnabled() && PerfConfig.isClassEnabled(o.getClass().getName())) {
            return new PerfTimer(o, methodName);
        } else
            return DEFAULT_DISABLED_TIMER;
    }

    public static PerfTimer get(Class c, String methodName) {
        if (PerfConfig.isPerfEnabled() && PerfConfig.isClassEnabled(c.getName())) {
            return new PerfTimer(c, methodName);
        } else
            return DEFAULT_DISABLED_TIMER;
    }

    public void end() {
        if (record != null) {
            record.setDuration(duration.elapsedMillis());
            SpeedTracer.mark(record.toString() + ": end");
            if (PerfConfig.logImmediately) {
                String s = new StringBuilder().append("PerfData: ").append(record.getClassName()).append("#").append(record.getMethodName()).append(" : ").append(record.getDuration()).append("ms").toString();
                LogFactory.LOG.perf(s);
            }
            addNativePerfMark(record.toString(), record.getDuration());
        }
    }

    public native void addNativePerfMark(String name, int time) /*-{
        if (!$wnd.PerfRecords) {
            $wnd.PerfRecords = {};
        }
        $wnd.PerfRecords[name] = time;
    }-*/;

}
