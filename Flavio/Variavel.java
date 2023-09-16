public class Variavel {
    private String id;
    private String type;
    private String value;

    Variavel(String id, String type, String value){
        this.id = id;
        this.type = type;
        setValue(value);
    }

    public String setValue(String value){
        if(type.equals("integer"))
        {
            for(int i = 0; i < value.length(); i++)
            {
                if(Character.isLetter(value.charAt(i)))
                {
                    return "ERRO";
                }
            }

            this.value = value;
        }
        else if(type.equals("boolean"))
        {
            if(value.equals("false") || value.equals("true"))
            {
                this.value = value;
            }
            else
            {
                return "ERRO";
            }
        }
        else if(type.equals("float"))
        {

        }
        else if(type.equals("double"))
        {

        }
        else //SE FOR TIPO STRING
        {
            this.value = value;
        }

        return "ok";
    }

    public String getID(){
        return id;
    }

    public String getType(){
        return type;
    }

    public String getValue(){
        return value;
    }
}