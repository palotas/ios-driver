/*
 * Copyright 2012 ios-driver committers.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.uiautomation.ios.communication;

import org.uiautomation.ios.exceptions.IOSAutomationException;

public enum IOSDevice {


  iPhoneSimulator("iPhone Simulator"), iPadSimulator("iPad Simulator"), retina("iPhone (Retina)");


  // name from result of :
  // defaults read com.apple.iphonesimulator
  private final String name;

  private IOSDevice(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return getName();
  }


  public IOSDevice get(String s) {
    return iPadSimulator;
  }

  public static IOSDevice valueOf(Object o) {
    if (o instanceof IOSDevice) {
      return (IOSDevice) o;
    } else if (o instanceof String) {
      for (IOSDevice device : IOSDevice.values()) {
        if (device.name.equals(o)) {
          return device;
        }
      }
    }
    throw new IOSAutomationException("Cannot cast " + (o == null ? "null" : o.getClass())
        + " to IOSDevice");

  }

  public static IOSDevice getDefault() {
    return iPhoneSimulator;
  }
}
