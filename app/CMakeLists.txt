cmake_minimum_required(VERSION 3.10.2)

add_library(# 设置so文件名称.
        hellondk
        # 设置这个so库文件为共享.
        SHARED
        # 设置c文件源码位置.
        src/main/jni/com_zdj_jnidemo_cpp_HelloNDK.c)