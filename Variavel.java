public class Variavel <t> {

    private String id;
    private t info;

    Variavel(String id, t info){
        this.id = id;
        this.info = info;
    }

    public String getID(){
        return id;
    }

    public t getInfo(){
        return info;
    }

    public void setInfo(t info){
        this.info = info;
    }
}