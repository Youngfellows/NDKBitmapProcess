cmake_minimum_required(VERSION 3.4.1)

#设置生成的so动态库最后输出的路径
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/jniLibs/${ANDROID_ABI})
#set(LOCAL_CFLAGS "${LOCAL_CFLAGS} -DDISABLE_IMPORTGL -DANDROID_NDK")

file(GLOB SOURCES "src/main/cpp/*.c")
add_library(photoprocessing SHARED ${SOURCES})

find_library(log-lib log)
find_library(android-lib android)

target_link_libraries(
    photoprocessing
    m
    jnigraphics
    ${log-lib}
    ${android-lib}
)
