package com.hzjytech.hades.desginpattern;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.util.UUID;

/**
 * Created by Hades on 2017/11/13.
 */

public class DeviceIdManager {

    private static final String TAG = "DeviceIdManager";

    private static final String INVALID_DEVICE_ID = "000000000000000";

    private static final String INVALID_BLUETOOTH_ADDRESS = "02:00:00:00:00:00";

    private static final String INVALID_ANDROID_ID = "9774d56d682e549c";

    private static volatile String sDeviceDigest;

    public static String getDeviceID() {
        // 双重校验锁
        if (sDeviceDigest == null) {
            synchronized (DeviceIdManager.class){
                if(sDeviceDigest == null){
//                    sDeviceDigest = loadDeviceID();
                }
            }
        }

        return sDeviceDigest;
    }

    /**
     * 加载设备ID <br/>
     * 先从应用目录的文件加载，若为空，尝试从SD卡加载；
     * 如果还是为空，则构造一个设备ID，然后写入SD卡；
     * 无论设备ID是从SD卡加载出来还是构造生成，最终都写入应用目录的文件。
     * @return 设备ID
     */
//    private static String loadDeviceID(){
//        String deviceID = GlobalData.getString(GlobalData.Keys.DEVICE_ID);
//        if(TextUtils.isEmpty(deviceID)){
//            deviceID = SDCardStorage.readDataFromSDCard(SDCardStorage.DEVICE_ID_FILE_PATH);
//            if(TextUtils.isEmpty(deviceID)){
//                deviceID = generateDeviceID();
//                SDCardStorage.writeDataToSDCard(SDCardStorage.DEVICE_ID_FILE_PATH, deviceID);
//            }
//            GlobalData.putString(GlobalData.Keys.DEVICE_ID, deviceID);
//        }
//        return deviceID;
//    }

    /**
     * 生成设备ID <br/>
     * 优先根据deviceID，蓝牙地址，SERIAL，AndroidID拼接设备ID；
     * 以上唯一标识，凑够两个即可，如果凑不足，则加上UUID；
     * 拼接之后，计算其MD5, 并用base64编码。
     * @return 设备ID
     */
    private static String generateDeviceID(Context context ){
        StringBuilder sb = new StringBuilder(32);
        for (int c = 0, i = 0; c < 2 && i < 5; i++) {
            String id = getID(context, i);
            if (!TextUtils.isEmpty(id)) {
                if(c > 0){
                    sb.append('|');
                }
                sb.append(id);
                c++;
            }
        }

        if(sb.length() == 0){
            throw new RuntimeException("can not get device id");
        }

        return DigestUtil.getMD5(sb.toString());
    }

    public static String getID(Context context, int i) {
        switch (i) {
//            case 0:
//                return getDeviceId(context);
            case 1:
                return getBlueToothAddress(context);
            case 2:
                return getDeviceSerial();
            case 3:
                return getAndroidID(context);
            case 4:
                return getUUID();
            default:
                return "";
        }
    }

    private static String getDeviceId(Context context) {
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                String deviceId = telephonyManager.getDeviceId();
                if (!TextUtils.isEmpty(deviceId) && !INVALID_DEVICE_ID.equals(deviceId)) {
                    return deviceId;
                }
            } catch (Exception ignore) {
            }
        }
        return "";
    }

    private static String getBlueToothAddress(Context context){
        if (context != null) {
            try {
                String bluetoothAddress = Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
                if (!TextUtils.isEmpty(bluetoothAddress) && !INVALID_BLUETOOTH_ADDRESS.equals(bluetoothAddress)) {
                    return bluetoothAddress;
                }
            }catch (Exception ignore){
            }
        }
        return "";
    }

    private static String getDeviceSerial() {
        if (!TextUtils.isEmpty(Build.SERIAL) && !Build.UNKNOWN.equals(Build.SERIAL)) {
            return Build.SERIAL;
        }
        return "";
    }

    private static String getAndroidID(Context context) {
        if (context != null) {
            String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            if (!TextUtils.isEmpty(androidId) && !INVALID_ANDROID_ID.equals(androidId)) {
                return androidId;
            }
        }
        return "";
    }

    private static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
