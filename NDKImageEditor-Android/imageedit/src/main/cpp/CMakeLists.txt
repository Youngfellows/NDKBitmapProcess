# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# 查找父目录3rd
message(STATUS "CMAKE_CURRENT_SOURCE_DIR::${CMAKE_CURRENT_SOURCE_DIR}")
get_filename_component(JNI_LIBS_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../.. ABSOLUTE)
message(STATUS "JNI_LIBS_DIR::${JNI_LIBS_DIR}")

set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${JNI_LIBS_DIR}/jniLibs/${ANDROID_ABI})

set(LOCAL_CFLAGS " -DANDROID_NDK -DDISABLE_IMPORTGL")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        photoprocessing

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        nanojpeg.c
        mem_utils.c
        bitmap.c
        bicubic_resize.c
        filter.c
        transform.c
        colour_space.c
        matrix.c
        blur.c
        photo_processing.c)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)


# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        photoprocessing

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib}
        jnigraphics
#        GLESv3
        android
        EGL
        log)