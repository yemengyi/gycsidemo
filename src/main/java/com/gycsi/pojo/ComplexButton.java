package com.gycsi.pojo;

/**
 * Created by qian-pc on 7/14/16.
 */
public class ComplexButton extends BaseButton{
    private BaseButton[] sub_button;

    public BaseButton[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(BaseButton[] sub_button) {
        this.sub_button = sub_button;
    }
}
