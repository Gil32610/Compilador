import java.util.LinkedList;

class Main{
    static LinkedList<String> tokens = new LinkedList<>();
    static LinkedList<String> op = new LinkedList<>();
    static LinkedList<Variavel<?>> id = new LinkedList<>();

    public static void main(String[] args) {
        String text = "int opa = 10; opa";
        String lexema = "";

        for(int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if(c == ' ' || isOperator(Character.toString(c)))
            {
                if(isToken(lexema) == false && isOperator(lexema) == false)
                {
                    if(findId("lexema") == false)
                    {
                        String token = tokens.removeFirst();
                        if(token.equals("int"))
                        {
                            Variavel<Integer> inteiro = new Variavel<>(lexema, 0);
                            id.addLast(inteiro);
                        }
                        else if(token.equals("boolean"))
                        {
                            Variavel<Boolean> booleana = new Variavel<>(lexema, null);
                            id.addLast(booleana);
                        }
                        else if(token.equals("float"))
                        {
                            Variavel<Float> decimal = new Variavel<>(lexema, null);
                            id.addLast(decimal);
                        }
                    }
                }
                else if(isToken(lexema))
                {
                    tokens.addLast(lexema);
                }
                else //E OPERADOR
                {
                    op.addLast(lexema);
                }
                lexema = "";
            }
            else if(c == ';')
            {

            }
            else
            {
                lexema = lexema + c;
            }
        }

        System.out.println("acabou");
    }

    public static boolean isToken(String text){
        for(EnumLexico e : EnumLexico.values())
        {
            if(text.equals(e.getDescription()))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isOperator(String text){
        for(EnumOperador e : EnumOperador.values())
        {
            if(text.equals(e.getDescription()))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean findId(String name){
        if(id.isEmpty())
        {
            return false;
        }

        for(int i = 0; i < id.size(); i++)
        {
            Variavel<?> var = id.get(i);
            if(name.equals(var.getID()))
            {
                return true;
            }
        }
        return false;
    }
}