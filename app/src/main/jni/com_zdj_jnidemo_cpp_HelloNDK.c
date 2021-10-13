//
// Created by Dejin Zhang on 10/11/21.
//
#include "com_zdj_jnidemo_cpp_HelloNDK.h"

JNIEXPORT jstring JNICALL Java_com_zdj_jnidemo_cpp_HelloNDK_stringFromNDK
  (JNIEnv *env, jclass thiz) {
    return (*env)->NewStringUTF(env, "this is a android ndk hello.");
}

