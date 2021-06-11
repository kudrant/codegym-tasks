package com.codegym.task.task16.task1631;

import com.codegym.task.task16.task1631.common.*;

public class ImageReaderFactory implements ImageReader {
    public static ImageReader getImageReader(ImageTypes imageType) {
        try {
            switch (imageType) {
                case BMP:
                    return new BmpReader();
                case JPG:
                    return new JpgReader();
                case PNG:
                    return new PngReader();
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Unknown image type");
        }
        return null;
    }
}
