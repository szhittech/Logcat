/*
 *
 *  *    Copyright (C) 2016 Amit Shekhar
 *  *    Copyright (C) 2011 Android Open Source Project
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */

package kale.debug.log.util;

import android.content.Context;
import android.net.wifi.WifiManager;

import kale.debug.log.server.LogcatService;

/**
 * Created by amitshekhar on 15/11/16.
 */

public final class NetworkUtils {

    public static String getWebLogcatAddress(Context context) {
        return getWebLogcatAddress(context, LogcatService.getPort());
    }

    public static String getWebLogcatAddress(Context context, int port) {
        return getPhoneLocalIp(context, port) + "/logcat.html";
    }

    public static String getPhoneLocalIp(Context context, int port) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
        final String formatedIpAddress = String
                .format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff), (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));
        return formatedIpAddress + ":" + port;
    }

}
