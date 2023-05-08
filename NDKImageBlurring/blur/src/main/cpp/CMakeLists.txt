#cmake支持最小版本
cmake_minimum_required(VERSION 3.4.1)

#设置项目名称
project(blur)

#源文件
aux_source_directory(./ BLUR_SRC)

#生成动态库
add_library(genius_blur SHARED ${BLUR_SRC})

#连接库文件
target_link_libraries(genius_blur m log jnigraphics)