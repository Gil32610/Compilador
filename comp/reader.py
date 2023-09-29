class reader:
    def __init__(self, dict, tolken, path: str) -> None:
        self.tkn = tolken
        self.dct = dict
        self.path = path
        
    def read(self):
        lexema = ""
        open_string = False
        open_comment = False
        
        with open(self.path, 'r+') as entrada:
            content = entrada.read()
    
    
            for i in content:
                if i == '"' and not open_string and not open_comment:
                    lexema+=i
                    open_string = not open_string
                elif(lexema == '//' and not open_comment):
                    lexema = ''
                    open_comment = not open_comment
                else:
                    if open_string:
                        if i == '"':
                            open_string = not open_string
                            lexema += i
                            self.tkn.add(lexema)
                            lexema = ''
                        else: 
                            lexema+=i
                    elif open_comment:
                        if i == '\n':
                            open_comment = not open_comment
                            continue
                    else:
                        if i == ' ':
                            if lexema == '':
                                continue
                            else:
                                self.tkn.add(lexema)
                                lexema = ''
                        elif i == ';':
                            if lexema == '':
                                lexema+=i
                                self.tkn.add(lexema)
                                lexema = ''
                            else:
                                self.tkn.add(lexema)
                                lexema = ''
                                lexema += i
                                self.tkn.add(lexema)
                                lexema = ''
                        elif i == '\n':
                            if self.tkn.tolken_table[-1] not in self.tkn.enders:
                                raise Exception('You forgot some \';\'')
                        else:
                            lexema += i
            if(open_string):
                raise Exception('An string is open')