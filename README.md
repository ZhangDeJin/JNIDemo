# JNIDemo
一个基础的JNIDemo

下面写下jni开发的流程：
1、在Java中声明native方法

举例如下：
public static native String stringFromNDK();

2、编译Java源文件得到class文件，然后通过javah命令导出JNI的头文件

举例如下：
先make project，然后我们先去app/build/intermediates/javac/debug/classes看看，
注意不同版本的AndroidStudio这里的目录可能不同，反正自己多找找就行了，然后我们直接在AndroidStudio的Terminal中，
先定位到该文件夹，然后执行javah -jni com.zdj.jnidemo.cpp.HelloNDK

3、实现JNI方法

举例如下：
即编写c/c++的源代码

4、编译so库并在Java中调用

举例如下，在高版本中，我们直接build是无法生存so库的，即使我们进行这样设置android.useDeprecatedNdk=true也不行，
此时我们是使用CMake的，最终生成了so库，生成的so库位于app/build/intermediates/cmake中。

然后我们就可以使用我们的本地代码了。
注意：如果是直接在我们生成的so库的项目中，不能再在app/src/main下建立jniLibs文件夹，并将我们生成的so库放入其中了，
这会造成重复冲突，会报"more than one files was found with OS independent path 'lib/arm64-v8a/xxx.so'"

如果我们是在一个新的项目中，那么需要在app/src/main下建立jniLibs文件夹，并且将我们的so库放入其中，另外对应的java代码
（java sdk）也需要导入进来，注意文件夹的名称需要是jniLibs，如果我们是使用其他的名称，则需要在该module的build.gradle
中进行配置如下：
sourceSets.main {
    jniLibs.srcDir 'src/main/xxx'
}
因为默认Android Studio只能识别jniLibs文件夹中so库。
