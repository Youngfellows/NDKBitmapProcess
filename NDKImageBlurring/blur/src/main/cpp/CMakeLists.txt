#cmake支持最小版本
cmake_minimum_required(VERSION 3.4.1)

#设置项目名称
project(blur)

#设置生成的so动态库最后输出的路径
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/../jniLibs/${ANDROID_ABI})

#源文件
aux_source_directory(./ BLUR_SRC)

#生成动态库
add_library(genius_blur SHARED ${BLUR_SRC})

#连接库文件
target_link_libraries(genius_blur m log jnigraphics)