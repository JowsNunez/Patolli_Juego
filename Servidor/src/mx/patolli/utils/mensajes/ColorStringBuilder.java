package mx.patolli.utils.mensajes;

public class ColorStringBuilder implements IColorString{

    private ColorString colorString;

    public ColorStringBuilder(){

        this.colorString = new ColorString();
    }





    @Override
    public ColorStringBuilder messageColor(Color color, String message){

        this.colorString.setMessage(color.getValue() + message);
        return this;

    }

    public ColorString build() {
        return colorString;
    }


}
