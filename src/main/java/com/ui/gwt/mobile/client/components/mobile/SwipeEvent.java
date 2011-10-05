/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ui.gwt.mobile.client.components.mobile;

import com.google.gwt.user.client.Event;


public class SwipeEvent {

    public enum Type {Vertical, Horizontal}

    private final Type type;
    private final Event nativeEvent;
    private final double speed;
    private boolean stopPropagation = false;

    public SwipeEvent(Event nativeEvent, Type type, double speed) {
        this.nativeEvent = nativeEvent;
        this.type = type;
        this.speed = speed;
    }

    public void stopPropagation() {
        nativeEvent.stopPropagation();
        stopPropagation = true;
    }

    public boolean getStopPropagation() {
        return stopPropagation;
    }

    public double getSpeed() {
        return speed;
    }

    public Event getNativeEvent() {
        return nativeEvent;
    }

    public void dispatch(SwipeEventsHandler handler) {
        switch (type) {
            case Vertical:
                handler.onSwipeVertical(this);
                break;
            case Horizontal:
                handler.onSwipeHorizontal(this);
        }
    }
}
