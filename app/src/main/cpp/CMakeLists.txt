cmake_minimum_required(VERSION 3.10)
set(CMAKE_C_FLAGS "$CMAKE_C_FLAGS")
add_library(native_app_glue STATIC ${ANDROID_NDK}/sources/android/native_app_glue/android_native_app_glue.c)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -Wall -Werror")

# Export ANativeActivity_onCreate(),
# Refer to: https://github.com/android-ndk/ndk/issues/381.
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -u ANativeActivity_onCreate")

add_library(native-activity SHARED main.cpp)
target_include_directories(native-activity PRIVATE ${ANDROID_NDK}/sources/android/native_app_glue)
target_link_libraries(native-activity android native_app_glue EGL GLESv1_CM log)
