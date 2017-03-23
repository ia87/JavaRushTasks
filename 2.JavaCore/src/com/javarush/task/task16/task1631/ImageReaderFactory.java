package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by And on 06.03.2017.
 */
public class ImageReaderFactory {
    public  static ImageReader getImageReader(ImageTypes imageType) throws IllegalArgumentException{
        if (ImageTypes.BMP.equals(imageType)) return new BmpReader();
        if (ImageTypes.JPG.equals(imageType)) return new JpgReader();
        if (ImageTypes.PNG.equals(imageType)) return new PngReader();
        throw new IllegalArgumentException("Неизвестный тип картинки");
//        return null;
    }
}
