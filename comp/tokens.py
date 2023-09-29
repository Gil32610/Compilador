import re
class token:
    def __init__(self, dict) -> None:
        self.tolken_table = []
        self.dict = dict
        self.enders = [';', '{', '}']
        
    def add(self, input: str) -> None:
        if input in self.dict.reserved_word_dict:
            self.tolken_table.append(self.dict.reserved_word_dict[input])
        elif bool(re.match(';', input)):
            self.tolken_table.append(';')
        elif bool(re.match(r'"[^"]*"', input)):
            self.tolken_table.append('TEXTO')
        elif bool(re.match(r'[_a-zA-Z][_a-zA-Z0-9]+', input)):
            self.tolken_table.append('ID')
        elif bool(re.match(r'=', input)):
            self.tolken_table.append('ATTR')
        elif bool(re.match(r'^-?\b\d+\b', input)):
            self.tolken_table.append('NUM_INT')
        elif bool(re.match(r'\d+\.\d+', input)):
            self.tolken_table.append('NUM_DEC')
        else:
            raise Exception('Not valid')
        