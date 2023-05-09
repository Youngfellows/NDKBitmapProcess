//
// Created by F2847881 on 2023/1/7.
//

#ifndef IMAGEEDITOR_ANDROID_BICUBIC_RESIZE_H
#define IMAGEEDITOR_ANDROID_BICUBIC_RESIZE_H

int resizeChannelBicubic(const unsigned char *src, int srcWidth, int srcHeight, unsigned char *dst,
                         int dstWidth, int dstHeight);

#endif; //IMAGEEDITOR_ANDROID_BICUBIC_RESIZE_H
