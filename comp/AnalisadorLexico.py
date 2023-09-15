import re

entrada = "String teste = \"teste 9999 akk\""
lexema = "start"
tabela = []
string = False

def TEXTO(word: str) -> bool:
    return bool(re.match(r'"[^"]*"', word))
def STRING(word: str) -> bool:
    return bool(re.match(r'String', word))
def ID(word: str) -> bool:
    return bool(re.match(r'\w+', word))
def ATTR(word: str) -> bool:
    return bool(re.match(r'=', word))

while lexema:
    lexema = ""
    for i in entrada:
        if i == "\"":
            string = True
        if string:
            if "\"":
                break
            lexema += i
        else:
            if i == " ":
                break
            lexema += i
        i = ""      
    if TEXTO(lexema):
        tabela.append("TEXTO")
    elif STRING(lexema):
        tabela.append("String")
    elif ID(lexema):
        tabela.append("ID")
    elif ATTR(lexema):
        tabela.append("ATTR")
        
print(tabela)





