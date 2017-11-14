package com.hzjytech.hades.desginpattern;

import android.os.Environment;
import android.text.TextUtils;

import java.io.File;

/**
 * Created by Hades on 2017/11/13.
 */

class SDCardStorage {
    private static final String TAG = "SDCardStorage";

    public final static String SD_DIR = Environment.getExternalStorageDirectory().getAbsolutePath();

    public static final String DEVICE_ID_FILE_PATH = SD_DIR + "/.bx/did.dt";

    public static void writeDataToSDCard(String path, String value) {
//        try {
//            if (isSdCardAvailable()) {
//                File file = new File(path);
//                if (FileUtil.existFile(file)) {
//                    FileUtil.stringToFile(file, value);
//                }
//            }
//        } catch (Exception e) {
//            LogUtil.error(TAG, e);
//        }
    }

    public static String readDataFromSDCard(String path) {
//        try {
//            if (isSdCardAvailable()) {
//                File file = new File(path);
//                if (FileUtil.existFile(file)) {
//                    return FileUtil.fileToString(file);
//                }
//            }
//        } catch (Exception e) {
//            LogUtil.error(TAG, e);
//        }
        return "";
    }

    public static boolean isSdCardAvailable() {
        String state = Environment.getExternalStorageState();
        return (!TextUtils.isEmpty(state) && state.equals("mounted") && Environment.getExternalStorageDirectory() != null);
    }
}
