//
// Created by F2847881 on 2023/1/7.
//

#ifndef IMAGEEDITOR_ANDROID_BLUR_H
#define IMAGEEDITOR_ANDROID_BLUR_H

int stackBlur(float *radius, unsigned char *srcRed, unsigned char *srcGreen, unsigned char *srcBlue,
              int *width, int *height,
              unsigned char *dstRed, unsigned char *dstGreen, unsigned char *dstBlue);

#endif //IMAGEEDITOR_ANDROID_BLUR_H
