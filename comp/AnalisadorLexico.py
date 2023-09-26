import re

lexema = ""
tabela = []
open_string = False

dicio_reserved_word = {
    'int': 'int',
    'String': 'String',
    'double': 'double',
    'float': 'float',
    'char': 'char',
    'boolean': 'boolean',
    'void': 'void',
    'if': 'if',
    'else': 'else',
    'for': 'for',
    'while': 'while',
    'scanf': 'scanf',
    'println': 'println',
    'main': 'main',
    'return': 'return',
    'break': 'break',
    'continue': 'continue',
    'private': 'private',
    'public': 'public'
}

def add_to_symbol_table(input: str, table):
        if input in dicio_reserved_word:
            table.append(dicio_reserved_word[input])
        elif bool(re.match(';', input)):
            table.append(';')
        elif bool(re.match(r'"[^"]*"', input)):
            table.append('TEXTO')
        elif bool(re.match(r'\w+', input)):
            table.append('ID')
        elif bool(re.match(r'=', input)):
            table.append('ATTR')
        elif bool(re.match(r'\d+', input)):
            table.append('NUM_INT')
        elif bool(re.match(r'\d+\.\d+', input)):
            table.append('NUM_DEC')
        else:
            raise Exception('Not valid')

with open('Flavio/ArquivoAqui/arquivo.txt', 'r+') as entrada:
    content = entrada.read()
    print(content)
    
    for i in content:
        if i == '\"' and not open_string:
            lexema+=i
            open_string = not open_string
        else:
            if open_string:
                if i == '\"':
                    open_string = not open_string
                    lexema += i
                    add_to_symbol_table(lexema, tabela)
                    lexema = ''
                else: 
                    lexema+=i
            else:
                if i == ' ':
                    add_to_symbol_table(lexema, tabela)
                    lexema = ''
                elif i == ';':
                    lexema+=i
                    add_to_symbol_table(lexema, tabela)
                    lexema = ''
                elif i == '\n':
                    if tabela[-1] != ';':
                        raise Exception('You forgot some \';\'')
                else:
                    lexema += i
    if(open_string):
        raise Exception('An string is open')
    print(tabela)