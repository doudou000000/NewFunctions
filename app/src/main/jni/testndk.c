#include <jni.h>

JNIEXPORT jstring JNICALL Java_cpf_com_testlauncher_test_1ndk_TestNDK_getStringFromNative(JNIEnv *env,jclass type);
{
return (*env)->NewStringUTF(env, returnValue);
}