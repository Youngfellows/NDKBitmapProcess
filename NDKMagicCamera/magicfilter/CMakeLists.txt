cmake_minimum_required(VERSION 3.4.1)

#设置生成的so动态库最后输出的路径
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/jniLibs/${ANDROID_ABI})

file(GLOB SOURCES
        "src/main/cpp/*.cpp"
        "src/main/cpp/beautify/*.cpp"
        "src/main/cpp/bitmap/*.cpp")
add_library(MagicBeautify SHARED ${SOURCES})

find_library(android-lib android)
find_library(log-lib log)

target_link_libraries(
        MagicBeautify
        jnigraphics
        ${android-lib}
        ${log-lib})
