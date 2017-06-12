package com.gl.ecom.data.model;

import com.gl.ecom.data.others.ColorEnum;
import com.gl.ecom.data.others.TypeEnum;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Moco extends Product {

    private ColorEnum colorEnum;

    public Moco(){

    }

    public Moco(String id, String label, TypeEnum typeEnum, ColorEnum colorEnum) {
        super(id,label, typeEnum);
        this.colorEnum = colorEnum;
    }

    public ColorEnum getColorEnum() {
        return colorEnum;
    }

    public void setColorEnum(ColorEnum color) {
        this.colorEnum = color;
    }
}
