//
// Created by F2847881 on 2023/1/7.
//

#ifndef IMAGEEDITOR_ANDROID_FILTER_H
#define IMAGEEDITOR_ANDROID_FILTER_H

#include "bitmap.h"

void applyInstafix(Bitmap *bitmap);

void applyAnselFilter(Bitmap *bitmap);

void applyTestino(Bitmap *bitmap);

void applyXPro(Bitmap *bitmap);

void applyRetro(Bitmap *bitmap);

void applyBlackAndWhiteFilter(Bitmap *bitmap);

void applySepia(Bitmap *bitmap);

void applyCyano(Bitmap *bitmap);

void applyGeorgia(Bitmap *bitmap);

int applySahara(Bitmap *bitmap);

int applyHDR(Bitmap *bitmap);

#endif; //IMAGEEDITOR_ANDROID_FILTER_H
