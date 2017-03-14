//
// Created by Administrator on 2017/2/23.
//
#include <jni.h>

JNIEXPORT jstring JNICALL Java_cpf_com_testlauncher_test_ndk_TestNDK_getStringFromNative(JNIEnv *env, jobject instance);{

    return (*env)->NewStringUTF(env, "Hello from JNI !");
}
