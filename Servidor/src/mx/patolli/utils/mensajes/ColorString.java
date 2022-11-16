package mx.patolli.utils.mensajes;

public class ColorString {
    private String message;
    private String name;

    public ColorString(){
        this.message ="";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message +=" " + message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String toString(){
        return this.message;
    }



}




